package com.vv.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vv.entity.Course;
import com.vv.entity.CourseMark;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ccw
 * @description 针对表【course_mark】的数据库操作Service
 * @createDate 2025-06-27 17:24:50
 */
public interface CourseMarkService extends IService<CourseMark> {
    public IPage<CourseMark> page(@Param("current") Integer current, @Param("size") Integer size,Long studentId);

    List<CourseMark> getByStudentId(Integer id);


    CourseMark getByStudentIdAndCourseId(Integer courseId, Integer studentId);


    Boolean removeByStudentIdAndCourseId(Long courseId, Long studentId);

    List<CourseMark> getCourseMarkByCourseId(Long id);

    boolean updateCourseMark(CourseMark courseMark);
}
