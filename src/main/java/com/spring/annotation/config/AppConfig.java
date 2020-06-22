package com.spring.annotation.config;

import com.spring.annotation.entity.Role;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:扫描注解Bean
 * @author: Cherry
 * @time: 2020/6/5 10:58
 */
@ComponentScan(basePackageClasses={Role.class})
public class AppConfig {
}
