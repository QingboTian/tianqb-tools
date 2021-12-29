package cn.tianqb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BaseEntity {

    private Long id;

    private Integer status;

    private String creator;

    private String modifier;

    private Date created;

    private Date modified;

}
