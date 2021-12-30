package cn.tianqb.migration.ext.sdk.datasource;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.extension.ExtensionPoint;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/30 16:58
 */
public interface DataSourcePersistentExt extends ExtensionPoint<DataSourcePersistentExt>{
    @Override
    default DataSourcePersistentExt getDefault() {
        return ExtensionHolder.getBean(DataSourcePersistentExt.class, ExtConstant.DEFAULT);
    }
}
