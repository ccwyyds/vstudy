package com.vv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName course_mark
 */
@TableName(value ="course_mark")
@Data
public class CourseMark {
    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 分数
     */
    private String mark;

    /**
     * 评语
     */
    private String comment;
}