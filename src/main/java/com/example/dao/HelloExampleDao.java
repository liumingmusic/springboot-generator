/**   
 * @Title: AccessInfoMapper.java 
 * @Package com.example.mapper 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月15日 上午10:55:32 
 * @version 
 */
package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.HelloExampleEntity;
import com.example.utils.PageParam;

/** 
 * @ClassName: HelloExampleDao 
 * @Description: 数据操作的接口类
 * @author doubleM
 * @date 2018年3月15日 上午10:55:32 
 *  
 */
@Mapper
public interface HelloExampleDao {

	/**
	 * 
	 * @Description: 根据id进行数据查询
	 * @param uuid id值
	 * @return 设定文件
	 */
	public HelloExampleEntity getHelloExampleUUID(@Param("uuid") String uuid);

	/**
	 * 
	 * @Description: 分页查询数据信息
	 * @param pageParam 分页参数
	 * @return 设定文件
	 */
	public List<HelloExampleEntity> findByParams(PageParam pageParam);

}
