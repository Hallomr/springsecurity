package com.example.springsecurity.model.req;

import lombok.Data;

@Data
public class UserReq {
    private String username;
    private String password;
    private String role;
}
