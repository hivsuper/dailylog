package org.lxp.dailylog.web.interceptor;

import static org.lxp.dailylog.exception.CodeEnum.NOT_LOGIN;
import static org.lxp.dailylog.web.util.StringHolder.USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxp.dailylog.web.util.JsonHelper;
import org.lxp.dailylog.web.util.JsonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean isLogin = request.getSession().getAttribute(USER) != null;
        if (isLogin) {
            LOG.debug("heart beat");
            return true;
        } else {
            LOG.error("{} need login", request.getRequestURL());
            response.getWriter().print(JsonHelper.toString(new JsonVo<String>(NOT_LOGIN, "not login")));
            return false;
        }
    }
}
