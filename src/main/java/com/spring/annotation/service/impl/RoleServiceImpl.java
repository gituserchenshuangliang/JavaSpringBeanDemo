package com.spring.annotation.service.impl;

import com.spring.annotation.entity.Role;
import com.spring.annotation.service.RoleService;
import com.spring.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @description:@Primary指定第一个RoleService，消除歧义
 * @author: Cherry
 * @time: 2020/6/6 9:47
 */
@Primary
@Component("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private  Role role;
    @Override
    public void atack() {
        LoggerUtil.getLog(RoleServiceImpl.class).info(role.getName()+"发起"+role.getNote());
    }
}
