package cn.tianqb.migration.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:58
 */
@Getter
@Setter
@ToString
public class Entity {

    private DataSource dataSource;

    /**
     * 业务身份
     */
    private String businessType;
}
