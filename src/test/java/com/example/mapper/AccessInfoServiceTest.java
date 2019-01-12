package com.example.mapper;

import com.example.Application;
import com.example.dao.HelloExampleDao;
import com.example.entity.HelloExampleEntity;
import com.example.scheduled.AsyncExample;
import com.example.utils.PageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @author
 * @ClassName: AccessInfoMapperTest
 * @Description: 单元测试类示例
 * @date 2018年3月15日 上午10:59:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AccessInfoServiceTest {

    @Autowired
    private HelloExampleDao accessInfoDao;

    @Autowired
    private AsyncExample taskAsync;

    @Test
    @Rollback
    public void findByName() throws Exception {
        PageParam pageParam = new PageParam();
        HelloExampleEntity accessInfoByUUID = accessInfoDao.getHelloExampleUUID("0wK5W8XK");
        System.out.println(pageParam);
        System.out.println(accessInfoByUUID);
    }

    @Test
    @Rollback
    public void findByParams() throws Exception {
        PageParam pageParam = new PageParam();
        accessInfoDao.findByParams(pageParam);
        System.out.println(pageParam);
    }

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = taskAsync.doTaskOne();
        Future<String> task2 = taskAsync.doTaskTwo();
        Future<String> task3 = taskAsync.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
