package com.ljy.manage.controller.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;



/**
 * controller继承类
 * 
 * @author sq
 *
 *by：QQ237442461 2016-8-19
 */
public class BaseController {

	//初始化字符串，用于replace响应前台
	public String DEFAULT_RESULT_TEMPLATE="{\"status\":\"$status\",\"id\":\"$id\",\"msg\":\"$msg\"}";
	public static final String MSG_SUCCESS_STATUS="99";
	public static final String MSG_SUCCESS_ID="99";
	public static final String MSG_SUCCESS_MSG="执行成功";
	public static final String MSG_FAILUE_STATUS="-1";
	public static final String MSG_FAILUE_ID="-1";
	public static final String MSG_FAILUE_MSG="执行失败";
	public static final String MSG_PARAMERROR_STATUS="-2";
	public static final String MSG_PARAMERROR_MSG="参数错误";
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**得到ModelAndView
	 * @return
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**得到request对象
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 写json数据
	 * @param response
	 * @param jsonString
	 * @throws IOException
	 */
	public void printJsonData(HttpServletResponse response,String jsonString) throws IOException{
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonString);
		response.getWriter().flush();
	}
	
	
	/**
	 * 写默认的成功消息
	 * @param resp
	 * @throws IOException
	 */
	public void printDefaultSuccessMsg(HttpServletResponse resp) throws IOException{
		printMsg(resp,MSG_SUCCESS_STATUS,MSG_SUCCESS_ID,MSG_SUCCESS_MSG);
	}
	
	/**
	 * 写默认的参数错误消息
	 * @param resp
	 * @throws IOException
	 */
	public void printParamErrorMsg(HttpServletResponse resp) throws IOException{
		
		printMsg(resp,MSG_PARAMERROR_STATUS,MSG_FAILUE_ID,MSG_PARAMERROR_MSG);
	}
	
	/**
	 * 写默认的服务器内部错误消息
	 * @param resp
	 * @throws IOException
	 */
	public void printInterErrorMsg(HttpServletResponse resp) throws IOException{
		printMsg(resp,MSG_FAILUE_STATUS,MSG_FAILUE_ID,MSG_FAILUE_MSG);
	}
	
	/**
	 * 自定义写数据
	 * @param response
	 * @param status
	 * @param id
	 * @param msg
	 * @throws IOException
	 */
	public void printMsg(HttpServletResponse response,String status,String id,String msg) throws IOException{
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(getJsonResult(status,id,msg));
		response.getWriter().flush();
	}
	public String getJsonResult(String status,String id,String msg){
		return DEFAULT_RESULT_TEMPLATE.replace("$status",status).replace("$id", id).replace("$msg", msg);
	}
	
	/**
	 * 日志打印，开始执行
	 * @param logger
	 * @param interfaceName
	 */
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	/**
	 * 日志打印，执行完毕
	 * @param logger
	 * @param interfaceName
	 */
	public static void logAfter(Logger logger,String interfaceName){
		logger.info("end");
		logger.info("");
		logger.info(interfaceName);
	}
	
}
