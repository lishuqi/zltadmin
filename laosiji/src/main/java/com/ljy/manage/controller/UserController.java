package com.ljy.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljy.common.bootstarp.BootStarpResult;
import com.ljy.entity.User;
import com.ljy.entity.UserRole;
import com.ljy.entity.vo.UserAuthVo;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.user.UserService;

/**
 * 角色控制器
 * @author sq
 *
 */
@Controller
public class UserController extends BaseController{

	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("Manage/User/index.do")
	@RequiresPermissions("manage:menu:user:index")
	@SystemControllerLog(description = "访问用戶首页")
	public String index(){
		return "manage/user/index";
	}
	
	/**
	 * 角色列表分页查询
	 * @param limit
	 * @param offset
	 * @param name
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("Manage/User/list.do")
	@SystemControllerLog(description = "分页查询用戶列表")
	public BootStarpResult list(Integer pageNumber,Integer pageSize,Long treeNodeId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		BootStarpResult bootStarpResult=null;
        PageInfo<User> pageInfo;
        try {
        	if(treeNodeId!=null){
        		if(treeNodeId != 1 && treeNodeId != 2){
        			User user = new User();
        			user.setTreeId(treeNodeId);
        			pageInfo = this.userService.queryListByPage(user, pageNumber, pageSize, "updated DESC");
        		}else{
        			pageInfo = this.userService.queryListByPageAndTreeId(null,treeNodeId, pageNumber, pageSize, "updated DESC");
        		}
			}else{
				pageInfo = this.userService.queryListByPage(null, pageNumber, pageSize, "updated DESC");
			}
            bootStarpResult = new BootStarpResult(pageInfo.getTotal(), pageInfo.getList());
            return bootStarpResult;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        super.printInterErrorMsg(resp);
        return null;
	}
	
	/**
	 * 执行用戶添加操作
	 * @param dictionary
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("Manage/User/add.do")
	@SystemControllerLog(description = "用戶添加")
	public void add(User user,HttpServletResponse resp,HttpServletRequest req) throws Exception{
		try {
			user.setPassword(com.ljy.common.MD5.md5(user.getPassword()));
			this.userService.saveuser(user);
			super.printDefaultSuccessMsg(resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
	}
	
	/**
	 * 删除选中数据：支持多条同时删除
	 * @param ids
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("Manage/User/delete.do")
	@SystemControllerLog(description = "用戶删除")
	public void delete(String ids,HttpServletResponse resp) throws IOException{
		try {
			this.userService.deleteByIdsVo(ids);
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
	}
	
	/**
	 * 给用户授权
	 * @param userId
	 * @param roleId
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping(value = "Manage/User/authenrization.do",method = RequestMethod.POST)
	@SystemControllerLog(description = "用户授权")
	public void authenrization(UserAuthVo userAuthVo,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		try {
			if(userAuthVo == null){
				super.printParamErrorMsg(resp);
			}
			this.userService.saveUserAuthenrization(userAuthVo.getUserId(),userAuthVo.getRoleId());
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			e.printStackTrace();
			super.printParamErrorMsg(resp);
		}
	}
	
	/**
	 * 用户授权信息回显
	 * @param userId
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("Manage/User/anthReturnView.do")
	@SystemControllerLog(description = "用户授权信息回显")
	@ResponseBody
	public List<UserRole> anthReturnView(Long userId,HttpServletRequest req,HttpServletResponse resp){
		try {
			List<UserRole> list = this.userService.selectUserRoleListByUserId(userId);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
