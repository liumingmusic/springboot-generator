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
 * @ClassName: ErrorInfo 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年3月15日 上午10:44:21 
 *  
 */
public class ErrorInfo<T> {

	public static final Integer OK = 0;

	public static final Integer ERROR = 100;

	private Integer code;

	private String message;

	private String url;

	private T data;

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
	 * @return url 
	 */
	public String getUrl() {
		return url;
	}

	/** 
	 * @param url 要设置的 url 
	 */
	public void setUrl(String url) {
		this.url = url;
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
