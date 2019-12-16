package com.example.springsecurity.controller;

import com.example.springsecurity.model.req.UserReq;
import com.example.springsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserReq userReq){
        userService.registerUser(userReq);
    }

    @GetMapping("/logout")
    public void logout(){
      log.info(SecurityContextHolder.getContext().getAuthentication().getName()+"已登出");
    }
}
