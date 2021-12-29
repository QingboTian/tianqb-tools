package cn.tianqb.controller;

import cn.tianqb.common.utils.WebResult;
import cn.tianqb.context.Context;
import cn.tianqb.entity.DataSource;
import cn.tianqb.entity.Entity;
import cn.tianqb.handler.datasource.DataSourceParamCheckHandler;
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
        Entity entity = new Entity();
        entity.setDataSource(dataSource);
        Context.set(entity);
        getBean("apip").
        new AbstractMigrationHandler.Builder()
                .next(new DataSourceParamCheckHandler())
                .next(new )
                .next()
                .build()
                .run();
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
