package com.vv.controller;

import com.vv.Interceptor.AllowAnon;
import com.vv.Interceptor.AllowRole;
import com.vv.common.Result;
import com.vv.common.enums.ResultCodeEnum;
import com.vv.entity.Teacher;
import com.vv.service.TeacherService;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    /**
     * @Title: 新增教师
     * @Author: vv
     * @Date: 2025/6/14 16:14
     */
    @PostMapping("/add")
    public Result addUser(@RequestBody Teacher teacher) {
        boolean res = teacherService.save(teacher);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.USER_EXIST_ERROR);
        }
    }

    /**
     * @Title: 删除教师
     * @Author: vv
     * @Date: 2025/6/14 17:36
     */
    @DeleteMapping("/del/{id}")
    public Result delUser(@PathVariable Long id) {
        boolean res = teacherService.removeById(id);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 更新教师
     * @Author: vv
     * @Date: 2025/6/14 17:40
     */
    @PutMapping("/update")
    public Result updateTeacherById(@RequestBody Teacher teacher) {
        boolean res = teacherService.updateById(teacher);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 根据教师id查询数据
     * @Author: vv
     * @Date: 2025/6/14 17:41
     */
    @AllowRole({"teacher","admin"})
    @GetMapping("/getByTeacherId/{id}")
    public Result getTeacherByTeacherId(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        if (teacher != null) {
            return Result.success(teacher);
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 查询所有教师数据
     * @Author: vv
     * @Date: 2025/6/14 17:41
     */
    @GetMapping("/getAll")
    public Result getAll() {
        List<Teacher> teachers = teacherService.list();
        return Result.success(teachers);
    }

    /**
     * @Title: 根据教师id查询教师name
     * @Author: vv
     * @Date: 2025/7/2 22:30
     */
    @AllowAnon
    @GetMapping("/getTeacherNameByTeacherId/{id}")
    public Result getTeacherNameByTeacherId(@PathVariable Long id) {
        String name = teacherService.getTeacherNameByTeacherId(id);
        return Result.success(name);
    }

}
