package com.vv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vv.Interceptor.AllowAnon;
import com.vv.entity.Student;
import com.vv.entity.Teacher;
import com.vv.entity.Admin;
import com.vv.entity.User;
import com.vv.service.StudentService;
import com.vv.service.TeacherService;
import com.vv.service.AdminService;
import com.vv.utils.JwtUtil;
import com.vv.common.Result;
import com.vv.common.enums.ResultCodeEnum;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private AdminService adminService;

    @AllowAnon
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String userType = user.getRole();
        String userId = user.getUserId();
        String password = user.getPassword();
        if (userType == null || userId == null || password == null) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        Map<String, Object> claims = new HashMap<>();
        if ("student".equalsIgnoreCase(userType)) {
            LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Student::getStudentId, userId);
            Student student = studentService.getOne(wrapper);
            if (student == null) {
                return Result.error(ResultCodeEnum.USER_NOT_EXIST_ERROR);
            }
            if (!password.equals(student.getPassword())) {
                return Result.error(ResultCodeEnum.USER_ACCOUNT_ERROR);
            }
            claims.put("userId", student.getStudentId());
//            claims.put("userName", student.getName());
            claims.put("role", "student");
        } else if ("teacher".equalsIgnoreCase(userType)) {
            LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Teacher::getTeacherId, userId);
            Teacher teacher = teacherService.getOne(wrapper);
            if (teacher == null) {
                return Result.error(ResultCodeEnum.USER_NOT_EXIST_ERROR);
            }
            if (!password.equals(teacher.getPassword())) {
                return Result.error(ResultCodeEnum.USER_ACCOUNT_ERROR);
            }
            claims.put("userId", teacher.getTeacherId());
//            claims.put("userName", teacher.getName());
            claims.put("role", "teacher");
        } else if ("admin".equalsIgnoreCase(userType)) {
            LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Admin::getAdminId, userId);
            Admin admin = adminService.getOne(wrapper);
            if (admin == null) {
                return Result.error(ResultCodeEnum.USER_NOT_EXIST_ERROR);
            }
            if (!password.equals(admin.getPassword())) {
                return Result.error(ResultCodeEnum.USER_ACCOUNT_ERROR);
            }
            claims.put("userId", admin.getAdminId());
//            claims.put("userName", admin.getName());
            claims.put("role", "admin");
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
        // 生成token
        var token = JwtUtil.generateToken(claims);
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.putAll(claims);
        return Result.success(result);
    }

    /**
     * 详情（需要验证）
     */
    @GetMapping("/detail")
    public Result getUserDetail(@RequestHeader("Authorization") String token) {

        //获取当前用户
        var user = JwtUtil.getUserIdAndRole(token);

        var userId = user.getUserId();
        var role = user.getRole();
        User userInfo = new User(role, userId, token);

        return Result.success(userInfo);
    }

}