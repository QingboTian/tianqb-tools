package cn.tianqb.migration.web.context;

import cn.tianqb.migration.domain.DataSource;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:56
 */
public class DataSourceContext {
    private static ThreadLocal<DataSource> threadLocal = new ThreadLocal<>();

    public static void set(DataSource dataSource) {
        threadLocal.set(dataSource);
    }

    public static DataSource get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
