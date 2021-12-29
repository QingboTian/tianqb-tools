package cn.tianqb.ext.impl;

import cn.tianqb.context.LoginContext;
import cn.tianqb.ext.AuthServiceExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认权限验证 此处返回固定值 可扩展
 *
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:05
 */
@Service
@Slf4j
public class DefaultAuthServiceExt implements AuthServiceExt {
    @Override
    public boolean auth(HttpServletRequest request, HttpServletResponse response) {
        LoginContext.UserInfo userInfo = new LoginContext.UserInfo();
        userInfo.setUsername("tianqb");
        LoginContext.set(userInfo);
        return true;
    }
}
