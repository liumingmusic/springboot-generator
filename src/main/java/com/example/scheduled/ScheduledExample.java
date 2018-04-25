/**   
 * @Title: ScheduledTasks.java 
 * @Package com.example.scheduled 
 * @Description: (用一句话描述该文件做什么) 
 * @author 
 * @date 2018年3月15日 上午11:16:39 
 * @version 
 */
package com.example.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: ScheduledTasks 
 * @Description: 定时任务案例代码
 * @author doubleM
 * @date 2018年3月15日 上午11:16:39 
 *  
 */
@Component
public class ScheduledExample {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 60 * 60 * 1000)
	public void reportCurrentTime() {
		System.out.println("现在时间：" + dateFormat.format(new Date()));
	}
}
