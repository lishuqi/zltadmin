package com.ljy.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljy.entity.ZtreeNode;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.ztreenode.ZtreeNodeService;


/**
 * 数据字段左侧的树的控制器，可以进行树节点的增删改查
 * 
 * @author LSQ
 * by QQ237442461
 * 2016-9-21
 *
 */
@Controller
@RequestMapping("Manage/ZtreeNode")
public class ZtreeNodeController extends BaseController{

	private JSONArray jsonArray;
	
	@Resource(name = "ztreeNodeService")
	private ZtreeNodeService ztreeNodeService;
	
	/**
	 * tree的列表
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("list.do")
	@SystemControllerLog(description = "获取数据字典tree列表")
	public void list(Integer type,HttpServletResponse resp) throws IOException {
		try {
			List<ZtreeNode> list = this.ztreeNodeService.queryByType(type);
			super.printJsonData(resp, (this.jsonArray = JSONArray.fromObject(list.toArray())).toString());
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.printParamErrorMsg(resp);
	}
	
	/**
	 * 树节点增加
	 * @param id 添加时选中的节点的id
	 * @param name 添加节点的名称
	 * @param resp
	 * @throws IOException 
	 */
	@RequestMapping("add.do")
	@SystemControllerLog(description = "添加数据字典树节点")
	public void add(Long pid,String name,Integer type,HttpServletResponse resp) throws IOException{
		try {
			this.ztreeNodeService.addDictionaryZtreeNode(pid,name,type);
			Long id = this.ztreeNodeService.queryListOrderId();
			super.printJsonData(resp, id.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 树节点的编辑
	 * @param id：选中的节点的id
	 * @param name：新name
	 * @param resp
	 * @throws IOException 
	 */
	@SystemControllerLog(description = "数据字典树编辑")
	@RequestMapping("edit.do")
	public void edit(Long id,String name,HttpServletResponse resp) throws IOException{
		if(id == null || ("").equals(id)){
			super.printParamErrorMsg(resp);
		}
		if(name == null || ("").equals(name.trim())){
			super.printParamErrorMsg(resp);
		}
		try {
			this.ztreeNodeService.updateDicTreeNode(id,name);
			super.printDefaultSuccessMsg(resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.printParamErrorMsg(resp);
	}
	
	/**
	 * 删除选中的节点的树及其子节点，并删除其下面的所有字典值
	 * @param id：选中节点的id
	 * @param resp
	 * @throws Exception 
	 */
	@RequestMapping("delete.do")
	@SystemControllerLog(description = "删除数据字典树节点")
	public void delete(Long id,HttpServletResponse resp) throws Exception{
		if(id == null || ("").equals(id)){
			super.printParamErrorMsg(resp);
		}
		try {
			this.ztreeNodeService.deleteNodeAndChild(id);
			super.printDefaultSuccessMsg(resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.printInterErrorMsg(resp);
	}
}
