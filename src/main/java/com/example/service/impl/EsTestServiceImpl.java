package com.example.service.impl;

import com.example.service.IEsTestService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: ES测试接口类
 *
 * @Author liumm
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Date 2019-01-12 18:28
 */
@Service
public class EsTestServiceImpl implements IEsTestService {

    @Autowired
    private TransportClient transportClient;

    @Override
    public Object getEeIndex() throws Exception {

        return null;
    }
}
