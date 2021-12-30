package cn.tianqb.migration.ext.impl.defaul;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;
import cn.tianqb.migration.ext.sdk.context.Context;
import cn.tianqb.migration.ext.sdk.datasource.DataSourceParamInitExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Extension(extClass = DataSourceParamInitExt.class, key = ExtConstant.DEFAULT)
public class DefaultDataSourceParamInitExtImpl implements DataSourceParamInitExt {

    @Override
    public void handler() {
        DataSource dataSource = Context.get("dataSource", DataSource.class);
        dataSource.setCreator("tianqingbo3");
    }
}
