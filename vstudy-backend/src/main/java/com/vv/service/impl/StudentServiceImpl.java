package com.vv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.entity.Student;
import com.vv.service.StudentService;
import com.vv.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author ccw
* @description 针对表【student(学生信息表)】的数据库操作Service实现
* @createDate 2025-06-27 16:33:19
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




