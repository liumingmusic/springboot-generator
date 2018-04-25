package com.example.hbase;

import java.lang.annotation.*;

/**
 * 
 * @ClassName: HbaseTable 
 * @Description: 自定义注解，用于获取table
 * @author doubleM
 * @date 2018年4月25日 下午2:01:25 
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Inherited
public @interface HbaseTable {

	// 表名
	String tableName() default "";
}
