package com.ljy.common;

import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

/**
 * 將對象封裝為map
 * @author LSQ
 *
 */
public class ObjectToMap {
	/**
	 * 将对象装成map形式
	 * @param src
	 * @return
	 */
	public static Map toMap(Object src) {
		return BeanMap.create(src);
	}
}
