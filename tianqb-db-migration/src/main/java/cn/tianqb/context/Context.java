package cn.tianqb.context;

import cn.tianqb.entity.Entity;

/**
 * 系统上下文
 *
 * 可以包含一切对象
 *
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:58
 */
public class Context {
    private static ThreadLocal<Entity> threadLocal = new ThreadLocal<>();

    public static void set(Entity entity) {
        threadLocal.set(entity);
    }

    public static Entity get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
