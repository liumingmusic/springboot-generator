package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.HbaseExampleEntity;
import com.example.service.IHbaseExampleService;
import com.example.utils.ResponseResult;

/**
 * @author doubleM
 * @ClassName: HbaseController
 * @Description: Hbase 新增、查询、删除操作示例代码
 * @date 2018年4月25日 下午2:20:50
 */
@RestController
@RequestMapping("/hbase")
public class HbaseController {

    @Autowired
    private IHbaseExampleService hbaseService;

    /**
     * 根据rowkey查询数据
     *
     * @param id hbase中的rowkey
     * @return hbase数据
     */
    @GetMapping("/get/{id}")
    public ResponseResult<List<HbaseExampleEntity>> getBean(@PathVariable String id) {
        List<HbaseExampleEntity> apples = hbaseService.getDataByRowkey(id);
        return ResponseResult.success("成功", apples);
    }

    /**
     * 批量存储数据
     *
     * @param list 前端传入集合数据
     * @return 是否成功
     */
    @PostMapping("/save")
    public ResponseResult<?> saveList(@RequestBody List<HbaseExampleEntity> list) {
        boolean saveBatch = hbaseService.saveBatch(list);
        if (saveBatch) {
            return ResponseResult.success();
        } else {
            return ResponseResult.error();
        }
    }
}
