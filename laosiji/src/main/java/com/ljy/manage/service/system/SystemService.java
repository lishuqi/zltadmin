package com.ljy.manage.service.system;

import org.springframework.beans.factory.annotation.Value;



/**
 * 不采用静态字符串的方式储存公共数据，使用读取properties的方式，因为静态资源是无法被垃圾回收机制回收的。
 * 
 * @author LSQ 
 * by QQ237442461
 * 2016-9-21
 */
@org.springframework.stereotype.Service("systemService")
public class SystemService {

	/**
	 * 系统名称
	 */
	@Value("${systemName}")
	public static String title;
}
