package com.china.framework.conf.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DataSourceConfig 中提供了多个数据源
 * 此类配置数据源连接实例，以供数据源配置器调用
 * Liz 2020-12-1
 */
@Configuration
public class DataSourceConfig {

    @Bean("adminDS")
    @ConfigurationProperties(prefix="spring.datasource.druid.admin")
    DataSource admin(){
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean("busiDS")
    @ConfigurationProperties(prefix="spring.datasource.druid.busi")
    DataSource busi(){
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }
}
