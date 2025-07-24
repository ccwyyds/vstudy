package com.vv.common.enums;

public enum ResultCodeEnum {
    SUCCESS("200", "成功"),

    PARAM_ERROR("400", "参数异常"),

    PARAM_LOST_ERROR("4001", "参数缺失"),

    ROLE_UNKNOWN_ERROR("4002", "未知权限"),


    SYSTEM_ERROR("500", "系统异常"),
    USER_EXIST_ERROR("5001", "学号已存在"),
    USER_NOT_LOGIN("5002", "用户未登录"),
    USER_ACCOUNT_ERROR("5003", "账号或密码错误"),
    USER_NOT_EXIST_ERROR("5004", "用户不存在"),
    PARAM_PASSWORD_ERROR("5005", "原密码输入错误"),
    USER_PASSWORD_LOST("5006", "请输入密码"),
    USER_USERNAME_LOST("5007", "请输入用户名"),
    USER_NAME_LOST("5008","请输入姓名"),

    UPLOAD_TYPE_ERROR("5009","上传失败，只能上传图片 (jpg, png, gif, webp)！")

    ;

    public String code;
    public String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
