package com.cgutech.roadcloud.config;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Becan on 2017/6/8.
 */
@Configuration
@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class})
public class RedisConfig {
    private Logger logger = Logger.getLogger(RedisConfig.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisPoolConfig getRedisConfig(){
        return new JedisPoolConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactioy(){
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setPoolConfig(getRedisConfig());
        return cf;
    }

    @Bean(value = "template")
    public RedisTemplate getRedisTemplate(){
        return new StringRedisTemplate(getConnectionFactioy());
    }

}
