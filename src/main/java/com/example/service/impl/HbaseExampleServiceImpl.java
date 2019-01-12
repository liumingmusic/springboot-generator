package com.example.service.impl;

import com.example.entity.HbaseExampleEntity;
import com.example.hbase.HBaseDaoUtil;
import com.example.service.IHbaseExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author doubleM
 * @ClassName: HbaseServiceImpl
 * @Description: 业务操作Hbase的示例
 * @date 2018年4月25日 下午2:16:35
 */
@Service
public class HbaseExampleServiceImpl implements IHbaseExampleService {

    @Autowired
    private HBaseDaoUtil hBaseDaoUtil;

    /**
     * Title: getDataByRowkey
     * Description:
     *
     * @param id
     * @return
     */
    @Override
    public List<HbaseExampleEntity> getDataByRowkey(String id) {
        HbaseExampleEntity entity = new HbaseExampleEntity();
        List<HbaseExampleEntity> list = hBaseDaoUtil.getListByRowKeys(entity, id);
        return list;
    }

    /**
     * Title: saveBatch
     * Description:
     *
     * @param list
     */
    @Override
    public boolean saveBatch(List<HbaseExampleEntity> list) {
        return hBaseDaoUtil.save(list);
    }

}
