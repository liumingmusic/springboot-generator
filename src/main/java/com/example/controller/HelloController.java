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

import com.example.aop.AopExample;
import com.example.entity.UserEntity;
import com.example.service.IHelloExampleService;

/** 
 * @ClassName: HelloController 
 * @Description: 基础的业务实现类操作
 * 1、返回实体信息
 * 2、异常消息处理全局返回json
 * 3、消息日志打印示例和查询
 * @author doubleM
 * @date 2018年3月13日 下午7:59:39 
 *  
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	@Autowired
	private UserEntity userEntity;

	@Autowired
	private IHelloExampleService helloExampleService;

	@GetMapping("/getUserEntity")
	public Object getUserEntity() {
		return userEntity;
	}

	@GetMapping("/getNum")
	public Object getNum() {
		int a = 1 / 0;
		return a;
	}

	@AopExample(desc = "就你知道是什么意思")
	@GetMapping("/getAccessInfo")
	public Object getAccessInfo() {
		return helloExampleService.getHelloExampleUUID("0wK5W8XK");
	}

}
