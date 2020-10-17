package org.mxn.rdsu.spring.starter.config;

import org.mxn.rdsu.spring.starter.util.RdsuUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ConditionalOnBean(name = "redisTemplate")
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RdsuAutoConfiguration {

    @Bean
    public RdsuUtil rdsuUtil(RedisTemplate redisTemplate){
        RdsuUtil rdsuUtil = new RdsuUtil(redisTemplate);
        return rdsuUtil;
    }
}
