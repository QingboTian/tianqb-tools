package cn.tianqb.context;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户登录态上下文
 *
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 15:57
 */
public class LoginContext {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public static void set(UserInfo userInfo) {
        threadLocal.set(userInfo);
    }

    public static UserInfo get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

    @Getter
    @Setter
    @ToString
    public static class UserInfo {
        private String username;
        // ...
    }
}
