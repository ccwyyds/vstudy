package com.vv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vv.entity.Admin;
import com.vv.service.AdminService;
import com.vv.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author ccw
* @description 针对表【admin(管理员信息表)】的数据库操作Service实现
* @createDate 2025-06-27 17:22:07
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




