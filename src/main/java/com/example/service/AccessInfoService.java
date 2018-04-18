/**   
 * @Title: AccessInfoService.java 
 * @Package com.example.service 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月16日 上午11:42:01 
 * @version 
 */
package com.example.service;

import com.example.entity.AccessInfo;

/** 
 * @ClassName: AccessInfoService 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年3月16日 上午11:42:01 
 *  
 */
public interface AccessInfoService {

	public AccessInfo getAccessInfoByUUID(String uuid);

}
