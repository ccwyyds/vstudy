package com.vv.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vv.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ccw
* @description 针对表【course】的数据库操作Service
* @createDate 2025-06-27 16:33:19
*/
public interface CourseService extends IService<Course> {
    public IPage<Course> page(@Param("current") Integer current, @Param("size") Integer size);

    List<Course> getCourseByTeacherId(Long id);
}
