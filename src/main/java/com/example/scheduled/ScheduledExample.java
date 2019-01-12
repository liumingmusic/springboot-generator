package com.example.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

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
