package com.ljy.manage.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljy.common.bootstarp.BootStarpResult;
import com.ljy.entity.Permission;
import com.ljy.entity.RolePermission;
import com.ljy.entity.vo.RoleAuthVo;
import com.ljy.entity.vo.TreeVo;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.permission.PermissionService;

/**
 * 资源控制器
 * @author LSQ
 * by QQ237442461 
 */
@Controller
public class PermissionController extends BaseController{
	
	private JSONObject jsonObject;
	
	@Resource(name="permissionService")
	private PermissionService permissionService;
	
	/**
	 * 转发至权限资源首页
	 * @return
	 */
	@RequestMapping("Manage/Permission/index.do")
	@SystemControllerLog(description = "訪問权限资源首頁")
	public String index(Model model){
		return "manage/permission/index";
	}
	
	/**
	 * 数据字典列表
	 * @param pageSize
	 * @param pageNumber
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("Manage/Permission/list.do")
	@SystemControllerLog(description = "分页查询数据权限资源")
	public BootStarpResult list(Integer pageSize,Integer pageNumber,Long treeNodeId,HttpServletRequest req,HttpServletResponse resp){
		BootStarpResult bootStarpResult = null;
		PageInfo<Permission> pageInfo;
		try {
			if(treeNodeId!=null){
				pageInfo = this.permissionService.queryListByPageAndTreeId(null,treeNodeId, pageNumber, pageSize, "sort ASC");
			}else{
				pageInfo = this.permissionService.queryListByPage(null, pageNumber, pageSize, "created ASC");
			}
			bootStarpResult = new BootStarpResult(pageInfo.getTotal(), pageInfo.getList());
			return bootStarpResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 执行权限资源添加操作
	 * @param dictionary
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("Manage/Permission/add.do")
	@SystemControllerLog(description = "添加权限资源")
	public void add(Permission dictionary,HttpServletResponse resp) throws Exception{
		try {
			//保存资源
			this.permissionService.saveSelectiveColudPermissionType(dictionary);
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
	}
	
	/**
	 * 编辑时表单回显
	 * @param id
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("Manage/Permission/eidtFormEcho.do")
	@SystemControllerLog(description = "编辑权限资源值回显")
	public void eidtFormEcho(Long id,HttpServletResponse resp) throws IOException{
		Permission dictionary;
		try {
			dictionary = this.permissionService.queryById(id);
			this.jsonObject = JSONObject.fromObject(dictionary);
			super.printJsonData(resp, this.jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
		
	}
	
	/**
	 * 编辑
	 * @param dictionary
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("Manage/Permission/doEdit.do")
	@SystemControllerLog(description = "编辑权限资源")
	public void doEdit(Permission dictionary,HttpServletResponse resp) throws Exception {
		try {
			this.permissionService.updateByIdSelective(dictionary);
			super.printDefaultSuccessMsg(resp);
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
	@RequestMapping("Manage/Permission/delete.do")
	@SystemControllerLog(description = "删除资源")
	public void delete(String ids,HttpServletResponse resp) throws IOException{
		try {
			Object[] idsArray = ids.split("\\|");
			this.permissionService.deleteByIds(Arrays.asList(idsArray));
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
	}
	
	@RequestMapping("Manage/Permission/tree.do")
	@SystemControllerLog(description = "初始化资源授权树")
	@ResponseBody
	public List<TreeVo> tree(Long roleId,HttpServletRequest req,HttpServletResponse resp){
		try {
			List<TreeVo> list = this.permissionService.selectPermisssionTree();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 给角色授权
	 * @param userId
	 * @param roleId
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping(value = "Manage/Permission/authenrization.do",method = RequestMethod.POST)
	@SystemControllerLog(description = "角色授权")
	public void authenrization(RoleAuthVo roleAuthVo,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		try {
			if(roleAuthVo == null){
				super.printParamErrorMsg(resp);
			}
			this.permissionService.saveRoleAuthenrization(roleAuthVo.getRoleId(),roleAuthVo.getPermissionId());
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
	@RequestMapping("Manage/Permisssion/anthReturnView.do")
	@SystemControllerLog(description = "角色授权信息回显")
	@ResponseBody
	public List<RolePermission> anthReturnView(Long roleId,HttpServletRequest req,HttpServletResponse resp){
		try {
			List<RolePermission> list = this.permissionService.selectRolePermissionListByRoleId(roleId);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
