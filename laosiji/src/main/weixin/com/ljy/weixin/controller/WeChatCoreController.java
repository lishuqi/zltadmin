package com.ljy.weixin.controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ljy.manage.controller.base.BaseController;
import com.ljy.weixin.common.Const;
import com.ljy.weixin.common.SignUtil;
import com.ljy.weixin.core.WXCoreService;

@Controller
public class WeChatCoreController extends BaseController{
	/**
	 * 微信接入接口
	 * 
	 * @param out
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "Weixin/index.do", method = RequestMethod.GET)
	public void index(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		logBefore(logger, "微信接口");
		// 微信加密签名
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String echostr = req.getParameter("echostr");
		PrintWriter out = resp.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.flush();
		out.close();
		out = null;
	}
	/**
	 * post
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.POST)
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		//设置请求和响应的编码
		req.setCharacterEncoding("UTF-8"); 
		 resp.setCharacterEncoding("UTF-8"); 
		// 调用核心业务类接收消息、处理消息
		 String respMessage = WXCoreService.processRequest(req); 
		 
		 // 响应消息 
		 PrintWriter out = resp.getWriter(); 
		 out.print(respMessage); 
	}
	
	// ================================================获取access_token==============================================================
	/**
	 * 获取access_token
	 * 
	 * @param out
	 */
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?"
			+ "grant_type=client_credential&appid=APPID&secret=APPSECRET";

	@RequestMapping(value = "Weixin/getAt.do")
	public void getAt(PrintWriter out) {
		logBefore(logger, "获取access_token");
		try {
			String appid = Const.WEIXIN_APPID;
			String appsecret = Const.WEIXIN_APPSECRET;

			String requestUrl = access_token_url.replace("APPID", appid)
					.replace("APPSECRET", appsecret);
			JSONObject jsonObject = httpRequst(requestUrl, "GET", null);

			System.out.println(jsonObject.getString("access_token")
					+ "============");

			PrintWriter pw;
			try {
				pw = new PrintWriter(new FileWriter("f:/access_token.txt"));
				pw.print(jsonObject.getString("access_token"));
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.write("success");
			out.close();
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}
	public JSONObject httpRequst(String requestUrl, String requetMethod,
			String outputStr) {
		JSONObject jsonobject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的新人管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslcontext = SSLContext.getInstance("SSL", "SunJSSE");
			sslcontext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocktFactory对象
			SSLSocketFactory ssf = sslcontext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requetMethod);

			if ("GET".equalsIgnoreCase(requetMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonobject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			// TODO: handle exception
		} catch (Exception e) {
		}
		return jsonobject;
	}
	// ================================================获取access_token==============================================================
}

class MyX509TrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub

	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub

	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
}
