package com.platform.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcw
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020-05-07
 */
@RefreshScope
@RequestMapping("/api")
@RestController
public class ApiController {

    @Value("${test}")
    private String test;

    @GetMapping("hello")
    public String hello(){
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return "hello "+authentication.getName();
    }

    @GetMapping("test")
    public String test(){
        return test;
    }
}
