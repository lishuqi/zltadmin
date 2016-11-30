package com.ljy.weixin.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljy.manage.controller.base.BaseController;
import com.ljy.weixin.core.Menu;

/**
 * 老司基主页控制器
 * @author LSQ
 * by QQ237442461 2016-10-15
 *
 */
@Controller
public class WeChatIndexController extends BaseController{

	/**
	 * 老司机主页
	 * @return
	 */
	@RequestMapping("Weixin/Index/index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp,String code,Model model){
		try {
			//获取openId,并防止在session中
			String openId = Menu.OuthGetOpenId(req, resp,code);
			System.out.println("openId---------------------------------"+openId);
			req.getSession().setAttribute("openId", openId);
			logBefore(logger, openId);
			} catch (UnsupportedEncodingException e) {
			logBefore(logger, "获取openId失败");
			e.printStackTrace();	
		}
		return "weixin/index/index";
	}
}
