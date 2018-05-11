package org.lxp.dailylog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxp.dailylog.web.util.SessionHelper;
import org.slf4j.MDC;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

public class LogFilter extends AbstractRequestLoggingFilter {
    private static final String REQUESTID_KEY = "request_id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestId = SessionHelper.getRequestId(request);
        try {
            MDC.put(REQUESTID_KEY, String.format("%s=\"%s\" ", REQUESTID_KEY, requestId));
            response.setHeader(REQUESTID_KEY, requestId);
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        // do nothing
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        // do nothing
    }
}