package com.ljy.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljy.manage.controller.base.BaseController;

/**
 * 主页控制器
 * @author sq
 *
 *by QQ237442461 2016-8-19
 */
@Controller
public class IndexController extends BaseController{

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("Manage/index.do")
	@SystemControllerLog(description = "訪問首頁")
	public String index(){
		return "index/index";
	}
}
