package com.vv.controller;

import com.vv.Interceptor.AllowRole;
import com.vv.common.Result;
import com.vv.common.enums.ResultCodeEnum;
import com.vv.entity.Student;
import com.vv.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * @Title: 新增学生
     * @Author: vv
     * @Date: 2025/6/14 16:14
     */
    @PostMapping("/add")
    public Result addUser(@RequestBody Student student) {
        boolean res = studentService.save(student);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.USER_EXIST_ERROR);
        }
    }

    /**
     * @Title: 删除学生
     * @Author: vv
     * @Date: 2025/6/14 17:36
     */
    @DeleteMapping("/del/{id}")
    public Result delUser(@PathVariable Long id) {
        boolean res = studentService.removeById(id);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 更新学生
     * @Author: vv
     * @Date: 2025/6/14 17:40
     */
    @PutMapping("/update")
    public Result updateStudentById(@RequestBody Student student) {
        boolean res = studentService.updateById(student);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 根据学生id查询数据
     * @Author: vv
     * @Date: 2025/6/14 17:41
     */
//    @AllowRole({"student", "admin"})
    @GetMapping("/getByStudentId/{id}")
    public Result getStudentByStudentId(@PathVariable Long id) {
        Student student = studentService.getById(id);
        if (student != null) {
            return Result.success(student);
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 查询所有学生数据
     * @Author: vv
     * @Date: 2025/6/14 17:41
     */
    @AllowRole({"admin", "student"})
    @GetMapping("/getAll")
    public Result getAll() {
        List<Student> students = studentService.list();
        return Result.success(students);
    }

}
