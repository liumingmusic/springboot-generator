package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 描述: kafka实体类
 *
 * @Author liumm
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * @Date 2019-01-12 23:17
 */
@Getter
@Setter
public class KafkaMessageEntity {

    private Long id;

    private String msg;

    private Date sendTime;

}
