package org.lxp.dailylog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
    private JedisPool jedisPool;

    public JedisConfig(@Value("${spring.redis.host}") String host, @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.password}") String password) {
        JedisPoolConfig config = new JedisPoolConfig();// Jedis池配置
        config.setMaxIdle(1000 * 60);// 对象最大空闲时间
        config.setTestOnBorrow(true);
        this.jedisPool = new JedisPool(config, host, port, 0, password);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }
}
