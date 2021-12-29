package cn.tianqb.entity;

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
@ToString
public class DataSource {

    private Integer type;

    private String username;

    private String password;

    private String url;

    private String driver;

}
