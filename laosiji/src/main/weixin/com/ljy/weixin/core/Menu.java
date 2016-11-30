package com.ljy.weixin.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ljy.weixin.common.Const;
import com.ljy.weixin.common.SNSUserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Menu {
	public static void main(String[] args) {
		Menu.creat();
		// WeiXinUtil.deleteMenu();
	}

	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 4 * 发起 https 请求并获取结果 * @param requestUrl 请求地址 * @param
	 * requestMethod请求方式（GET、POST） * @param outputStr 提交的数据 *@return
	 * JSONObject(通过 JSONObject.get(key)的方式获取 json 对象的属性值)
	 * */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			httpUrlConn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			httpUrlConn.connect();
			OutputStream os = httpUrlConn.getOutputStream();
			os.write(outputStr.getBytes("UTF-8"));// 传入参数
			os.flush();
			os.close();
			InputStream is = httpUrlConn.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			System.out.println(message);
		} catch (ConnectException e) {
			e.printStackTrace();
			System.out.println("创建失败");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建失败");
		}
		return jsonObject;
	}

	public static void creat() {
		String ms = "{" 
			+ "\"button\":[" 
			+ "{	" 
			+ "\"type\":\"click\","
			+ "\"name\":\"联系我们\"," 
			+ "\"key\":\"V1001_TODAY_MUSIC\"" 
			+ "},"
			+ "{	" 
			+ "\"type\":\"view\","
			+ "\"name\":\"老司基\"," 
			+ "\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9f1baaaff5690df3&redirect_uri=http://4772548d.ngrok.io/Weixin/Index/index.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect\""
			+ "}"
			+ "]" 
			+ "}";

		// 拼装创建菜单的 url
		String url = menu_create_url.replace("ACCESS_TOKEN", Menu
				.readTxtFile("f:/access_token.txt"));
		JSONObject jsonObject = Menu.httpRequest(url, "POST", ms);
		System.out.println("菜单创建完成");
	}

	/**
	 * 删除当前Menu
	 * 
	 * @Title: deleteMenu
	 * @Description: 删除当前Menu
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String deleteMenu() {
		String access_token = Menu.readTxtFile("f:/access_token.txt");
		String action = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
				+ access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();
			OutputStream os = http.getOutputStream();
			os.flush();
			os.close();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			System.out.println(message);
			return "deleteMenu返回信息:" + message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("deleteMenu 失败");
		return "deleteMenu 失败";
	}

	/**
	 * 通过网页授权获取用户信息
	 * 
	 * @param accessToken
	 *            网页授权接口调用凭证
	 * @param openId
	 *            用户标识
	 * @return SNSUserInfo
	 */
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace(
				"OPENID", openId);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = Menu.httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// 用户的标识
				snsUserInfo.setOpenId(jsonObject.getString("	"));
				// 昵称
				snsUserInfo.setNickname(jsonObject.getString("nickname"));
				// 性别（1是男性，2是女性，0是未知）
				snsUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				snsUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				snsUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				snsUserInfo.setCity(jsonObject.getString("city"));
				// 用户头像
				snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// 用户特权信息
				snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject
						.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				System.out.println(errorCode + errorMsg);
			}
		}
		return snsUserInfo;
	}

	/**
	 * 静默授权获取用户openId
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String OuthGetOpenId(HttpServletRequest req,
			HttpServletResponse resp, String code)
			throws UnsupportedEncodingException {
		// 静默授权
		String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
				+ "appid="
				+ Const.WEIXIN_APPID
				+ "&secret="
				+ Const.WEIXIN_APPSECRET
				+ "&code=CODE&grant_type=authorization_code";

		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		System.out.println("******************code=" + code);

		get_access_token_url = get_access_token_url.replace("CODE", code);

		String json = doHttpsGetJson(get_access_token_url);

		JSONObject jsonObject = JSONObject.fromObject(json);
		String openid = jsonObject.getString("openid");
		return openid;

	}

	/**
	 * 静默授权调用的方法
	 * 
	 * @param Url
	 * @return
	 */
	public static String doHttpsGetJson(String Url) {
		String message = "";
		try {
			System.out.println("doHttpsGetJson");// TODO:dd
			URL urlGet = new URL(Url);
			HttpURLConnection http = (HttpURLConnection) urlGet
					.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求 24
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒28
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒29
			// 30
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			message = new String(jsonBytes, "UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}

	// 读取文件
	public static String readTxtFile(String filePath) {
		try {
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println(lineTxt);
					return lineTxt;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return "";
	}
	
}