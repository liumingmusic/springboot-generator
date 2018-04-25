package com.example.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 
 * @ClassName: HconnectionFactory 
 * @Description: 初始化创建Hbase连接
 * @author doubleM
 * @date 2018年4月25日 下午1:53:46 
 *
 */
@Component
public class HconnectionFactory implements InitializingBean {

	protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${hbase.zookeeper.quorum}")
	private String zkQuorum;

	@Value("${hbase.master}")
	private String hBaseMaster;

	@Value("${hbase.zookeeper.property.clientPort}")
	private String zkPort;

	@Value("${zookeeper.znode.parent}")
	private String znode;

	private static Configuration conf = HBaseConfiguration.create();

	public static Connection connection;

	@Override
	public void afterPropertiesSet() {
		conf.set("hbase.zookeeper.quorum", zkQuorum);
		conf.set("hbase.zookeeper.property.clientPort", zkPort);
		conf.set("zookeeper.znode.parent", znode);
		conf.set("hbase.master", hBaseMaster);
		try {
			connection = ConnectionFactory.createConnection(conf);
			logger.info("hbase连接成功...");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("hbase连接失败!");
		}
	}
}
