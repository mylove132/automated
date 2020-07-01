package com.xdf.bling.qa.common.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class RedisConfigProperties implements Serializable {

    @Value("${redis.database}")
    private Integer database;

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.ssl}")
    private Boolean ssl;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.connTimeout}")
    private Long connTimeout;

    @Value("${redis.maxActive}")
    private Integer maxActive;

    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.minIdle}")
    private Integer minIdle;

    @Value("${redis.maxWait}")
    private Integer maxWait;

}
