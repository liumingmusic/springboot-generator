package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author doubleM
 * @ClassName: UserEntity
 * @Description: 资源文件对应的实体信息映射
 * @date 2018年3月15日 上午10:09:19
 */
@Getter
@Setter
@Component
@PropertySource(value = {"classpath:properties/dataExample.properties"})
public class UserEntity {

    @Value("${com.example.name}")
    private String name;

    @Value("${com.example.age}")
    private Integer age;

    @Value("${com.example.score}")
    private Double score;

}
