import cn.tianqb.extension.Pipeline;
import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.domain.DataSourceEntity;
import cn.tianqb.migration.domain.MigrationEntity;
import cn.tianqb.migration.web.Application;
import cn.tianqb.migration.web.controller.DataSourceController;
import cn.tianqb.migration.web.service.MigrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 15:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test1 {

    @Autowired
    private MigrationService migrationService;

    @Autowired
    @Qualifier("cn.tianqb.migration.web.service.impl.DataSourceServiceImpl.create")
    private Pipeline pipeline;

    @Autowired
    private DataSourceController dataSourceController;

    @Test
    public void test1() {
        MigrationEntity entity = new MigrationEntity();
        entity.setQuery("select id, name from test_from");
        DataSourceEntity dataSourceEntity = new DataSourceEntity();
        DataSourceEntity.Config config = new DataSourceEntity.Config();
        config.setTable("test_target");
        dataSourceEntity.setTarget(config);
        entity.setDataSource(dataSourceEntity);
        List<MigrationEntity.Field> mapping = new ArrayList<>();
        mapping.add(new MigrationEntity.Field("id", "id"));
        mapping.add(new MigrationEntity.Field("name", "name"));
        entity.setMapping(mapping);
        entity.setBatchSize(2);
        migrationService.run(entity);
    }

    @Test
    public void test2() {
        System.out.println();
    }

    @Test
    public void test3() {
        DataSource dataSource = new DataSource();
        dataSource.setUsername("dev_user");
        dataSource.setPassword("Yz2bAJWjtAyeTW4d");
        dataSource.setUrl("jdbc:mysql://132.232.203.84:3306/dev?serverTimezone=UTC");
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSourceController.create(dataSource);
    }
}
