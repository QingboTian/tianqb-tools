package cn.tianqb.service;

import cn.tianqb.entity.MigrationEntity;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/21 9:53
 */
public class HandlerContext {

    private static ThreadLocal<MigrationEntity> threadLocal = new ThreadLocal<>();

    public static MigrationEntity get() {
        return threadLocal.get();
    }

    public static void set(MigrationEntity entity) {
        threadLocal.set(entity);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
