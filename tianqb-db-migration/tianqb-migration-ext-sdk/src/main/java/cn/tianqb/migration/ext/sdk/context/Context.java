package cn.tianqb.migration.ext.sdk.context;

import java.util.Collections;
import java.util.Map;

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
    private static ThreadLocal<Map<String, Map<Class<?>, Object>>> threadLocal = new ThreadLocal<>();

    final private static String RESPONSE = "response";

    public static void set(String key, Object value, Class<?> clazz) {
        threadLocal.set(Collections.singletonMap(key, Collections.singletonMap(clazz, value)));
    }

    public static void setResponse(Object value, Class<?> clazz) {
        threadLocal.set(Collections.singletonMap(RESPONSE, Collections.singletonMap(clazz, value)));
    }

    public static <T> T get(String key, Class<T> clazz) {
        Map<String, Map<Class<?>, Object>> data = threadLocal.get();
        if (data == null) {
            return null;
        }
        Map<Class<?>, Object> value = data.get(key);
        if (value == null) {
            return null;
        }
        return clazz.cast(value.get(clazz));
    }

    /**
     * 获取上下文中的返回值
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T response(Class<T> clazz) {
        return get(RESPONSE, clazz);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
