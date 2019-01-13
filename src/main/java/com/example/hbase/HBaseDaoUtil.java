package com.example.hbase;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author doubleM
 * @ClassName: HBaseDaoUtil
 * @Description: HBaseDao操作公共类，关闭连接、创建表、删除表、scan表、保存数据删除数据
 * @date 2018年4月25日 下午1:46:30
 */
@Component
public class HBaseDaoUtil {

    private static final Logger logger = LoggerFactory.getLogger(HBaseDaoUtil.class);

    /**
     * 创建表
     *
     * @param tableName    表名
     * @param familyColumn 列簇名
     */
    public void createTable(String tableName, Set<String> familyColumn) {
        TableName tn = TableName.valueOf(tableName);
        try (Admin admin = HconnectionFactory.connection.getAdmin();) {
            HTableDescriptor htd = new HTableDescriptor(tn);
            for (String fc : familyColumn) {
                HColumnDescriptor hcd = new HColumnDescriptor(fc);
                htd.addFamily(hcd);
            }
            admin.createTable(htd);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("创建" + tableName + "表失败！", e);
        }
    }

    /**
     * 删除表
     *
     * @param tableName 表名
     */
    public void dropTable(String tableName) {
        TableName tn = TableName.valueOf(tableName);
        try (Admin admin = HconnectionFactory.connection.getAdmin();) {
            admin.disableTable(tn);
            admin.deleteTable(tn);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("删除" + tableName + "表失败！");
        }
    }

    /**
     * 根据条件过滤查询
     *
     * @param obj   查询成功的泛型对象
     * @param param 过滤参数
     * @param <T>   对象
     * @return 返回数据集合
     * @throws Exception 系统异常
     */
    public <T> List<T> queryScan(T obj, Map<String, String> param) throws Exception {
        List<T> objs = new ArrayList<T>();
        String tableName = getORMTable(obj);
        if (StringUtils.isBlank(tableName)) {
            return null;
        }
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
             Admin admin = HconnectionFactory.connection.getAdmin();) {
            if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
                return objs;
            }
            Scan scan = new Scan();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                Class<?> clazz = obj.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(HbaseColumn.class)) {
                        continue;
                    }
                    field.setAccessible(true);
                    HbaseColumn orm = field.getAnnotation(HbaseColumn.class);
                    String family = orm.family();
                    String qualifier = orm.qualifier();
                    if (qualifier.equals(entry.getKey())) {
                        Filter filter = new SingleColumnValueFilter(Bytes.toBytes(family), Bytes.toBytes(entry.getKey()),
                                CompareFilter.CompareOp.EQUAL, Bytes.toBytes(entry.getValue()));
                        scan.setFilter(filter);
                    }
                }
            }
            ResultScanner scanner = table.getScanner(scan);
            for (Result result : scanner) {
                T beanClone = (T) BeanUtils.cloneBean(HBaseBeanUtil.resultToBean(result, obj));
                objs.add(beanClone);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询失败！");
            throw new Exception(e);
        }
        return objs;
    }

    /**
     * @param obj     返回对象的实体
     * @param rowkeys 数据rowkey
     * @return 设定文件
     * @Description: 根据rowkey查询
     */
    public <T> List<T> getListByRowKeys(T obj, String... rowkeys) {
        List<T> objs = new ArrayList<T>();
        String tableName = getORMTable(obj);
        if (StringUtils.isBlank(tableName)) {
            return objs;
        }
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
             Admin admin = HconnectionFactory.connection.getAdmin();) {
            if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
                return objs;
            }
            List<Result> results = getResults(tableName, rowkeys);
            if (results.isEmpty()) {
                return objs;
            }
            for (int i = 0; i < results.size(); i++) {
                T bean = null;
                Result result = results.get(i);
                if (result == null || result.isEmpty()) {
                    continue;
                }
                try {
                    bean = HBaseBeanUtil.resultToBean(result, obj);
                    objs.add(bean);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("查询异常！", e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    /**
     * @param objs 存入的实体集合
     * @return 设定文件
     * @Description: 保存实体对象
     */
    public <T> boolean save(List<T> objs) {
        List<Put> puts = new ArrayList<Put>();
        String tableName = "";
        try (Admin admin = HconnectionFactory.connection.getAdmin();) {
            for (Object obj : objs) {
                if (obj == null) {
                    continue;
                }
                tableName = getORMTable(obj);
                // 表不存在，先获取family创建表
                if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
                    // 获取family, 创建表
                    Class<?> clazz = obj.getClass();
                    Field[] fields = clazz.getDeclaredFields();
                    Set<String> set = new HashSet<>(10);
                    for (int i = 0; i < fields.length; i++) {
                        if (!fields[i].isAnnotationPresent(HbaseColumn.class)) {
                            continue;
                        }
                        fields[i].setAccessible(true);
                        HbaseColumn orm = fields[i].getAnnotation(HbaseColumn.class);
                        String family = orm.family();
                        // 单独获取rowkey
                        if ("rowkey".equalsIgnoreCase(family)) {
                            continue;
                        }
                        set.add(family);
                    }
                    // 创建表
                    createTable(tableName, set);
                }
                Put put = HBaseBeanUtil.beanToPut(obj);
                puts.add(put);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存Hbase异常！");
        }
        return savePut(puts, tableName);
    }

    /**
     * @param tableName 表名
     * @param objs      实体信息
     * @Description: 根据tableName保存
     */
    @SuppressWarnings("unchecked")
    public <T> void save(String tableName, T... objs) {
        List<Put> puts = new ArrayList<Put>();
        for (Object obj : objs) {
            if (obj == null) {
                continue;
            }
            try {
                Put put = HBaseBeanUtil.beanToPut(obj);
                puts.add(put);
            } catch (Exception e) {
                logger.warn("", e);
            }
        }
        savePut(puts, tableName);
    }

    /**
     * @param tableName 表名
     * @return 设定文件
     * @Description: 根据tableName获取列簇名称
     */
    public List<String> familys(String tableName) {
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));) {
            List<String> columns = new ArrayList<String>();
            if (table == null) {
                return columns;
            }
            HTableDescriptor tableDescriptor = table.getTableDescriptor();
            HColumnDescriptor[] columnDescriptors = tableDescriptor.getColumnFamilies();
            for (HColumnDescriptor columnDescriptor : columnDescriptors) {
                String columnName = columnDescriptor.getNameAsString();
                columns.add(columnName);
            }
            return columns;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询列簇名称失败！", e);
        }
        return new ArrayList<String>();
    }

    /**
     * @param obj
     * @param param
     * @return
     * @throws Exception 设定文件
     * @Description: 根据条件过滤查询（大于等于）
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryScanGreater(T obj, Map<String, String> param) throws Exception {
        List<T> objs = new ArrayList<T>();
        String tableName = getORMTable(obj);
        if (StringUtils.isBlank(tableName)) {
            return null;
        }
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
             Admin admin = HconnectionFactory.connection.getAdmin();) {
            if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
                return objs;
            }
            Scan scan = new Scan();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                Class<?> clazz = obj.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(HbaseColumn.class)) {
                        continue;
                    }
                    field.setAccessible(true);
                    HbaseColumn orm = field.getAnnotation(HbaseColumn.class);
                    String family = orm.family();
                    String qualifier = orm.qualifier();
                    if (qualifier.equals(entry.getKey())) {
                        Filter filter = new SingleColumnValueFilter(Bytes.toBytes(family), Bytes.toBytes(entry.getKey()),
                                CompareFilter.CompareOp.GREATER_OR_EQUAL, Bytes.toBytes(entry.getValue()));
                        scan.setFilter(filter);
                    }
                }
            }
            ResultScanner scanner = table.getScanner(scan);
            for (Result result : scanner) {
                T beanClone = (T) BeanUtils.cloneBean(HBaseBeanUtil.resultToBean(result, obj));
                objs.add(beanClone);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询失败！");
            throw new Exception(e);
        }
        return objs;
    }

    /**
     * @param obj     删除的实体
     * @param rowkeys rowkey
     * @Description: 删除
     */
    public <T> void delete(T obj, String... rowkeys) {
        String tableName = "";
        tableName = getORMTable(obj);
        if (StringUtils.isBlank(tableName)) {
            return;
        }
        List<Delete> deletes = new ArrayList<Delete>();
        for (String rowkey : rowkeys) {
            if (StringUtils.isBlank(rowkey)) {
                continue;
            }
            deletes.add(new Delete(Bytes.toBytes(rowkey)));
        }
        delete(deletes, tableName);
    }

    // 关闭连接
    public static void close() {
        if (HconnectionFactory.connection != null) {
            try {
                HconnectionFactory.connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param deletes   集合
     * @param tableName 删除表名
     * @Description: 批量删除
     */
    private void delete(List<Delete> deletes, String tableName) {
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));) {
            if (StringUtils.isBlank(tableName)) {
                logger.info("tableName为空！");
                return;
            }
            table.delete(deletes);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("删除失败！", e);
        }
    }

    /**
     * @param puts      多个puts
     * @param tableName 表名
     * @return 设定文件
     * @Description: 保存方法
     */
    private boolean savePut(List<Put> puts, String tableName) {
        if (StringUtils.isBlank(tableName)) {
            return false;
        }
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));
             Admin admin = HconnectionFactory.connection.getAdmin();) {
            table.put(puts);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param obj
     * @return 设定文件
     * @Description: tableName
     */
    private String getORMTable(Object obj) {
        HbaseTable table = obj.getClass().getAnnotation(HbaseTable.class);
        return table.tableName();
    }

    /**
     * @param tableName
     * @param rowkeys
     * @return 设定文件
     * @Description: 获取查询结果
     */
    private List<Result> getResults(String tableName, String... rowkeys) {
        List<Result> resultList = new ArrayList<Result>();
        List<Get> gets = new ArrayList<Get>();
        for (String rowkey : rowkeys) {
            if (StringUtils.isBlank(rowkey)) {
                continue;
            }
            Get get = new Get(Bytes.toBytes(rowkey));
            gets.add(get);
        }
        try (Table table = HconnectionFactory.connection.getTable(TableName.valueOf(tableName));) {
            Result[] results = table.get(gets);
            Collections.addAll(resultList, results);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return resultList;
        }
    }

}
