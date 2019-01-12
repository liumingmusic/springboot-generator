package com.example.service;

/**
 * @author
 * @ClassName: IRedisExampleServce
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2018年4月26日 下午3:05:17
 */
public interface IRedisExampleServce {

    String get(String key);

    boolean set(String key, String val);

}
