package org.lxp.dailylog.web.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.vo.UserVo;
import org.springframework.util.StringUtils;

public class SessionHelper {
    public static final String SESSION_ID = "sessionId";
    private static final String USER_KEY = "user";
    private static final String VERIFY_KEY = "verify";

    public static String getRequestId(HttpServletRequest request) {
        String requestId = request.getParameter(SESSION_ID);
        return StringUtils.hasText(requestId) ? requestId : request.getSession().getId();
    }

    public static long getUserId(HttpSession session) {
        UserVo user = (UserVo) session.getAttribute(USER_KEY);
        return user == null ? 0 : user.getSeqid();
    }

    public static UserVo getUser(HttpSession session) {
        return (UserVo) session.getAttribute(USER_KEY);
    }

    public static void addUser(HttpSession session, UserVo userVo) {
        session.setAttribute(USER_KEY, userVo);
    }

    public static void removeUser(HttpSession session) {
        session.removeAttribute(USER_KEY);
    }

    public static void setVerify(HttpSession session, Verify verify) {
        session.setAttribute(VERIFY_KEY, verify);
    }

    public static String getVerify(HttpSession session) {
        return Optional.ofNullable(session.getAttribute(VERIFY_KEY))
                .map(object -> String.valueOf(((Verify) object).getValue())).orElse(null);
    }
}
