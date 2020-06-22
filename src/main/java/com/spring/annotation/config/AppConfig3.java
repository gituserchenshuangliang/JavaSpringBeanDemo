package com.spring.annotation.config;

import com.spring.annotation.control.RoleController2;
import com.spring.annotation.entity.DbSource;
import com.spring.annotation.service.impl.RoleServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @description:Java 配置类
 * @author: Cherry
 * @time: 2020/6/6 14:47
 */
@Configuration
@ComponentScan(basePackageClasses = {DbSource.class, RoleController2.class, RoleServiceImpl2.class})
//加载属性文件
@PropertySource(value = {"classpath:config/db.properties"},ignoreResourceNotFound = true)
public class AppConfig3 {
    //它的作用是为了让Spring能够解析属性占位符 例如：@Value ("${jdbc.database.driver}"}
    @Bean
    public static PropertySourcesPlaceholderConfigurer getProperty(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
