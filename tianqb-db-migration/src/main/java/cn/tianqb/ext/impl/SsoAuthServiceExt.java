package cn.tianqb.ext.impl;

import cn.tianqb.context.LoginContext;
import cn.tianqb.ext.AuthServiceExt;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过单点登录进行权限验证
 * 此处为Demo
 *
 * 推荐将用户信息写入
 * @see LoginContext
 *
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 16:06
 */
//@Service
@Slf4j
//@Primary
public class SsoAuthServiceExt implements AuthServiceExt {
    @Override
    public boolean auth(HttpServletRequest request, HttpServletResponse response) {
        // 具体逻辑实现
        // 如可以接入自己公司部门的单点登录服务
        // 也可以实现自己的登录、权限服务
        return true;
    }
}
