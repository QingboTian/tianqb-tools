package cn.tianqb.utils;

import cn.tianqb.context.LoginContext;

public class LoginHelper {

    public static String getUsername() {
        return LoginContext.get().getUsername();
    }

}
