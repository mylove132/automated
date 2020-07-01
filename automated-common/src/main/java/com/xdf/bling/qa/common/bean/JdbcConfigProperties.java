package com.xdf.bling.qa.common.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class JdbcConfigProperties implements Serializable {

    @Value("${druid.datasource.username}")
    private String username;

    @Value("${druid.datasource.password}")
    private String password;

    @Value("${druid.datasource.url}")
    private String url;

    @Value("${druid.datasource.driverClassName}")
    private String driverClassName;

    @Value("${druid.datasource.initialSize}")
    private Integer initialSize;

    @Value("${druid.datasource.minIdle}")
    private Integer minIdle;

    @Value("${druid.datasource.maxActive}")
    private Integer maxActive;

    @Value("${druid.datasource.maxWait}")
    private Long maxWait;

    @Value("${druid.datasource.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;

    @Value("${druid.datasource.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;

    @Value("${druid.datasource.validationQuery}")
    private String validationQuery;

    @Value("${druid.datasource.testWhileIdle}")
    private Boolean testWhileIdle;

    @Value("${druid.datasource.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${druid.datasource.testOnReturn}")
    private Boolean testOnReturn;

    @Value("${druid.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxPoolPreparedStatementPerConnectionSize;

    @Value("${druid.datasource.poolPreparedStatements}")
    private Boolean poolPreparedStatements;

    @Value("${druid.datasource.filters}")
    private String filters;

    @Value("${druid.datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${druid.datasource.useGlobalDataSourceStat}")
    private Boolean useGlobalDataSourceStat;
}
