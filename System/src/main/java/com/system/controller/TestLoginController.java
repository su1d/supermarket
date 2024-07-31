package com.system.controller;

import com.system.pojo.SystemUser;
import com.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class TestLoginController {

    @Autowired
    public SystemUserService systemUserService;

    @PostMapping("/login")
    public String login(String username, String password){
        List<SystemUser> allUsers = systemUserService.findAllUsers();
        return "成功";
    }
}
