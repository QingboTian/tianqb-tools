package cn.tianqb.migration.web.controller;

import cn.tianqb.common.utils.WebResult;
import cn.tianqb.migration.domain.DataSource;
import cn.tianqb.migration.ext.sdk.context.Context;
import cn.tianqb.migration.web.context.PipelineHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:31
 */
@RestController
@RequestMapping("/dataSource")
@Slf4j
public class DataSourceController {

    @PostMapping
    public WebResult<Boolean> create(@RequestBody DataSource dataSource) {
        Context.set("dataSource", dataSource, DataSource.class);
        PipelineHelper.run("cn.tianqb.migration.web.service.impl.DataSourceServiceImpl.create");
        return null;
    }

    @DeleteMapping("/{id}")
    public WebResult<Boolean> delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping
    public WebResult<Boolean> update(@RequestBody Object object) {
        return null;
    }

    @GetMapping
    public WebResult<Boolean> list(Object object) {
        return null;
    }

    @GetMapping("/{id}")
    public WebResult<Boolean> get(@PathVariable Long id) {
        return null;
    }

}
