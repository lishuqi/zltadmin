package com.ljy.cache.map;

/**
 * 本地缓存接口设计
 * 
 * @author LSQ
 * by QQ237442461 2016-10-9
 */
public interface MemoryCache	<T> {

    T get(String key);

    void set(String key, T object);

    void remove(String key);

}
