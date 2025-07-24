package com.vv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.entity.Teacher;
import com.vv.service.TeacherService;
import com.vv.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

/**
 * @author ccw
 * @description 针对表【teacher(教师信息表)】的数据库操作Service实现
 * @createDate 2025-06-27 17:22:08
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * @Title: 根据教师id查询教师名字
     * @Author: vv
     * @Date: 2025/7/2 22:33
     */

    @Override
    public String getTeacherNameByTeacherId(Long id) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Teacher::getTeacherId, id);
        Teacher teacher = this.getOne(wrapper);
        return teacher.getName();
    }
}




