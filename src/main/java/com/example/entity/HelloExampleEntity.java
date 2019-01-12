package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author doubleM
 * @ClassName: HelloExampleEntity
 * @Description: 基本对应的数据库实体信息
 * @date 2018年4月25日 下午5:18:50
 */
@Setter
@Getter
@ToString
public class HelloExampleEntity implements Serializable {

    /**
     * (用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 302780684394764360L;

    /**
     * 任务ID
     */
    private int id;

    /**
     * 接口请求uri
     */
    private String uri;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 查询请求时间
     */
    private String query;

    /**
     * 接口访问时间
     */
    private long inTime;

    /**
     * 接口输出时间
     */
    private long outTime;

    /**
     * 接口数据字节大小
     */
    private long dataBytes;

    /**
     * 命中的条数
     */
    private long record;

    /**
     * 状态
     */
    private String status;

    /**
     * 消耗时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Long espTime;

}
