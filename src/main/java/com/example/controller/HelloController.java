/**   
 * @Title: HelloController.java 
 * @Package com.example.controller 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月13日 下午7:59:39 
 * @version 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.HandlerLog;
import com.example.entity.UserEntity;
import com.example.service.AccessInfoService;

/** 
 * @ClassName: HelloController 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author 
 * @date 2018年3月13日 下午7:59:39 
 *  
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	@Autowired
	private UserEntity userEntity;

	@Autowired
	private AccessInfoService AccessInfoService;

	@GetMapping("/getUserEntity")
	public Object getUserEntity() {
		return userEntity;
	}

	@GetMapping("/getNum")
	public Object getNum() {
		int a = 1 / 0;
		return a;
	}

	@HandlerLog(desc = "就你知道是什么意思")
	@GetMapping("/getAccessInfo")
	public Object getAccessInfo() {
		return AccessInfoService.getAccessInfoByUUID("0wK5W8XK");
	}

}
