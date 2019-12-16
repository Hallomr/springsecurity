package com.example.springsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.req.UserReq;

import java.util.List;

public interface UserService extends IService<User> {
    User findByUserName(String username);

    void registerUser(UserReq userReq);

    List getRoles(String s);
}
