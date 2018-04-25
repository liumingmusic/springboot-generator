/**   
 * @Title: GlobalExceptionHandler.java 
 * @Package com.example.exception 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月15日 上午10:42:44 
 * @version 
 */
package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.utils.ResponseResult;

/** 
 * @ClassName: GlobalExceptionHandler 
 * @Description: 全局异常拦截
 * @author doubleM
 * @date 2018年3月15日 上午10:42:44 
 *  
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 
	 * @Description: 全局异常处理
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception 设定文件
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseResult<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		return ResponseResult.error("系统异常");
	}
}
