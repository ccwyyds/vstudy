package com.vv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.entity.Course;
import com.vv.service.CourseService;
import com.vv.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ccw
 * @description 针对表【course】的数据库操作Service实现
 * @createDate 2025-06-27 16:33:19
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    CourseMapper courseMapper;

    @Override
    public IPage<Course> page(Integer current, Integer size) {
        Page<Course> page = new Page<>(current, size);
        return courseMapper.selectPage(page, null); // null 表示无条件

    }

    @Override
    public List<Course> getCourseByTeacherId(Long id) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Course::getTeacherId, id);
        List<Course> list = this.list(wrapper);
        return list;
    }
}




