/**   
 * @Title: IRedisExampleServce.java 
 * @Package com.example.service 
 * @Description: (用一句话描述该文件做什么) 
 * @author doubleM
 * @date 2018年4月26日 下午3:05:17 
 * @version 
 */
package com.example.service;

/** 
 * @ClassName: IRedisExampleServce 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年4月26日 下午3:05:17 
 *  
 */
public interface IRedisExampleServce {

	public String get(String key);

	public boolean set(String key, String val);

}
