package org.lxp.dailylog.web.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.lxp.dailylog.exception.DailylogException;
import org.lxp.dailylog.web.util.IpUtil;
import org.lxp.dailylog.web.util.JsonHelper;
import org.lxp.dailylog.web.util.SessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * http://blog.csdn.net/xiaoxian8023/article/details/17285809<br/>
 * 
 * @Description: 全局日志类
 */
@Aspect
public class LoggerAspect {
    private static final Logger LOG = LoggerFactory.getLogger("apiLog");
    private static final String HOSTNAME = IpUtil.getHostName(IpUtil.getInetAddress());
    @Resource
    private HttpServletRequest request;

    // http://stackoverflow.com/questions/29653664/how-to-correctly-use-spring-aop-to-select-the-execution-of-a-method-annotated-wi
    @Pointcut("within(@org.springframework.stereotype.Controller *) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void logController() {
    };

    /**
     * 定义拦截器的切面
     */
    @Pointcut("execution(boolean org.lxp.dailylog.web.interceptor..preHandle(..))")
    private void logInterceptor() {
    };

    @Pointcut("logController() || logInterceptor()")
    private void logControllerAndInterceptor() {
    };

    @AfterReturning(value = "logController()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        try {
            LOG.info("{} || request={} || response={}", HOSTNAME, parseRequest(), JsonHelper.toString(returnValue));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @AfterThrowing(value = "logControllerAndInterceptor()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        try {
            if (e instanceof DailylogException) {
                DailylogException exception = (DailylogException) e;
                LOG.info("{} || request={} || exceptionCode={}, exceptionMessage={}", HOSTNAME, parseRequest(),
                        exception.getCodeEnum(), exception.getMessage());
            } else {
                LOG.info("{} || request={} || exceptionMessage={}", HOSTNAME, parseRequest(), e.getMessage());
            }
        } catch (Exception e1) {
            LOG.error(e.getMessage(), e);
        }
    }

    private StringBuilder parseRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getRequestURI()).append(", ");
        sb.append("IP->").append(IpUtil.getIpAddress(request));
        Map<String, String[]> parameters = request.getParameterMap();
        if (!parameters.isEmpty()) {
            sb.append(", parameters->[");
            final String template = "%s=%s, ";
            for (Map.Entry<String, String[]> entity : parameters.entrySet()) {
                sb.append(String.format(template, entity.getKey(),
                        StringUtils.arrayToCommaDelimitedString(entity.getValue())));
            }
            sb.delete(sb.length() - 2, sb.length()).append("]");
        }
        String sessionId = request.getParameter("sessionId");
        if (StringUtils.hasText(sessionId)) {
            sb.append(", [sessionId=");
            sb.append(sessionId);
            sb.append(", teacherId=").append(SessionHelper.getUserId(sessionId));
            sb.append("]");
        }
        return sb;
    }
}