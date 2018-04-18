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

import com.example.utils.ErrorInfo;

/** 
 * @ClassName: GlobalExceptionHandler 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
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
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("Some Data");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
}
