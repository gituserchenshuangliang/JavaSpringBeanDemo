package com.spring.util;

import com.spring.pojo.DbInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description:链接数据库
 * @author: Cherry
 * @time: 2020/6/4 15:38
 */
public class DbManager implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    private Logger logger = LogManager.getLogger(DbManager.class.getName());
    private DbInfo datasource;
    private String name;

    public void setDatasource(DbInfo datasource) {
        this.datasource = datasource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            logger.info("管理者："+ name);
            Class.forName(datasource.getDriverName());
            logger.info("数据驱动加载成功！");
            conn = DriverManager.getConnection(datasource.getUri(),datasource.getUsername(),datasource.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void init() {
        logger.info("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    public void destroy() {
        logger.info("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }

    @Override
    public void setBeanName(String arg0) {
        logger.info("【" + this.getClass().getSimpleName() + "】调用BeanNameAware接口的setBeanName方法");

    }

    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        logger.info("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        logger.info(
                "【" + this.getClass().getSimpleName() + "】调用ApplicationContextAware接口的setApplicationContext方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("【" + this.getClass().getSimpleName() + "】调用InitializingBean接口的afterPropertiesSet方法");
    }
}
