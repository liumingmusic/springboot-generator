package com.example.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 描述: ES实例化
 *
 * @Author liumm
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Date 2019-01-12 15:21
 */
@Component
public class ElasticsearchConfig {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchConfig.class);

    @Value("${spring.elasticsearch.url}")
    private String elasticsearchUrl;

    @Value("${spring.elasticsearch.clusterName}")
    private String clusterName;

    @Bean
    public TransportClient client() {
        logger.info("初始化elasticsearch开始");
        // elasticsearch的地址
        String[] esUrl = elasticsearchUrl.split(",");
        // elasticsearch的端口
        // 设置集群名字
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        TransportClient client = null;
        try {
            // 为client导入集群配置信息
            client = new PreBuiltTransportClient(settings);
            // 给client配置ES的地址，port是TCP端口，不是Http端口。针对多个节点可以增加多个地址。
            for (String url : esUrl) {
                String[] hostAndPort = url.split(":");
                String host = hostAndPort[0];
                Integer port = Integer.valueOf(hostAndPort[1]);
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
            }
            logger.info("初始化elasticsearch完成");
        } catch (UnknownHostException e) {
            logger.info("初始化elasticsearch失败");
            e.printStackTrace();
        }
        return client;
    }

}
