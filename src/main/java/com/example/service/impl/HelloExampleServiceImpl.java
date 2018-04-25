/**   
 * @Title: AccessInfoServiceImpl.java 
 * @Package com.example.service.impl 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月16日 上午11:42:58 
 * @version 
 */
package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.HelloExampleDao;
import com.example.entity.HelloExampleEntity;
import com.example.service.IHelloExampleService;

/** 
 * @ClassName: AccessInfoServiceImpl 
 * @Description: 业务操作dao层的代码示例
 * @author doubleM
 * @date 2018年3月16日 上午11:42:58 
 *  
 */
@Service
public class HelloExampleServiceImpl implements IHelloExampleService {

	@Autowired
	private HelloExampleDao helloExampleDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HelloExampleEntity getHelloExampleUUID(String uuid) {
		HelloExampleEntity enInfo = helloExampleDao.getHelloExampleUUID(uuid);
		return enInfo;
	}

}
