/**   
 * @Title: IHbaseService.java 
 * @Package com.example.service 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年4月25日 下午2:05:28 
 * @version 
 */
package com.example.service;

import java.util.List;

import com.example.entity.HbaseExampleEntity;

/** 
 * @ClassName: IHbaseService 
 * @Description: 操作Hbase的接口业务接口 
 * @author doubleM
 * @date 2018年4月25日 下午2:05:28 
 *  
 */
public interface IHbaseExampleService {

	/**
	 * 
	 * @Description: 查询多个rowkey返回集合代码
	 * @param id 多个rowkey
	 * @return 设定文件
	 */
	 List<HbaseExampleEntity> getDataByRowkey(String id);

	/**
	 * 
	 * @Description: 批量保存数据信息
	 * @param list
	 * @return 设定文件
	 */
	 boolean saveBatch(List<HbaseExampleEntity> list);

}
