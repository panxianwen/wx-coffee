package com.yu.common.util.result;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装RestController返回的结果
 */
@Data
@ApiModel("封装RestController返回的结果")
public class R<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static int CONST_ok = 200;
    public static int CONST_fail = 400;

    public static <T> R<T> ok() {
        return new R(CONST_ok, "成功", null);
    }

    public static <T> R<T> ok(T result) {
        return new R(CONST_ok, "成功", result);
    }

    public static <T> R<T> ok(String message, T data) {
        return new R(CONST_ok, message, data);
    }

    public static <T> R<T> fail(String message) {
        return new R(CONST_fail, message, null);
    }

    public static <T> R<T> fail(String message, T data) {
        return new R(CONST_fail, message, data);
    }

    public static <T> R<T> newInstance(int code, String message){
        return new R(code, message, null);
    }
}
