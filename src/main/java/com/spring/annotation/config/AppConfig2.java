package com.spring.annotation.config;

import com.spring.annotation.control.RoleController;
import com.spring.annotation.control.RoleController2;
import com.spring.annotation.entity.Role;
import com.spring.annotation.service.impl.RoleServiceImpl2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/6 10:53
 */
//@ComponentScan(basePackages = {"com.spring.annotation.*"})
@ComponentScan(basePackageClasses = {Role.class, RoleController.class, RoleServiceImpl2.class, RoleController2.class})
//导入配置文件
@ImportResource({"classpath:config/spring-data.xml"})
//导入配置类
//@Import({AppConfig.class})
public class AppConfig2 {
}
