package com.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/system")
public class TestLoginController {

//    @PostMapping("/login")
    public String login(String username, String password){
        return "成功";
    }
}
