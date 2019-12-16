package com.example.springsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.model.req.UserReq;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUserName(String username) {
        QueryWrapper<User> q = new QueryWrapper<User>()
                .eq("username",username);
        User user = userMapper.selectOne(q);
        return user;
    }

    @Override
    public void registerUser(UserReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq,user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.save(user);
    }

    @Override
    public List getRoles(String s) {
        return  userMapper.getRoles(s);

    }
}
