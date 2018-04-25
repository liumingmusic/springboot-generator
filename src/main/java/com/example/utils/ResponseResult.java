/**   
 * @Title: ErrorInfo.java 
 * @Package com.example.entity 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月15日 上午10:44:21 
 * @version 
 */
package com.example.utils;

/** 
 * @ClassName: ResponseResult 
 * @Description: json统一消息返回
 * @author doubleM
 * @date 2018年3月15日 上午10:44:21 
 *  
 */
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

	/** 
	 * @return code 
	 */
	public Integer getCode() {
		return code;
	}

	/** 
	 * @param code 要设置的 code 
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/** 
	 * @return message 
	 */
	public String getMessage() {
		return message;
	}

	/** 
	 * @param message 要设置的 message 
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** 
	 * @return data 
	 */
	public T getData() {
		return data;
	}

	/** 
	 * @param data 要设置的 data 
	 */
	public void setData(T data) {
		this.data = data;
	}

}
