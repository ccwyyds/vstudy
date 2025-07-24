package com.vv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: 用户表
 * @Author: vv
 * @Date: 2025/6/27 18:57
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String role;

    private String userId;

    private String password;

    public User(String role, String userId) {
        this.role = role;
        this.userId = userId;
    }
}
