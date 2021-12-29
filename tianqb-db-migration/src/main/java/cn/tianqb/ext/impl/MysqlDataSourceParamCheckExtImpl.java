package cn.tianqb.ext.impl;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.common.utils.Assert;
import cn.tianqb.constant.ExtConstant;
import cn.tianqb.context.Context;
import cn.tianqb.entity.DataSource;
import cn.tianqb.ext.DataSourceParamCheckExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 17:29
 */
@Component
@Slf4j
@Extension(extClass = DataSourceParamCheckExt.class, key = ExtConstant.DATA_SOURCE_MYSQL)
public class MysqlDataSourceParamCheckExtImpl implements DataSourceParamCheckExt {

    @Override
    public void handler() {
        DataSource dataSource = Context.get().getDataSource();
        Assert.isEmpty(dataSource.getUsername(), "mysql username is null");
        Assert.isEmpty(dataSource.getPassword(), "mysql password is null");
        Assert.isEmpty(dataSource.getUrl(), "mysql url is null");
        Assert.isEmpty(dataSource.getDriver(), "mysql driver is null");
    }
}