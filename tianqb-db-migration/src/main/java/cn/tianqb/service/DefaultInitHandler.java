package cn.tianqb.service;

import cn.tianqb.entity.MigrationEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 9:56
 */
@Slf4j
public class DefaultInitHandler extends AbstractMigrationHandler{

    @Override
    public void pre() {
        log.info("default init handler pre...");
    }

    @Override
    public void handler() {
        MigrationEntity entity = HandlerContext.get();
        entity.setBatchSize(Optional.ofNullable(entity.getBatchSize()).orElse(1000));
    }
}
