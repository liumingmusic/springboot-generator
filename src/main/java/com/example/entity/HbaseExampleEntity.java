/**   
 * @Title: HbaseExampleEntity.java 
 * @Package com.example.entity 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年4月25日 下午2:13:26 
 * @version 
 */
package com.example.entity;

import com.example.hbase.HbaseColumn;
import com.example.hbase.HbaseTable;

/** 
 * @ClassName: HbaseExampleEntity 
 * @Description: 与Hbase中表的rowkey、列簇、列名以及列对应
 * @author doubleM
 * @date 2018年4月25日 下午2:13:26 
 *  
 */
@HbaseTable(tableName = "t1")
public class HbaseExampleEntity {

	// 标示数据中rowkey，用在新增时候填充
	@HbaseColumn(family = "rowkey", qualifier = "rowkey")
	private String id;

	// 列簇、列映射的实体名称，用于查询的数据返回
	@HbaseColumn(family = "f1", qualifier = "c1")
	private String c1;

	/** 
	 * @return id 
	 */
	public String getId() {
		return id;
	}

	/** 
	 * @param id 要设置的 id 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** 
	 * @return c1 
	 */
	public String getC1() {
		return c1;
	}

	/** 
	 * @param c1 要设置的 c1 
	 */
	public void setC1(String c1) {
		this.c1 = c1;
	}

}
