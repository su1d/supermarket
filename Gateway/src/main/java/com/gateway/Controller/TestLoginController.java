package com.gateway.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class TestLoginController {

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String add;

    @Value("${server.port}")
    private String serverAddress;

    @PostMapping("/login")
    public String login(String username, String password){
        System.out.println(add+serverAddress);
        return "成功";
    }
}
