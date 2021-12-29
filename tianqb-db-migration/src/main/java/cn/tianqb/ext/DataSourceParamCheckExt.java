package cn.tianqb.ext;

import cn.tianqb.common.extension.ExtensionHolder;
import cn.tianqb.constant.ExtConstant;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 17:01
 */
public interface DataSourceParamCheckExt extends ExtensionPoint<DataSourceParamCheckExt> {

    @Override
    default DataSourceParamCheckExt getDefault() {
        return ExtensionHolder.getBean(DataSourceParamCheckExt.class, ExtConstant.DEFAULT);
    }
}
