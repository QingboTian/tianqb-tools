package cn.tianqb.service;

import cn.tianqb.entity.MigrationEntity;
import cn.tianqb.utils.Assert;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 9:52
 */
@Slf4j
public class DefaultParamsValidHandler extends AbstractMigrationHandler {

    @Override
    public void pre() {
        log.info("");
    }

    @Override
    public void handler() {
        MigrationEntity entity = HandlerContext.get();
        Assert.isEmpty(entity, "migration entity is empty");
//        Assert.isEmpty(entity.getDataSource());
    }
}
