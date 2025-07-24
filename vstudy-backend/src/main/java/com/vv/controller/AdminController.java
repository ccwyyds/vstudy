package com.vv.controller;

import com.vv.Interceptor.AllowRole;
import com.vv.common.Result;
import com.vv.common.enums.ResultCodeEnum;
import com.vv.entity.Admin;
import com.vv.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * @Title: 新增管理员
     * @Author: vv
     * @Date: 2025/6/14 16:14
     */
    @PostMapping("/add")
    public Result addUser(@RequestBody Admin admin) {
        boolean res = adminService.save(admin);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.USER_EXIST_ERROR);
        }
    }

    /**
     * @Title: 删除管理员
     * @Author: vv
     * @Date: 2025/6/14 17:36
     */
    @DeleteMapping("/del/{id}")
    public Result delUser(@PathVariable Long id) {
        boolean res = adminService.removeById(id);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 更新管理员
     * @Author: vv
     * @Date: 2025/6/14 17:40
     */
    @PutMapping("/update")
    public Result updateAdminById(@RequestBody Admin admin) {
        boolean res = adminService.updateById(admin);
        if (res) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 根据管理员id查询数据
     * @Author: vv
     * @Date: 2025/6/14 17:41
     */
    @GetMapping("/getByAdminId/{id}")
    @AllowRole("admin")
    public Result getAdminByAdminId(@PathVariable Long id) {
        Admin admin = adminService.getById(id);
        if (admin != null) {
            return Result.success(admin);
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * @Title: 查询所有管理员数据
     * @Author: vv
     * @Date: 2025/6/14 17:41
     */
    @AllowRole("admin")
    @GetMapping("/getAll")
    public Result getAll() {
        List<Admin> admins = adminService.list();
        return Result.success(admins);
    }
}
