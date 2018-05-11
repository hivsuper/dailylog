package org.lxp.dailylog.web.interceptor;

import static org.lxp.dailylog.exception.CodeEnum.NOT_LOGIN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxp.dailylog.web.util.JsonHelper;
import org.lxp.dailylog.web.util.JsonVo;
import org.lxp.dailylog.web.util.SessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String sessionIdFromClient = request.getParameter(SessionHelper.SESSION_ID);
        boolean isLogin = SessionHelper.getUser(sessionIdFromClient) != null;
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
