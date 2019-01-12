package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.HelloExampleEntity;
import com.example.utils.PageParam;
import org.springframework.stereotype.Component;

/**
 * @author doubleM
 * @ClassName: HelloExampleDao
 * @Description: 数据操作的接口类
 * @date 2018年3月15日 上午10:55:32
 */
@Mapper
@Component(value = "helloExampleDao")
public interface HelloExampleDao {

    /**
     * 根据id进行数据查询
     *
     * @param uuid id值
     * @return entity
     */
    HelloExampleEntity getHelloExampleUUID(@Param("uuid") String uuid);

    /**
     * 分页查询数据信息
     *
     * @param pageParam 参数
     * @return 分页
     */
    List<HelloExampleEntity> findByParams(PageParam pageParam);

}
