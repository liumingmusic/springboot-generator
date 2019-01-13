package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author doubleM
 * @ClassName: UserEntity
 * @Description: 另外一种资源文件对应的实体信息映射
 * @date 2018年3月15日 上午10:09:19
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "com.example")
@PropertySource(value = {"classpath:properties/dataExample.properties"})
public class UserEntity {

    private String name;

    private Integer age;

    private Double score;

}
