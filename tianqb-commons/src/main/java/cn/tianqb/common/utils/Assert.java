package cn.tianqb.common.utils;

import cn.tianqb.common.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:31
 */
public class Assert {

    public static void isEmpty(@Nullable Object obj, String msg) {
        if (ObjectUtils.isEmpty(obj)) {
            throw new SystemException(HttpStatus.FORBIDDEN.value(), msg);
        }
    }

    public static void isTrue(@Nullable boolean exp, String msg) {
        if (exp) {
            throw new SystemException(HttpStatus.FORBIDDEN.value(), msg);
        }
    }

}
