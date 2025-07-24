package com.vv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 管理员信息表
 * @TableName admin
 */
@TableName(value ="admin")
@Data
public class Admin {
    /**
     * 管理员工号
     */
    @TableId
    private Long adminId;

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
     * 管理员姓名
     */
    private String name;

    /**
     * 管理员头像
     */
    private String avatar;

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
}