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

import com.example.dao.AccessInfoDao;
import com.example.entity.AccessInfo;
import com.example.service.AccessInfoService;
import com.example.utils.PageParam;

/** 
 * @ClassName: AccessInfoServiceImpl 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年3月16日 上午11:42:58 
 *  
 */
@Service
public class AccessInfoServiceImpl implements AccessInfoService {

	@Autowired
	private AccessInfoDao accessInfoDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AccessInfo getAccessInfoByUUID(String uuid) {
		PageParam pageParam = new PageParam();
		AccessInfo enInfo = accessInfoDao.getAccessInfoByUUID(uuid, pageParam);
		return enInfo;
	}

}
