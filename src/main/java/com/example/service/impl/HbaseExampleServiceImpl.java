/**   
 * @Title: HbaseServiceImpl.java 
 * @Package com.example.service.impl 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年4月25日 下午2:16:35 
 * @version 
 */
package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.HbaseExampleEntity;
import com.example.hbase.HBaseDaoUtil;
import com.example.service.IHbaseExampleService;

/** 
 * @ClassName: HbaseServiceImpl 
 * @Description: 业务操作Hbase的示例
 * @author doubleM
 * @date 2018年4月25日 下午2:16:35 
 *  
 */
@Service
public class HbaseExampleServiceImpl implements IHbaseExampleService {

	@Autowired
	private HBaseDaoUtil hBaseDaoUtil;

	/**
	 * Title: getDataByRowkey
	 * Description: 
	 * @param id
	 * @return 
	 */
	@Override
	public List<HbaseExampleEntity> getDataByRowkey(String id) {
		HbaseExampleEntity entity = new HbaseExampleEntity();
		List<HbaseExampleEntity> list = hBaseDaoUtil.getListByRowKeys(entity, id);
		return list;
	}

	/**
	 * Title: saveBatch
	 * Description: 
	 * @param list 
	 */
	@Override
	public boolean saveBatch(List<HbaseExampleEntity> list) {
		return hBaseDaoUtil.save(list);
	}

}
