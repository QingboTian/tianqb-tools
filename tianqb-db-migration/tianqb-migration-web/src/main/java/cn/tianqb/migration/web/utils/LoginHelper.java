package cn.tianqb.migration.web.utils;


import cn.tianqb.migration.web.context.LoginContext;

public class LoginHelper {

    public static String getUsername() {
        return LoginContext.get().getUsername();
    }

}
