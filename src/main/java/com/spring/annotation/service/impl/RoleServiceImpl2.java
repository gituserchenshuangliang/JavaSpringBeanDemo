package com.spring.annotation.service.impl;

import com.spring.annotation.entity.Role;
import com.spring.annotation.service.RoleService;
import com.spring.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/6 9:47
 */
@Component("roleServiceImpl2")
public class RoleServiceImpl2 implements RoleService {
    @Autowired
    private  Role role;
    @Override
    public void atack() {
        LoggerUtil.getLog(RoleServiceImpl2.class).info("第二个"+role.getName()+"发起"+role.getNote());
    }
}
