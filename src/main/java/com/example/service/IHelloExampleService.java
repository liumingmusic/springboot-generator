/**   
 * @Title: AccessInfoService.java 
 * @Package com.example.service 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月16日 上午11:42:01 
 * @version 
 */
package com.example.service;

import com.example.entity.HelloExampleEntity;

/** 
 * @ClassName: IHelloExampleService 
 * @Description: 数据查询业务示例代码
 * @author doubleM
 * @date 2018年3月16日 上午11:42:01 
 *  
 */
public interface IHelloExampleService {

	public HelloExampleEntity getHelloExampleUUID(String uuid);

}
