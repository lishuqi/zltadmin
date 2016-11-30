package com.ljy.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljy.common.bootstarp.BootStarpResult;
import com.ljy.entity.Role;
import com.ljy.entity.vo.TreeVo;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.role.RoleService;

/**
 * 角色控制器
 * @author LSQ
 * by QQ237442461 2016-10-6
 *
 */
@Controller
public class RoleController extends BaseController{

	@Resource(name="roleService")
	private RoleService roleService;
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("Manage/Role/index.do")
	@SystemControllerLog(description = "访问角色首页")
	public String index(){
		return "manage/role/index";
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
	@RequestMapping("Manage/Role/list.do")
	@SystemControllerLog(description = "分页查询角色列表")
	public BootStarpResult list(Integer pageNumber,Integer pageSize,Long treeNodeId,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		BootStarpResult bootStarpResult=null;
        PageInfo<Role> pageInfo;
        try {
            Role role = new Role();
            if(treeNodeId != null){
        		role.setTreeId(treeNodeId);
        	}
            pageInfo = this.roleService.queryListByPage(role, pageNumber, pageSize, "updated ASC");
            bootStarpResult = new BootStarpResult(pageInfo.getTotal(), pageInfo.getList());
            return bootStarpResult;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        super.printInterErrorMsg(resp);
        return null;
	}
	
	/**
	 * 执行角色添加操作
	 * @param dictionary
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("Manage/Role/add.do")
	@SystemControllerLog(description = "角色添加")
	public void add(Role role,HttpServletResponse resp,HttpServletRequest req) throws Exception{
		try {
			this.roleService.saveRole(role);
			super.printDefaultSuccessMsg(resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			super.printDefaultSuccessMsg(resp);
		}
	}
	
	/**
	 * 删除选中数据：支持多条同时删除
	 * @param ids
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("Manage/Role/delete.do")
	@SystemControllerLog(description = "角色删除")
	public void delete(String ids,HttpServletResponse resp) throws IOException{
		try {
			this.roleService.deleteByIdsVo(ids);
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
	}
	/**
	 * 获取角色树
	 * @return
	 */
	@RequestMapping("Manage/Role/tree.do")
	@SystemControllerLog(description = "获取角色树")
	@ResponseBody
	public List<TreeVo> tree(Long userId){
		try {
			List<TreeVo> list = this.roleService.selectRoleTree(userId);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
