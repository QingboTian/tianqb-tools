package cn.tianqb.service;

import cn.tianqb.entity.MigrationEntity;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:25
 */
public interface MigrationService {

    /**
     * 数据迁移
     * @param entity
     * @return
     */
    Long run(MigrationEntity entity);

}
