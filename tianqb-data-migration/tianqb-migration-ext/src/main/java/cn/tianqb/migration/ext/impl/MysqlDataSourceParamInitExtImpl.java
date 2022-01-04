package cn.tianqb.migration.ext.impl;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;
import cn.tianqb.migration.ext.sdk.context.Context;
import cn.tianqb.migration.ext.sdk.datasource.DataSourceParamCheckExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2022/1/4 14:12
 */
@Component
@Slf4j
@Extension(extClass = DataSourceParamCheckExt.class, key = ExtConstant.DATA_SOURCE_MYSQL)
public class MysqlDataSourceParamInitExtImpl implements DataSourceParamCheckExt {
    @Override
    public void handler() {
        DataSource dataSource = Context.get("dataSource", DataSource.class);
        dataSource.setDriver("com.mysql.jdbc.Driver");
    }
}
