package com.vv.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vv.common.Result;
import com.vv.common.enums.ResultCodeEnum;
import com.vv.entity.CourseMark;
import com.vv.service.CourseMarkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/courseMark")
public class CourseMarkController {

    @Resource
    private CourseMarkService courseMarkService;

    /**
     * @Title: 新增课程分数
     * @Author: vv
     * @Date: 2025/6/14 16:14
     */
    @PostMapping("/add")
    public Result addUser(@RequestBody CourseMark courseMark) {
        boolean res = courseMarkService.save(courseMark);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.USER_EXIST_ERROR);
        }
    }

    /**
     * @Title: 删除课程分数
     * @Author: vv
     * @Date: 2025/6/14 17:36
     */
    @DeleteMapping("/del/{courseId}")
    public Result delUser(@PathVariable Long courseId, Long studentId) {
        boolean res = courseMarkService.removeByStudentIdAndCourseId(courseId, studentId);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }


    /**
     * @Title: 更新课程分数
     * @Author: vv
     * @Date: 2025/6/14 17:40
     */
    @PutMapping("/update")
    public Result updateCourseMarkById(@RequestBody CourseMark courseMark) {
        boolean res = courseMarkService.updateById(courseMark);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 更新整个课程
     * @Author: vv
     * @Date: 2025/7/10 0:21
     */
    @PutMapping("/updateCourseMark")
    public Result updateCourseMark(@RequestBody CourseMark courseMark) {
        boolean res = courseMarkService.updateCourseMark(courseMark);
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
    @GetMapping("/getByCourseMarkId/{id}")
    public Result getCourseMarkByCourseMarkId(@PathVariable Long id) {
        List<CourseMark> list = courseMarkService.getCourseMarkByCourseId(id);
        if (list != null) {
            return Result.success(list);
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 查询所有课程分数数据
     * @Author: vv
     * @Date: 2025/7/2 19:16
     */
    @GetMapping("/getAll")
    public Result getAll() {
        List<CourseMark> courseMarks = courseMarkService.list();
        return Result.success(courseMarks);
    }

    /**
     * @Title: 分页查询所有课程分数数据
     * @Author: vv
     * @Date: 2025/7/4 12:56
     */

    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, Long studentId) {
        IPage<CourseMark> page = courseMarkService.page(current, size, studentId);
        return Result.success(page);
    }


    @GetMapping("/getByStudentId/{id}")
    public Result getByStudentId(@PathVariable Integer id) {
        List<CourseMark> list = courseMarkService.getByStudentId(id);
        return Result.success(list);
    }

    /**
     * @Title: 只需要传入课程id就可以了, 前端存储了学生id
     * @Author: vv
     * @Date: 2025/7/4 15:55
     */

    @GetMapping("/getByStudentIdAndCourseId/{courseId}")
    public Result getByStudentIdAndCourseId(@PathVariable Integer courseId, Integer studentId) {
        CourseMark courseMark = courseMarkService.getByStudentIdAndCourseId(courseId, studentId);
        return Result.success(courseMark);
    }


}

