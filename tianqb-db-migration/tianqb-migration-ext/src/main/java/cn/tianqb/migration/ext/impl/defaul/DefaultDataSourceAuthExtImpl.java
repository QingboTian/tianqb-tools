package cn.tianqb.migration.ext.impl.defaul;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;
import cn.tianqb.migration.ext.sdk.datasource.DataSourceAuthExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/30 16:41
 */
@Component
@Slf4j
@Extension(extClass = DataSourceAuthExt.class, key = ExtConstant.DEFAULT)
public class DefaultDataSourceAuthExtImpl implements DataSourceAuthExt {
    @Override
    public void handler() {

    }
}
