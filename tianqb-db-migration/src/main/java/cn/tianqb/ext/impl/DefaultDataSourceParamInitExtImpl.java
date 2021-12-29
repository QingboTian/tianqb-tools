package cn.tianqb.ext.impl;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.constant.ExtConstant;
import cn.tianqb.context.Context;
import cn.tianqb.entity.DataSource;
import cn.tianqb.ext.DataSourceParamInitExt;
import cn.tianqb.utils.LoginHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Extension(extClass = DataSourceParamInitExt.class, key = ExtConstant.DEFAULT)
public class DefaultDataSourceParamInitExtImpl implements DataSourceParamInitExt {

    @Override
    public void handler() {
        DataSource dataSource = Context.get().getDataSource();
        dataSource.setCreator(LoginHelper.getUsername());
    }
}
