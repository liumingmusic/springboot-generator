package com.example.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @ClassName: HelloExampleEntity 
 * @Description: 基本对应的数据库实体信息
 * @author doubleM
 * @date 2018年4月25日 下午5:18:50 
 *
 */
public class HelloExampleEntity implements Serializable {

	/** 
	 * @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 302780684394764360L;

	/**
	 * 任务ID
	 */
	private int id;

	/**
	 * 接口请求uri
	 */
	private String uri;

	/**
	 * UUID
	 */
	private String uuid;

	/**
	 * 查询请求时间
	 */
	private String query;

	/**
	 * 接口访问时间
	 */
	private long inTime;

	/**
	 * 接口输出时间
	 */
	private long outTime;

	/**
	 * 接口数据字节大小
	 */
	private long dataBytes;

	/**
	 * 命中的条数
	 */
	private long record;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 消耗时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
	private Long espTime;

	/** 
	 * @return id 
	 */
	public int getId() {
		return id;
	}

	/** 
	 * @param id 要设置的 id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** 
	 * @return uri 
	 */
	public String getUri() {
		return uri;
	}

	/** 
	 * @param uri 要设置的 uri 
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/** 
	 * @return uuid 
	 */
	public String getUuid() {
		return uuid;
	}

	/** 
	 * @param uuid 要设置的 uuid 
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/** 
	 * @return query 
	 */
	public String getQuery() {
		return query;
	}

	/** 
	 * @param query 要设置的 query 
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/** 
	 * @return inTime 
	 */
	public Long getInTime() {
		return inTime;
	}

	/** 
	 * @param inTime 要设置的 inTime 
	 */
	public void setInTime(long inTime) {
		this.inTime = inTime;
	}

	/** 
	 * @return outTime 
	 */
	public Long getOutTime() {
		return outTime;
	}

	/** 
	 * @param outTime 要设置的 outTime 
	 */
	public void setOutTime(long outTime) {
		this.outTime = outTime;
	}

	/** 
	 * @return dataBytes 
	 */
	public long getDataBytes() {
		return dataBytes;
	}

	/** 
	 * @param dataBytes 要设置的 dataBytes 
	 */
	public void setDataBytes(long dataBytes) {
		this.dataBytes = dataBytes;
	}

	/** 
	 * @return record 
	 */
	public long getRecord() {
		return record;
	}

	/** 
	 * @param record 要设置的 record 
	 */
	public void setRecord(long record) {
		this.record = record;
	}

	/** 
	 * @return status 
	 */
	public String getStatus() {
		return status;
	}

	/** 
	 * @param status 要设置的 status 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/** 
	 * @return espTime 
	 */
	public Long getEspTime() {
		return espTime;
	}

	/** 
	 * @param espTime 要设置的 espTime 
	 */
	public void setEspTime(long espTime) {
		this.espTime = espTime;
	}

	/**
	 * Title: toString
	 * Description: 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "AccessInfo [id=" + id + ", uri=" + uri + ", uuid=" + uuid + ", query=" + query + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", dataBytes=" + dataBytes + ", record=" + record + ", status=" + status
				+ ", espTime=" + espTime + "]";
	}

}
