package com.example.service;

import com.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author
 * @ClassName: IRedisExampleServceTest
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2018年4月26日 下午3:18:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class IRedisExampleServceTest {

    @Autowired
    private IRedisExampleServce redisExampleServce;

    @Test
    public void testGet() {
        String string = redisExampleServce.get("a");
        System.out.println(string);
    }

    @Test
    public void testSet() {
        boolean set = redisExampleServce.set("name", "liuming_music@163.com");
        System.out.println(set);
    }

}
