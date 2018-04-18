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

import com.example.entity.AccessInfo;
import com.example.utils.PageParam;

/** 
 * @ClassName: AccessInfoMapper 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年3月15日 上午10:55:32 
 *  
 */
@Mapper
public interface AccessInfoDao {

	public AccessInfo getAccessInfoByUUID(@Param("uuid") String uuid, PageParam pageParam);

	public List<AccessInfo> findByParams(PageParam pageParam);

}
