/**   
 * @Title: HandlerLog.java 
 * @Package com.example.aop 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月16日 下午3:57:18 
 * @version 
 */
package com.example.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: HandlerLog 
 * @Description: 自定义注解AOP切面打印消息
 * @author doubleM
 * @date 2018年3月16日 下午3:57:18 
 *  
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AopExample {

	String desc() default "无信息";

}
