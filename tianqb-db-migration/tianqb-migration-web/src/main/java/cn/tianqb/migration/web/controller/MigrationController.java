package cn.tianqb.migration.web.controller;

import cn.tianqb.migration.domain.MigrationEntity;
import cn.tianqb.migration.web.service.MigrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 16:50
 */
@RestController
@RequestMapping("/migration")
@Slf4j
public class MigrationController {

    @Autowired
    private MigrationService migrationService;

    @PostMapping("/run")
    public Long run(@RequestBody MigrationEntity entity) {
        log.info("migration entity = {}", entity);
        return migrationService.run(entity);
    }

}
