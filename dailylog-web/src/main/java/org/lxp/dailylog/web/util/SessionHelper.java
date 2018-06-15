package org.lxp.dailylog.web.util;

import java.util.Collections;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.lxp.dailylog.config.JedisConfig;
import org.lxp.dailylog.model.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SessionHelper {
    public static final String SESSION_ID = "sessionId";
    private final String USER_KEY = "user";
    private final String VERIFY_KEY = "verify";
    private final JedisHelper JEDIS_HELPER;

    @Autowired
    public SessionHelper(JedisConfig jedisConfig) {
        JEDIS_HELPER = new JedisHelper(jedisConfig.getJedisPool());
    }

    public static String getRequestId(HttpServletRequest request) {
        String requestId = request.getParameter(SESSION_ID);
        return StringUtils.hasText(requestId) ? requestId : request.getSession().getId();
    }

    public long getUserId(String sessionId) {
        UserBase user = JsonHelper.toObject(UserBase.class, JEDIS_HELPER.hget(USER_KEY, sessionId));
        return user == null ? 0 : user.getSeqid();
    }

    public UserBase getUser(String sessionId) {
        return JsonHelper.toObject(UserBase.class, JEDIS_HELPER.hget(USER_KEY, sessionId));
    }

    public void addUser(String sessionId, UserBase userBase) {
        JEDIS_HELPER.hmset(USER_KEY, Collections.singletonMap(sessionId, JsonHelper.toString(userBase)));
    }

    public void removeUser(String sessionId) {
        JEDIS_HELPER.hdel(USER_KEY, sessionId);
    }

    public void setVerify(String sessionId, Verify verify) {
        JEDIS_HELPER.hmset(VERIFY_KEY, Collections.singletonMap(sessionId, JsonHelper.toString(verify)));
    }

    public String getVerify(String sessionId) {
        return Optional.ofNullable(JsonHelper.toObject(Verify.class, JEDIS_HELPER.hget(VERIFY_KEY, sessionId)))
                .map(Verify::getValue).map(String::valueOf).orElse(null);
    }
}
