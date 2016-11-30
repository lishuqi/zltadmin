package com.ljy.manage.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljy.common.bootstarp.BootStarpResult;
import com.ljy.entity.Dictionary;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.dictionary.DictionaryService;

/**
 * 数据字典控制器
 * @author LSQ
 * by QQ237442461
 */
@Controller
public class DictionaryController extends BaseController{
	
	private JSONObject jsonObject;
	
	@Resource(name = "dictionaryService")
	private DictionaryService dictionaryService;
	
	
	/**
	 * 转发至字典首页
	 * @return
	 */
	@RequestMapping("Manage/Dictionary/index.do")
	@SystemControllerLog(description = "訪問字典首頁")
	public String index(Model model){
		return "manage/dictionary/index";
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
	@RequestMapping("Manage/Dictionary/list.do")
	@SystemControllerLog(description = "分页查询数据字典数据")
	public BootStarpResult list(Integer pageSize,Integer pageNumber,Long treeNodeId,HttpServletRequest req,HttpServletResponse resp){
		BootStarpResult bootStarpResult = null;
		PageInfo<Dictionary> pageInfo;
		//Dictionary dictionary = null;
		try {
			if(treeNodeId!=null){
				pageInfo = this.dictionaryService.queryListByPageAndTreeId(null,treeNodeId, pageNumber, pageSize, "sort ASC");
			}else{
				pageInfo = this.dictionaryService.queryListByPage(null, pageNumber, pageSize, "id ASC");
			}
			bootStarpResult = new BootStarpResult(pageInfo.getTotal(), pageInfo.getList());
			return bootStarpResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 执行数据字典添加操作
	 * @param dictionary
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("Manage/Dictionary/add.do")
	@SystemControllerLog(description = "添加数据字典")
	public void add(Dictionary dictionary,HttpServletResponse resp) throws Exception{
		try {
			dictionary.setCreated(new Date());
			dictionary.setUpdated(dictionary.getCreated());
			this.dictionaryService.saveSelective(dictionary);
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			super.printInterErrorMsg(resp);
			e.printStackTrace();
		}
	}
	
	/**
	 * 编辑时表单回显
	 * @param id
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("Manage/Dictionary/eidtFormEcho.do")
	@SystemControllerLog(description = "编辑数据字典值回显")
	public void eidtFormEcho(Long id,HttpServletResponse resp) throws IOException{
		Dictionary dictionary;
		try {
			dictionary = this.dictionaryService.queryById(id);
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
	@RequestMapping("Manage/Dictionary/doEdit")
	@SystemControllerLog(description = "编辑数据字典值")
	public void doEdit(Dictionary dictionary,HttpServletResponse resp) throws Exception {
		try {
			this.dictionaryService.updateByIdSelective(dictionary);
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
	@RequestMapping("Manage/Dictionary/delete.do")
	@SystemControllerLog(description = "删除数据字典值")
	public void delete(String ids,HttpServletResponse resp) throws IOException{
		try {
			Object[] idsArray = ids.split("\\|");
			this.dictionaryService.deleteByIds(Arrays.asList(idsArray));
			super.printDefaultSuccessMsg(resp);
		} catch (Exception e) {
			e.printStackTrace();
			super.printInterErrorMsg(resp);
		}
	}
	/**
	 * 根据树节点id填充下拉框
	 * @param treeId
	 * @return
	 */
	@RequestMapping("Manage/Dictionary/getSelections.do")
	@ResponseBody
	@SystemControllerLog(description = "根据树id填充select")
	public List<Dictionary> getSelectionsByTreeId(Long treeId){
		try {
			List<Dictionary> list = this.dictionaryService.queryAllByTreeId(treeId);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
