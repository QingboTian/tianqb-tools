package cn.tianqb.ext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/29 15:26
 */
public interface AuthServiceExt {

    /**
     * 权限验证
     * @param request
     * @param response
     * @return
     */
    boolean auth(HttpServletRequest request, HttpServletResponse response);

}
