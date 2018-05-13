package org.lxp.dailylog.web.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取客户端IP地址
 */
public class IpUtil {
    private static final Logger LOG = LoggerFactory.getLogger(IpUtil.class);

    /**
     * 获取IP
     *
     * @return 返回地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (isEmpty.test(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (isEmpty.test(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isEmpty.test(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isEmpty.test(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (isEmpty.test(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (isEmpty.test(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static final Predicate<String> isEmpty = ip -> ip == null || ip.length() == 0
            || "unknown".equalsIgnoreCase(ip);

    public static InetAddress getInetAddress() {
        InetAddress rtn = null;
        try {
            rtn = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            LOG.error(e.getMessage(), e);
        }
        return rtn;
    }

    public static String getHostName(InetAddress inetAddress) {
        return Optional.ofNullable(inetAddress).map(InetAddress::getHostName).orElse(null);
    }
}
