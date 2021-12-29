package cn.tianqb.handler.datasource;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.constant.ExtConstant;
import cn.tianqb.context.Context;
import cn.tianqb.entity.DataSource;
import cn.tianqb.entity.Entity;
import cn.tianqb.ext.DataSourceParamCheckExt;
import cn.tianqb.service.AbstractMigrationHandler;
import org.springframework.stereotype.Component;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:54
 */
@Component
public class DataSourceParamCheckHandler extends AbstractMigrationHandler {

    @Override
    public void handler() {
        Entity entity = Context.get();
//        Assert.isEmpty(entity, "context entity is null");
        DataSource dataSource = Context.get().getDataSource();
//        Assert.isEmpty(dataSource, "datasource is null");
//        Assert.isEmpty(dataSource.getType(), "datasource type is null");
        ExtensionHolder
                .getBean(DataSourceParamCheckExt.class, ExtConstant.ext(ExtConstant.DATA_SOURCE, dataSource.getType()))
                .handler();
    }
}
