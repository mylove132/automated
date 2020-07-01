package com.xdf.bling.qa.common.config;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.xdf.bling.qa.common.bean.RedisConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * redis配置类
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConfigProperties redisConfigProperties;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        log.info("初始化------redis---------"+redisConfigProperties.toString());
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfigProperties.getMaxActive());
        poolConfig.setMaxIdle(redisConfigProperties.getMaxIdle());
        poolConfig.setMaxWaitMillis(redisConfigProperties.getMaxWait());
        poolConfig.setMinIdle(redisConfigProperties.getMaxIdle());
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(false);
        poolConfig.setTestWhileIdle(true);
        JedisClientConfiguration jedisClientConfiguration = null;

        if (redisConfigProperties.getSsl() != null){
            jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
                    poolConfig(poolConfig).and().
                    readTimeout(Duration.ofMillis(redisConfigProperties.getConnTimeout())).useSsl()
                    .build();
        }else {
            jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
                    poolConfig(poolConfig).and().
                    readTimeout(Duration.ofMillis(redisConfigProperties.getConnTimeout())).build();
        }
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();

        redisStandaloneConfiguration.setDatabase(redisConfigProperties.getDatabase());
        redisStandaloneConfiguration.setPort(redisConfigProperties.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisConfigProperties.getPassword()));
        redisStandaloneConfiguration.setHostName(redisConfigProperties.getHost());
        RedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
        return redisConnectionFactory;
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory);
        return builder.build();
    }
}
