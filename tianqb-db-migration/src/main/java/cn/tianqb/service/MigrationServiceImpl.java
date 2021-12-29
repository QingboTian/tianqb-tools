package cn.tianqb.service;

import cn.tianqb.entity.MigrationEntity;
import cn.tianqb.common.utils.Assert;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:25
 */
@Service
@Slf4j
public class MigrationServiceImpl implements MigrationService {

    @Autowired
    private JdbcTemplate source;
    @Autowired
    private JdbcTemplate target;

    @Override
    public Long run(MigrationEntity entity) {
        // 参数检查、安全检查
        check(entity);
        // 连接检查
        connectCheck();
        // init
        init(entity);

        // query
        List<Map<String, Object>> sourceList = null;
        try {
            sourceList = source.queryForList(entity.getQuery());
        } catch (Exception ex) {
            String msg = String.format("数据查询失败，SQL = %s", entity.getQuery());
            log.error(msg, ex);
        }
        Assert.isEmpty(sourceList, "请确认查询SQL是否正确");
        log.info("查询的数据大小：size = {}", sourceList.size());

        // 获取insert sql
        String insert = buildInsertSql(entity, sourceList);
        log.info("insert sql: {}", insert);

        List<Object[]> collect = sourceList
                .stream()
                .map(map -> map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()).toArray())
                .collect(Collectors.toList());
        // 分组 控制批量插入大小
        List<List<Object[]>> partition = Lists.partition(collect, entity.getBatchSize());
        AtomicLong count = new AtomicLong(0);
        partition.forEach(values -> {
            try {
                int[] ints = target.batchUpdate(insert, values);
                count.addAndGet(ints.length);
            } catch (Exception ex) {
                log.error("批量插入数据失败", ex);
            }
        });
        log.info("查询条数{}，插入条数{}", sourceList.size(), count.get());
        return count.get();
    }

    /**
     * 构建插入sql
     *
     * @param entity     entity
     * @param sourceList list
     * @return insert sql
     */
    private String buildInsertSql(MigrationEntity entity, List<Map<String, Object>> sourceList) {
        String insertFields;
        int fieldCount;
        if (ObjectUtils.isEmpty(entity.getMapping())) {
            // 采用查询结果字段
            Map<String, Object> data0 = sourceList.get(0);
            fieldCount = data0.size();
            insertFields = data0.entrySet().stream()
                    .map(field -> "`" + field.getKey() + "`")
                    .collect(Collectors.joining(","));
        } else {
            // 采用用户自定义mapping
            List<MigrationEntity.Field> mapping = entity.getMapping();
            fieldCount = mapping.size();
            insertFields = mapping.stream()
                    .map(field -> "`" + field.getTarget() + "`")
                    .collect(Collectors.joining(","));
        }

        StringJoiner q = new StringJoiner(",");
        while (fieldCount > 0) {
            q.add("?");
            fieldCount--;
        }

        StringJoiner insert = new StringJoiner(" ");
        insert
                .add("INSERT INTO")
                .add("`" + entity.getDataSource().getTarget().getTable() + "`")
                .add("(" + insertFields + ")")
                .add("VALUES")
                .add("(" + q.toString() + ")");
        return insert.toString();
    }

    /**
     * 数据初始化
     *
     * @param entity entity
     */
    private void init(MigrationEntity entity) {
        entity.setBatchSize(Optional.ofNullable(entity.getBatchSize()).orElse(1000));
//        DataSourceEntity.Config targetConfig = entity.getDataSource().getTarget();
//        DataSourceEntity.Config sourceConfig = entity.getDataSource().getSource();
//        DataSource dbSource = getDataSource(sourceConfig.getUsername(), sourceConfig.getPassword(), sourceConfig.getUrl());
//        DataSource dbTarget = getDataSource(targetConfig.getUsername(), targetConfig.getPassword(), targetConfig.getUrl());
//        source.setDataSource(dbSource);
//        target.setDataSource(dbTarget);
    }

    /**
     * 连接检查
     */
    private void connectCheck() {
        Assert.isEmpty(source, "data source is null");
        Assert.isEmpty(target, "data target is null");
    }

    /**
     * 参数检查
     *
     * @param entity entity
     */
    private void check(MigrationEntity entity) {
        Assert.isEmpty(entity, "entity is null");
        Assert.isEmpty(entity.getQuery(), "query is empty");
//        Assert.isEmpty(entity.getDataSource(), "data source is null");
//        Assert.isEmpty(entity.getDataSource().getTarget(), "target config is null");
//        Assert.isEmpty(entity.getDataSource().getSource(), "source config is null");
        Assert.isEmpty(entity.getDataSource().getTarget().getTable(), "target table name is empty");
        // 检查查询sql中是否存在DML
        List<String> dml = Arrays.asList("INSERT", "DELETE", "UPDATE");
        String query = entity.getQuery().toUpperCase();
        boolean contain = query.contains(dml.get(0)) || query.contains(dml.get(1)) || query.contains(dml.get(2));
        Assert.isTrue(contain, "非法SQL");
    }

    /**
     * 获取指定的 data source
     * @param username
     * @param password
     * @param url
     * @return
     */
    private DruidDataSource getDataSource(String username, String password, String url) {
        Assert.isEmpty(username, "username is empty");
        Assert.isEmpty(password, "password is empty");
        Assert.isEmpty(url, "url is empty");

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        druidDataSource.setConnectionErrorRetryAttempts(2);
        druidDataSource.setFailFast(true);
        druidDataSource.setBreakAfterAcquireFailure(true);
        return druidDataSource;
    }

}
