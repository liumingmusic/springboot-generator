package com.example.hbase;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 
 * @ClassName: HBaseBeanUtil 
 * @Description: Hbase实体映射工具类，使用注解进反射对应
 * @author doubleM
 * @date 2018年4月25日 下午1:45:19 
 *
 */
public class HBaseBeanUtil {

	private static final Logger logger = LoggerFactory.getLogger(HBaseBeanUtil.class);

	/**
	 * 
	 * @Description: JavaBean转换为Put
	 * @param obj 转换的实体
	 * @return 返回PUT类型
	 * @throws Exception 设定文件
	 */
	public static <T> Put beanToPut(T obj) throws Exception {
		Put put = new Put(Bytes.toBytes(parseObjId(obj)));
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
			if (StringUtils.isBlank(family) || StringUtils.isBlank(qualifier)) {
				continue;
			}
			Object fieldObj = field.get(obj);
			if (fieldObj.getClass().isArray()) {
				logger.error("nonsupport");
			}
			// rowkey不获取
			if ("rowkey".equalsIgnoreCase(qualifier) || "rowkey".equalsIgnoreCase(family)) {
				continue;
			}
			if (field.get(obj) != null || StringUtils.isNotBlank(field.get(obj).toString())) {
				put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), Bytes.toBytes(field.get(obj).toString()));
			}
		}
		return put;
	}

	/**
	 * 
	 * @Description: 获取Bean中的id,作为Rowkey
	 * @param obj 传入的实体名称
	 * @return 设定文件
	 */
	public static <T> String parseObjId(T obj) {
		Class<?> clazz = obj.getClass();
		try {
			// 实体中的ID就是hbase中的rowkey
			Field field = clazz.getDeclaredField("id");
			field.setAccessible(true);
			Object object = field.get(obj);
			return object.toString();
		} catch (NoSuchFieldException e) {
			logger.error("", e);
		} catch (SecurityException e) {
			logger.error("", e);
		} catch (IllegalArgumentException e) {
			logger.error("", e);
		} catch (IllegalAccessException e) {
			logger.error("", e);
		}
		return "";
	}

	/**
	 * 
	 * @Description: HBase result 转换为 bean
	 * @param result 结果集
	 * @param obj 实体值
	 * @return 返回转换好的结果实体
	 * @throws Exception 系统异常
	 */
	public static <T> T resultToBean(Result result, T obj) throws Exception {
		if (result == null) {
			return null;
		}
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (!field.isAnnotationPresent(HbaseColumn.class)) {
				continue;
			}
			HbaseColumn orm = field.getAnnotation(HbaseColumn.class);
			String family = orm.family();
			String qualifier = orm.qualifier();
			boolean timeStamp = orm.timestamp();
			if (StringUtils.isBlank(family) || StringUtils.isBlank(qualifier)) {
				continue;
			}
			String fieldName = field.getName();
			String value = "";
			if ("rowkey".equalsIgnoreCase(family)) {
				value = new String(result.getRow());
			} else {
				value = getResultValueByType(result, family, qualifier, timeStamp);
			}
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			Method setMethod = clazz.getMethod(setMethodName, new Class[] { field.getType() });
			setMethod.invoke(obj, new Object[] { value });
		}
		return obj;
	}

	/**
	 * 
	 * @Description: 返回结果对应值得类型
	 * @param result 结果集
	 * @param family 列簇
	 * @param qualifier 列名
	 * @param timeStamp 时间戳
	 * @return 返回字符串
	 */
	private static String getResultValueByType(Result result, String family, String qualifier, boolean timeStamp) {
		if (!timeStamp) {
			return new String(result.getValue(Bytes.toBytes(family), Bytes.toBytes(qualifier)));
		}
		List<Cell> cells = result.getColumnCells(Bytes.toBytes(family), Bytes.toBytes(qualifier));
		if (cells.size() == 1) {
			Cell cell = cells.get(0);
			return cell.getTimestamp() + "";
		}
		return "";
	}
}
