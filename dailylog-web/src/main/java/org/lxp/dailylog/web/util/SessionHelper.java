package org.lxp.dailylog.web.util;

import static org.lxp.dailylog.web.util.StringHolder.USER;

import javax.servlet.http.HttpSession;

import org.lxp.dailylog.model.UserBase;

public class SessionHelper {
    public static long getUserId(HttpSession session) {
        UserBase user = (UserBase) session.getAttribute(USER);
        return user == null ? 0 : user.getSeqid();
    }
}
