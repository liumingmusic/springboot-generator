package com.example.service.impl;

import com.example.dao.HelloExampleDao;
import com.example.entity.HelloExampleEntity;
import com.example.service.IHelloExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author doubleM
 * @ClassName: AccessInfoServiceImpl
 * @Description: 业务操作dao层的代码示例
 * @date 2018年3月16日 上午11:42:58
 */
@Service
public class HelloExampleServiceImpl implements IHelloExampleService {

    @Autowired
    private HelloExampleDao helloExampleDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public HelloExampleEntity getHelloExampleUUID(String uuid) {
        HelloExampleEntity enInfo = helloExampleDao.getHelloExampleUUID(uuid);
        return enInfo;
    }

}
