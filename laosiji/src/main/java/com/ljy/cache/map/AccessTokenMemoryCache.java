package com.ljy.cache.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信公衆號AccessToken本地緩衝
 * @author LSQ
 * by QQ237442461 2016-10-9
 *
 */
public class AccessTokenMemoryCache implements MemoryCache<String> {

	private Map<String, String> map = new ConcurrentHashMap<String, String>();
	
	@Override
	public String get(String key) {
		
		return map.get(key);
	}

	@Override
	public void remove(String key) {
		map.remove(key);
	}

	@Override
	public void set(String key, String value) {
		map.put(key, value);
	}


}
