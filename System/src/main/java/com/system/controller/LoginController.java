package com.system.controller;

import com.common.core.constant.Constants;
import com.common.core.redis.service.RedisService;
import com.common.core.utils.TokenUtils;
import com.system.pojo.SystemUser;
import com.system.service.SystemUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("system")
@Slf4j
public class LoginController {

    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private RedisService redisService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody SystemUser systemUser) {
        SystemUser login = systemUserService.checkLogin(systemUser);
        if (!Objects.isNull(login)) {
            String token = TokenUtils.token(login.getUsername(), login.getPassword());
            log.info("用户{}登录成功", login.getUsername());
            // 记录token到redis
            Long expireTime = Long.valueOf(TokenUtils.getValueByKey(token, Constants.LOGIN_EXPIRETIME));
            redisService.setCacheObject(login.getUsername(), login, expireTime / 1000, TimeUnit.SECONDS);
            Cookie cookie = new Cookie("Authorization", token);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);
            cookie.setHttpOnly(true);
            httpServletResponse.addCookie(cookie);
            return new ResponseEntity<String>("登录成功", HttpStatus.OK);
        } else {
            log.info("用户{}登录失败", systemUser.getUsername());
            return new ResponseEntity<String>("用户名或密码错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(@RequestBody SystemUser systemUser) {
        return "退出登录";
    }
}
