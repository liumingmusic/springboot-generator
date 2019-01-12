package com.example.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: ResponseResult
 * @Description: json统一消息返回
 * @author doubleM
 * @date 2018年3月15日 上午10:44:21 
 *
 */
@Setter
@Getter
public class ResponseResult<T> {

    public static final Integer OK = 200;

    public static final Integer NOT_FOUND = 404;

    public static final Integer ERROR = 500;

    private Integer code;

    private String message;

    private T data;

    /**
     * Title:
     * Description:
     * @param code
     * @param message
     * @param data
     */
    private ResponseResult(Integer code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(OK, "成功", null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(OK, "成功", data);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<>(OK, message, data);
    }

    public static <T> ResponseResult<T> success(Integer code, String message, T data) {
        return new ResponseResult<>(code, message, data);
    }

    public static <T> ResponseResult<T> error(Integer code, String message, T data) {
        return new ResponseResult<>(code, message, data);
    }

    public static <T> ResponseResult<T> error(String message, T data) {
        return new ResponseResult<>(ERROR, message, data);
    }

    public static <T> ResponseResult<T> error(T data) {
        return new ResponseResult<>(ERROR, "系统错误", data);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult<>(ERROR, "系统错误", null);
    }


}
