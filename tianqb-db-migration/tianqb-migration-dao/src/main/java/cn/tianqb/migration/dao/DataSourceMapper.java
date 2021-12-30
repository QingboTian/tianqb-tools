package cn.tianqb.migration.dao;


import cn.tianqb.migration.domain.DataSource;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/30 17:05
 */
public interface DataSourceMapper extends Mapper<DataSource>, MySqlMapper<DataSource> {
}
