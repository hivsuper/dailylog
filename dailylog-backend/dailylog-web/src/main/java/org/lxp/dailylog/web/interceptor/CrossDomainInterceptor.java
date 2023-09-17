package org.lxp.dailylog.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainInterceptor extends HandlerInterceptorAdapter {
    private String domain;

    public CrossDomainInterceptor(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.setHeader("Access-Control-Allow-Origin", domain);
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Key");
        response.setHeader("access-control-allow-credentials", "true");
        response.setHeader("access-control-allow-methods", "GET,POST,PUT,DELETE,OPTIONS");
        return true;
    }
}
