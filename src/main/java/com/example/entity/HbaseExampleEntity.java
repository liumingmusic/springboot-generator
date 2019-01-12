package com.example.entity;

import com.example.hbase.HbaseColumn;
import com.example.hbase.HbaseTable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author doubleM
 * @ClassName: HbaseExampleEntity
 * @Description: 与Hbase中表的rowkey、列簇、列名以及列对应
 * @date 2018年4月25日 下午2:13:26
 */
@Getter
@Setter
@HbaseTable(tableName = "t1")
public class HbaseExampleEntity {

    /**
     * 标示数据中rowkey，用在新增时候填充
     */
    @HbaseColumn(family = "rowkey", qualifier = "rowkey")
    private String id;

    /**
     * 列簇、列映射的实体名称，用于查询的数据返回
     */
    @HbaseColumn(family = "f1", qualifier = "c1")
    private String c1;


}
