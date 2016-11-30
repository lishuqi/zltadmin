package com.ljy.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljy.common.bootstarp.BootStarpResult;
import com.ljy.entity.Log;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.log.LogService;

/**
 * 日志 控制器
 * @author sq
 * by QQ237442461 2016-10-6
 */
@Controller
@RequestMapping("Manage/Log")
public class LogController extends BaseController{

	@Resource(name="logService")
	private LogService logService;
	
	/**
	 * 转发至日志首页
	 * @return
	 */
	@RequestMapping("system.do")
	@SystemControllerLog(description = "访问系统日志首页")
	public String index(){
		return "manage/log/system";
	}
	/**
	 * 转发至日志首页
	 * @return
	 */
	@RequestMapping("error.do")
	@SystemControllerLog(description = "访问异常日志首页")
	public String indexError(){
		return "manage/log/error";
	}
	
	/**
	 * 日志列表
	 * @param pageSize
	 * @param pageNumber
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("list.do")
	@SystemControllerLog(description = "查詢日志列表")
	public BootStarpResult list(Integer pageSize,Integer pageNumber,Integer type,String title,HttpServletRequest req,HttpServletResponse resp){
		BootStarpResult bootStarpResult = null;
		PageInfo<Log> pageInfo;
		Log log = null;
		try {
			if(type!=null){
				log = new Log();
				log.setType(type);
				pageInfo = this.logService.queryListByPage(log, pageNumber, pageSize, "add_date DESC");
			}else{
				pageInfo = this.logService.queryListByPage(null, pageNumber, pageSize, "add_date DESC");
			}
			bootStarpResult = new BootStarpResult(pageInfo.getTotal(), pageInfo.getList());
			return bootStarpResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bootStarpResult;
	}
}
