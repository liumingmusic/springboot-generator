/**   
 * @Title: TaskAsync.java 
 * @Package com.example.scheduled 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月15日 上午11:20:30 
 * @version 
 */
package com.example.scheduled;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: TaskAsync 
 * @Description: 异步任务案例代码
 * @author doubleM
 * @date 2018年3月15日 上午11:20:30 
 *  
 */
@Component
public class AsyncExample {

	public static Random random = new Random();

	@Async
	public Future<String> doTaskOne() throws Exception {
		// 同上内容，省略
		System.out.println("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务一完成");
	}

	@Async
	public Future<String> doTaskTwo() throws Exception {
		// 同上内容，省略
		System.out.println("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务二完成");
	}

	@Async
	public Future<String> doTaskThree() throws Exception {
		// 同上内容，省略
		System.out.println("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务三完成");
	}

}
