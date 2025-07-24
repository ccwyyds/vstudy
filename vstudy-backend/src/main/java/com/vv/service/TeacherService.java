package com.vv.service;

import com.vv.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ccw
* @description 针对表【teacher(教师信息表)】的数据库操作Service
* @createDate 2025-06-27 17:22:08
*/
public interface TeacherService extends IService<Teacher> {

    String getTeacherNameByTeacherId(Long id);
}
