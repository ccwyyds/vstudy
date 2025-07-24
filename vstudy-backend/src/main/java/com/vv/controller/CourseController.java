package com.vv.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vv.common.Result;
import com.vv.common.enums.ResultCodeEnum;
import com.vv.entity.Course;
import com.vv.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * @Title: 新增课程
     * @Author: vv
     * @Date: 2025/6/14 16:14
     */
    @PostMapping("/add")
    public Result addUser(@RequestBody Course course) {
        boolean res = courseService.save(course);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.USER_EXIST_ERROR);
        }
    }

    /**
     * @Title: 删除课程
     * @Author: vv
     * @Date: 2025/6/14 17:36
     */
    @DeleteMapping("/del/{id}")
    public Result delUser(@PathVariable Long id) {
        boolean res = courseService.removeById(id);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 更新课程
     * @Author: vv
     * @Date: 2025/6/14 17:40
     */
    @PutMapping("/update")
    public Result updateCourseById(@RequestBody Course course) {
        boolean res = courseService.updateById(course);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 根据课程id查询数据
     * @Author: vv
     * @Date: 2025/7/2 19:16
     */
    @GetMapping("/getByCourseId/{id}")
    public Result getCourseByCourseId(@PathVariable Long id) {
        Course course = courseService.getById(id);
        if (course != null) {
            return Result.success(course);
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 查询所有课程数据
     * @Author: vv
     * @Date: 2025/7/2 19:16
     */
    @GetMapping("/getAll")
    public Result getAll() {
        List<Course> courses = courseService.list();
        return Result.success(courses);
    }

    /**
     * @Title: 分页查询所有课程数据
     * @Author: vv
     * @Date: 2025/7/4 12:56
     */


    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        IPage<Course> page = courseService.page(current, size);
        return Result.success(page);
    }

    @GetMapping("/getCourseByTeacherId")
    public Result getCourseByTeacherId(Long id) {
        List<Course> list = courseService.getCourseByTeacherId(id);
        return Result.success(list);
    }


}

