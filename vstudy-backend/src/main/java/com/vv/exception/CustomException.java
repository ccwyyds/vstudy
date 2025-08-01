//package com.vv.exception;
//
//import com.vv.common.enums.ResultCodeEnum;
//
//public class CustomException extends RuntimeException {
//    private String code;
//    private String msg;
//
//    public CustomException(ResultCodeEnum resultCodeEnum) {
//        this.code = resultCodeEnum.code;
//        this.msg = resultCodeEnum.msg;
//    }
//
//    public CustomException(String code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }
//
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//}

/**
 * @author xixiw
 * @time 2024/9/11 💕 14:20
 */
package com.vv.exception;

import com.vv.common.enums.ResultCodeEnum;

public class CustomException extends RuntimeException {
    private String code;
    private String msg;

    public CustomException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code;
        this.msg = resultCodeEnum.msg;
    }

    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
