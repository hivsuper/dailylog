package org.lxp.dailylog.web.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lxp.dailylog.model.UserBase;
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
        UserBase user = (UserBase) session.getAttribute(USER_KEY);
        return user == null ? 0 : user.getSeqid();
    }

    public static UserBase getUser(HttpSession session) {
        return (UserBase) session.getAttribute(USER_KEY);
    }

    public static void addUser(HttpSession session, UserBase userBase) {
        session.setAttribute(USER_KEY, userBase);
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
