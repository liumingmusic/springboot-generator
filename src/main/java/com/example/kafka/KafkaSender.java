package com.example.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 描述: kafka生成者
 *
 * @Author liumm
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Date 2019-01-12 23:22
 */
@Component
public class KafkaSender<T> {

    private static final Logger logger = LogManager.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.consumer.topic}")
    private String topic;

    /**
     * kafka生成消息
     *
     * @param obj 生产者
     */
    public void send(T obj) {
        String jsonObj = JSON.toJSONString(obj);
        logger.info("------------ message = {}", jsonObj);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, jsonObj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("Produce: The message failed to be sent:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //TODO 业务处理
                logger.info("Produce: The message was sent successfully:");
                logger.info("Produce: _+_+_+_+_+_+_+ result: " + stringObjectSendResult.toString());
            }
        });
    }


}
