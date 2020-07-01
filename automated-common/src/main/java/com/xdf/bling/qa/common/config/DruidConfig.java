package com.xdf.bling.qa.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xdf.bling.qa.common.bean.JdbcConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
public class DruidConfig {

    @Autowired
    private JdbcConfigProperties jdbcConfigProperties;

    @Bean
    public DataSource dataSource() throws SQLException {
        log.info("初始化数据库连接配置："+jdbcConfigProperties);
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(jdbcConfigProperties.getUsername());
        druidDataSource.setPassword(jdbcConfigProperties.getPassword());
        druidDataSource.setUrl(jdbcConfigProperties.getUrl());
        druidDataSource.setDriverClassName(jdbcConfigProperties.getDriverClassName());
        druidDataSource.setInitialSize(jdbcConfigProperties.getInitialSize());
        druidDataSource.setMinIdle(jdbcConfigProperties.getMinIdle());
        druidDataSource.setMaxActive(jdbcConfigProperties.getMaxActive());
        druidDataSource.setTimeBetweenEvictionRunsMillis(jdbcConfigProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(jdbcConfigProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(jdbcConfigProperties.getValidationQuery());
        druidDataSource.setTestOnBorrow(jdbcConfigProperties.getTestOnBorrow());
        druidDataSource.setTestOnReturn(jdbcConfigProperties.getTestOnReturn());
        druidDataSource.setTestWhileIdle(jdbcConfigProperties.getTestWhileIdle());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(jdbcConfigProperties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setPoolPreparedStatements(jdbcConfigProperties.getPoolPreparedStatements());
        druidDataSource.setFilters(jdbcConfigProperties.getFilters());
        druidDataSource.setConnectionProperties(jdbcConfigProperties.getConnectionProperties());
        druidDataSource.setUseGlobalDataSourceStat(jdbcConfigProperties.getUseGlobalDataSourceStat());
        return druidDataSource;
    }
}
