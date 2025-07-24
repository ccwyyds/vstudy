package com.vv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 学生信息表
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student {
    /**
     * 学号
     */
    @TableId
    private Long studentId;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信开放平台ID
     */
    private String unionId;

    /**
     * 公众号OpenID
     */
    private String mpOpenId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生头像
     */
    private String avatar;

    /**
     * 学生学院
     */
    private String college;

    /**
     * 学生班级
     */
    private String classId;

    /**
     * 学生简介
     */
    private String profile;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 权限
     */
    private String role;
}