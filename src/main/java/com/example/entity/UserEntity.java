/**   
 * @Title: UserEntity.java 
 * @Package com.example.entity 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月15日 上午10:09:19 
 * @version 
 */
package com.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: UserEntity 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年3月15日 上午10:09:19 
 *  
 */
@Component
@PropertySource(value = { "classpath:properties/data.properties" })
public class UserEntity {

	@Value("${com.example.name}")
	private String name;

	@Value("${com.example.age}")
	private Integer age;

	@Value("${com.example.score}")
	private Double score;

	/** 
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name 要设置的 name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * @return age 
	 */
	public Integer getAge() {
		return age;
	}

	/** 
	 * @param age 要设置的 age 
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/** 
	 * @return score 
	 */
	public Double getScore() {
		return score;
	}

	/** 
	 * @param score 要设置的 score 
	 */
	public void setScore(Double score) {
		this.score = score;
	}

}
