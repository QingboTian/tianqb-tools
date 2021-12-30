package cn.tianqb.migration.ext.sdk.datasource;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.extension.ExtensionPoint;

public interface DataSourceParamInitExt extends ExtensionPoint<DataSourceParamInitExt> {

    @Override
    default DataSourceParamInitExt getDefault() {
        return ExtensionHolder.getBean(DataSourceParamInitExt.class, "1");
    }
}
