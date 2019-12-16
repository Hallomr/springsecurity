package com.example.springsecurity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    //private String role;
    @TableField(exist = false)
    private List<String> roles;
}
