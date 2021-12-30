package cn.tianqb.migration.ext.impl.defaul;

import cn.tianqb.common.extension.annotation.Extension;
import cn.tianqb.migration.dao.DataSourceMapper;
import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.ext.sdk.constant.ExtConstant;
import cn.tianqb.migration.ext.sdk.context.Context;
import cn.tianqb.migration.ext.sdk.datasource.DataSourcePersistentExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/30 17:01
 */
@Component
@Slf4j
@Extension(extClass = DataSourcePersistentExt.class, key = ExtConstant.DEFAULT)
public class DefaultDataSourcePersistentExtImpl implements DataSourcePersistentExt {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public void handler() {
        int res = dataSourceMapper.insert(Context.get("dataSource", DataSource.class));
        if (res > 0) {
            Context.setResponse(true, Boolean.class);
        } else {
            Context.setResponse(false, Boolean.class);
        }
    }
}
