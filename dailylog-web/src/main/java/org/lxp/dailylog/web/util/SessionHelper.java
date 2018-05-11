package org.lxp.dailylog.web.util;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.lxp.dailylog.model.UserBase;

public class SessionHelper {
    private static final Map<String, UserBase> USER_MAP = new ConcurrentHashMap<>();
    private static final Map<String, Verify> VERIFY_MAP = new ConcurrentHashMap<>();

    public static long getUserId(String sessionId) {
        UserBase user = USER_MAP.get(sessionId);
        return user == null ? 0 : user.getSeqid();
    }

    public static UserBase getUser(String sessionId) {
        return USER_MAP.get(sessionId);
    }

    public static void addUser(String sessionId, UserBase userBase) {
        USER_MAP.put(sessionId, userBase);
    }

    public static void removeUser(String sessionId) {
        USER_MAP.remove(sessionId);
    }

    public static void setVerify(String sessionId, Verify verify) {
        VERIFY_MAP.put(sessionId, verify);
    }

    public static String getVerify(String sessionId) {
        return Optional.ofNullable(VERIFY_MAP.get(sessionId)).map(String::valueOf).orElse(null);
    }
}
