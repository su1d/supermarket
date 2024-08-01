package com.system.service.impl;

import com.system.mapper.SystemUserMapper;
import com.system.pojo.SystemUser;
import com.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public List<SystemUser> findAllUsers(){
        List<SystemUser> allUsers = systemUserMapper.getAllUsers();
        return allUsers;
    }

    @Override
    public SystemUser checkLogin(SystemUser systemUser) {
        return systemUserMapper.checkLogin(systemUser);
    }


}
