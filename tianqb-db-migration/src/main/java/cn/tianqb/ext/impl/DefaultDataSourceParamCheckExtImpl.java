package cn.tianqb.ext.impl;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.constant.ExtConstant;
import cn.tianqb.ext.DataSourceParamCheckExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Extension(extClass = DataSourceParamCheckExt.class, key = ExtConstant.DEFAULT)
public class DefaultDataSourceParamCheckExtImpl implements DataSourceParamCheckExt {

    @Override
    public void handler() {
        // empty
    }
}
