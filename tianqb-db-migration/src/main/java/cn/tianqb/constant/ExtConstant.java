package cn.tianqb.constant;

import cn.tianqb.entity.DataSource;

import java.util.StringJoiner;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 17:01
 */
public class ExtConstant {

    final public static String DATA_SOURCE = "dataSource";

    final private static String SEPARATOR = ":";

    final public static String DEFAULT = "default";

    final public static String DATA_SOURCE_MYSQL = "mysql";

    public static String ext(String prefix, Object key) {
        StringJoiner sj = new StringJoiner(SEPARATOR);
        sj.add(prefix).add(key.toString());
        return sj.toString();
    }
}
