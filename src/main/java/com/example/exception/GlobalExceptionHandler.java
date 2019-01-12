package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.utils.ResponseResult;

/**
 * @author doubleM
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常拦截
 * @date 2018年3月15日 上午10:42:44
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param req 请求对象
     * @param e   异常
     * @return json
     * @throws Exception 系统异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return ResponseResult.error("系统异常");
    }
}
