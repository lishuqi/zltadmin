package com.ljy.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljy.manage.controller.base.BaseController;

/**
 * 有关登陆登出的控制器
 * @author LSQ
 * by QQ237442461 2016-10-7
 */
@Controller
public class LoginController extends BaseController{

	
	/**
	 * shiro登陆请求的地址
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("Manage/User/login.do")
	@SystemControllerLog(description="shiro登陆后台")
	public String login( Model model,HttpServletRequest request){
		// shiro在认证过程中出现错误后将异常类路径通过request返回
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				model.addAttribute("message", "账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				model.addAttribute("message", "用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				model.addAttribute("message", "验证码错误");
			} else{
				model.addAttribute("message", "服务器内部错误");
			}
		}else{
			model.addAttribute("message", "");
		}
		return "login/login";
	}
	
	/**
	 * 无权限页面
	 * @return
	 */
	@RequestMapping("Manage/Unauth/unauth.do")
	public String unauth(){
		return "manage/unauth/index";
	}
	
}
