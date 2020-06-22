package com.spring.el;

import com.spring.annotation.entity.DbSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @description:通过SpringEl表达式注入Bean
 * @author: Cherry
 * @time: 2020/6/6 16:30
 */
@Component
public class ElShow {
    @Value("#{role.note+';el表达式可进行运算，取值'}")
    private String x;

    @Value("#{T(Math).PI}")
    private double pi;

    @Value("#{T(System).currentTimeMillis()}")
    private long mil;

    @Value("#{dbSource}")//el注入
    private DbSource dbSource;

    @Override
    public String toString() {
        return "ElShow{" +
                "x=" + x +
                ", pi=" + pi +
                ", mil=" + mil +
                '}';
    }
}
