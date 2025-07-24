package com.vv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.entity.CourseMark;
import com.vv.mapper.CourseMarkMapper;
import com.vv.service.CourseMarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ccw
 * @description 针对表【course_mark】的数据库操作Service实现
 * @createDate 2025-06-27 17:24:50
 */
@Service
public class CourseMarkServiceImpl extends ServiceImpl<CourseMarkMapper, CourseMark> implements CourseMarkService {
    @Resource
    CourseMarkMapper courseMarkMapper;

    /**
     * @Title: 对某个学号的同学进行分页查询课程
     * @Author: vv
     * @Date: 2025/7/4 17:48
     */
    @Override
    public IPage<CourseMark> page(Integer current, Integer size, Long studentId) {
        Page<CourseMark> page = new Page<>(current, size);
        LambdaQueryWrapper<CourseMark> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CourseMark::getStudentId, studentId);
        Page<CourseMark> courseMarkPage = courseMarkMapper.selectPage(page, wrapper);
        return courseMarkPage;

    }

    @Override
    public List<CourseMark> getByStudentId(Integer id) {
        LambdaQueryWrapper<CourseMark> wrapper = new LambdaQueryWrapper();
        wrapper.eq(CourseMark::getStudentId, id);
        List<CourseMark> list = this.list(wrapper);
        return list;
    }

    @Override
    public CourseMark getByStudentIdAndCourseId(Integer courseId, Integer studentId) {
        LambdaQueryWrapper<CourseMark> wrapper = new LambdaQueryWrapper();
        wrapper.eq(CourseMark::getCourseId, courseId).eq(CourseMark::getStudentId, studentId);
        CourseMark courseMark = this.getOne(wrapper);
        return courseMark;
    }

    @Override
    public Boolean removeByStudentIdAndCourseId(Long courseId, Long studentId) {
        LambdaQueryWrapper<CourseMark> wrapper = new LambdaQueryWrapper();
        wrapper.eq(CourseMark::getCourseId, courseId).eq(CourseMark::getStudentId, studentId);
        this.remove(wrapper);
        return true;
    }

    /**
     * @Title: 根据课程id查询选择此课的学生
     * @Author: vv
     * @Date: 2025/7/9 21:08
     */
    @Override
    public List<CourseMark> getCourseMarkByCourseId(Long id) {
        LambdaQueryWrapper<CourseMark> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CourseMark::getCourseId, id);
        List<CourseMark> list = this.list(wrapper);
        return list;
    }

    @Override
    public boolean updateCourseMark(CourseMark courseMark) {
        LambdaQueryWrapper<CourseMark> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CourseMark::getCourseId, courseMark.getCourseId()).eq(CourseMark::getStudentId, courseMark.getStudentId());
        // 只更新成绩和评语
        CourseMark updateCourseMark = new CourseMark();
        updateCourseMark.setMark(courseMark.getMark());
        updateCourseMark.setComment(courseMark.getComment());
        return this.update(updateCourseMark, wrapper);
    }
}




