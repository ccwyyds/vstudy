package com.vv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course {
    /**
     * 课程id
     */
    @TableId
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教室
     */
    private String courseClassroom;

    /**
     * 课程类型
     */
    private String courseType;

    /**
     * 学时
     */
    private String courseWeek;

    /**
     * 所属院系
     */
    private String courseCollege;

    /**
     * 学分
     */
    private String courseScore;

    /**
     * 已选人数
     */
    private Integer selectedCount;

    /**
     * 可选人数
     */
    private Integer optionalCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}