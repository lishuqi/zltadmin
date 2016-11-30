package com.ljy.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.Gson;

public class JsonStrAndMapUtil {

	/**
	 * json字符串 转成 map
	 * 
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, Object> parseMap(String jsonStr) {
		if (jsonStr == null || "".equals(jsonStr)) {
			return null;
		}
		HashMap<String, Object> retMap = null;
		try {
			retMap = new HashMap<String, Object>();
			JSONObject json = JSONObject.fromObject(jsonStr);
			Map<String, Object> tmpMap = (Map<String, Object>) JSONObject
					.toBean(json, Map.class);
			for (Map.Entry<String, Object> entry : tmpMap.entrySet()) {
				Object tmp = entry.getValue();
				retMap.put(entry.getKey(), tmp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retMap;
	}

	/**
	 * HashMap<String, Object> map 转成 json字符串
	 * 
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public static String parseJsonStr(HashMap<String, Object> map) {
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			Object tmp = entry.getValue();
			retMap.put(entry.getKey(), tmp);
		}
		Gson gson = new Gson();
		return gson.toJson(retMap);
	}

}
