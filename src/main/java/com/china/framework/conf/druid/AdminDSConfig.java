package com.china.framework.conf.druid;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * admin 数据源配置器
 * Liz 2020-12-1
 */
@Configuration
@MapperScan(basePackages = "com.china.mapper.admin", sqlSessionFactoryRef = "adminSqlSessionFactory")
public class AdminDSConfig {

    @Autowired
    @Qualifier("adminDS")
    DataSource adminDS;

    @Bean
    public SqlSessionFactory adminSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(adminDS);
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:./mapper/admin/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplateAdmin() throws Exception{
        return new SqlSessionTemplate(adminSqlSessionFactory());
    }

}
