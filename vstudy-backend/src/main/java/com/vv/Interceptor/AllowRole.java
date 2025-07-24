package com.vv.Interceptor;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @Title: 判断权限接口
 * @Author: vv
 * @Date: 2025/7/7 15:20
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowRole {
    String[] value(); // 允许的角色
}