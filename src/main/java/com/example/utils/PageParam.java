/**   
 * @Title: PageParam.java 
 * @Package com.example.utils 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月16日 下午4:43:57 
 * @version 
 */
package com.example.utils;

/** 
 * @ClassName: PageParam 
 * @Description: 分页实体信息
 * @author doubleM
 * @date 2018年3月16日 下午4:43:57 
 *  
 */
public class PageParam {

	// 默认页码
	private Integer defaultPage = 1;

	// 默认每页显示条数
	private Integer defaultPageSize = 10;

	// 是否启用分页功能
	private Boolean defaultUseFlag = true;

	// 是否检测当前页码的合法性（大于最大页码或小于最小页码都不合法）
	private Boolean defaultCheckFlag = true;

	// 当前sql查询的总记录数，回填
	private Integer totle = 1;

	// 当前sql查询实现分页后的总页数，回填
	private Integer totlePage = 1;

	public Integer getDefaultPage() {
		return defaultPage;
	}

	public void setDefaultPage(Integer defaultPage) {
		this.defaultPage = defaultPage;
	}

	public Integer getDefaultPageSize() {
		return defaultPageSize;
	}

	public void setDefaultPageSize(Integer defaultPageSize) {
		this.defaultPageSize = defaultPageSize;
	}

	public Boolean isDefaultUseFlag() {
		return defaultUseFlag;
	}

	public void setDefaultUseFlag(Boolean defaultUseFlag) {
		this.defaultUseFlag = defaultUseFlag;
	}

	public Boolean isDefaultCheckFlag() {
		return defaultCheckFlag;
	}

	public void setDefaultCheckFlag(Boolean defaultCheckFlag) {
		this.defaultCheckFlag = defaultCheckFlag;
	}

	public Integer getTotle() {
		return totle;
	}

	public void setTotle(Integer totle) {
		this.totle = totle;
	}

	public Integer getTotlePage() {
		return totlePage;
	}

	public void setTotlePage(Integer totlePage) {
		this.totlePage = totlePage;
	}
}
