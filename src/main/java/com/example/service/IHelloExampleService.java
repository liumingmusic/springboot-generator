package com.example.service;

import com.example.entity.HelloExampleEntity;

/**
 * @author doubleM
 * @ClassName: IHelloExampleService
 * @Description: 数据查询业务示例代码
 * @date 2018年3月16日 上午11:42:01
 */
public interface IHelloExampleService {

    HelloExampleEntity getHelloExampleUUID(String uuid);

}
