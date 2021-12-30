package cn.tianqb.migration.web.service.impl;

import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.ext.sdk.context.Context;
import cn.tianqb.migration.web.context.PipelineHelper;
import cn.tianqb.migration.web.service.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/30 16:36
 */
@Service
@Slf4j
public class DataSourceServiceImpl implements DataSourceService {

    @Override
    public Boolean create(DataSource dataSource) {
        Context.set("dataSource", dataSource, DataSource.class);
        PipelineHelper.run("cn.tianqb.migration.web.service.impl.DataSourceServiceImpl.create");

        return null;
    }
}
