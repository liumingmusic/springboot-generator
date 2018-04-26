/**   
 * @Title: RedisExampleServiceImpl.java 
 * @Package com.example.service.impl 
 * @Description: (用一句话描述该文件做什么) 
 * @author doubleM
 * @date 2018年4月26日 下午3:07:05 
 * @version 
 */
package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.example.service.IRedisExampleServce;

/** 
 * @ClassName: RedisExampleServiceImpl 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年4月26日 下午3:07:05 
 *  
 */
@Service
public class RedisExampleServiceImpl implements IRedisExampleServce {

	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * Title: get
	 * Description: 
	 * @param key
	 * @return 
	 */
	@Override
	public String get(String key) {
		String str = "";
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		if (redisTemplate.hasKey("a")) {
			str = opsForValue.get("a");
		}
		return str;
	}

	/**
	 * Title: set
	 * Description: 
	 * @param key
	 * @param val
	 * @return 
	 */
	@Override
	public boolean set(String key, String val) {
		boolean flag = false;
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, val);
		flag = true;
		return flag;
	}

}
