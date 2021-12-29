package cn.tianqb.common.extension.annotation;

import java.lang.annotation.*;

/**
 * @author tianqb
 * @version 1.0
 * @date 2021/12/29 15:05
 **/
@Inherited()
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Extension {
    /**
     * 扩展接口
     *
     * @return
     */
    Class extClass();

    /**
     * 业务key
     *
     * @return
     */
    String key() default "";

    /**
     * 业务key 支持spel，spel返回值必须为字符串
     *
     * @return
     */
    String id() default "";
}
