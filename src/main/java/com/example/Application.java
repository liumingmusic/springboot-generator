package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @ClassName: Application 
 * @Description: 初始化启动代码
 * @author doubleM
 * @date 2018年3月16日 上午11:24:57 
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan("com.example.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
