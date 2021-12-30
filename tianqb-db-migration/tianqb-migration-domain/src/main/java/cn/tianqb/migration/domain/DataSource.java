package cn.tianqb.migration.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:57
 */
@Getter
@Setter
@ToString(callSuper = true)
public class DataSource extends BaseEntity {

    private Integer type;

    private String username;

    private String password;

    private String url;

    private String driver;

    @Getter
    @AllArgsConstructor
    public enum Type {

        /**
         * MYSQL
         */
        MYSQL(1, "mysql"),
        /**
         * elastic search v2
         */
        ES2(2, "es2"),
        /**
         * elastic search v6
         */
        ES6(6, "es6");

        private Integer code;
        private String alias;
    }
}
