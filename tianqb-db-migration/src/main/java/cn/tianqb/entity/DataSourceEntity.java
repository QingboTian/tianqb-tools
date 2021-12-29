package cn.tianqb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:16
 */
@Getter
@Setter
@ToString
public class DataSourceEntity {

    /**
     * 数据源
     */
    private Config source;

    /**
     * 数据目标地址
     */
    private Config target;

    @Getter
    @Setter
    @ToString
    public static class Config {
        private String username;
        private String password;
        private String url;
        private String table;
    }
}
