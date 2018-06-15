package org.lxp.dailylog.web.util;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisHelper {
    private final JedisPool jedisPool;

    public JedisHelper(JedisPool pool) {
        jedisPool = pool;
    }

    public String hmset(String key, Map<String, String> map) {
        String rtn = null;
        try (Jedis jedis = getResource()) {
            rtn = jedis.hmset(key, map);
        }
        return rtn;
    }

    public String hget(String key, String field) {
        String rtn = null;
        try (Jedis jedis = getResource()) {
            rtn = jedis.hget(key, field);
        }
        return rtn;
    }

    public long hdel(String key, String field) {
        long rtn = 0;
        try (Jedis jedis = getResource()) {
            rtn = jedis.hdel(key, field);
        }
        return rtn;
    }

    public Jedis getResource() {
        return jedisPool.getResource();
    }
}
