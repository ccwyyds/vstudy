package com.vv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 教师信息表
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
public class Teacher {
    /**
     * 教师工号
     */
    @TableId
    private Long teacherId;

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
     * 教师姓名
     */
    private String name;

    /**
     * 教师头像
     */
    private String avatar;

    /**
     * 教师学院
     */
    private String college;

    /**
     * 教师班级
     */
    private String classId;

    /**
     * 教师学历
     */
    private String degree;

    /**
     * 教师职位
     */
    private String office;

    /**
     * 教师简介
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