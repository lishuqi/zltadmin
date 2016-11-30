package com.ljy.manage.service.dictionary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljy.entity.Dictionary;
import com.ljy.entity.ZtreeNode;
import com.ljy.manage.mapper.DictionaryMapper;
import com.ljy.manage.mapper.ZtreeNodeMapper;
import com.ljy.manage.service.base.BaseServiceImpl;
import com.ljy.manage.service.systemlog.SystemServiceLog;

@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements DictionaryService{

	@Autowired
	private ZtreeNodeMapper ztreeNodeMapper;
	
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	/**
	 * 动态填充页面下拉选项
	 */
	@Override
	@SystemServiceLog(description = "动态填充页面下拉选项")
	public List<Dictionary> queryAllByTreeId(Long treeId) throws Exception {
		Dictionary t = new Dictionary();
		t.setTreeId(treeId);
		return super.queryListByWhere(t);
	}

	/**
	 * 根据treeId分页查询资源list
	 */
	@Override
	@SystemServiceLog(description = "根据treeId分页查询资源list")
	public PageInfo<Dictionary> queryListByPageAndTreeId(Dictionary dictionary,
			Long treeNodeId, Integer pageNumber, Integer pageSize, String string)
			throws Exception {
		
		//1.查询选中的树节点实体
		ZtreeNode ztreeNode = this.ztreeNodeMapper.selectByPrimaryKey(treeNodeId);
		//2.如果此实体的pId == 0，说明为父节点
		if(ztreeNode.getpId() == 0){
			//3.根据id查询子树节点
			Example treeEx = new Example(ZtreeNode.class);
			treeEx.createCriteria().andEqualTo("pId", ztreeNode.getId());
			List<ZtreeNode> treeList = this.ztreeNodeMapper.selectByExample(treeEx);
			//4.将树节点的id封装为list
			List<Object> treeIdList = new ArrayList<Object>();
			for (ZtreeNode node : treeList) {	
				treeIdList.add(node.getId());
			}
			PageHelper.startPage(pageNumber, pageSize);
			Example exDic = new Example(Dictionary.class);
			exDic.setOrderByClause(string);
			exDic.createCriteria().andIn("treeId", treeIdList);
			List<Dictionary> dictionaryList = this.dictionaryMapper.selectByExample(exDic);
			//5.设置分页
			return new PageInfo<Dictionary>(dictionaryList);
		}else{
			//1.根据treeId分页查询
			PageHelper.startPage(pageNumber, pageSize);
			Example example = new Example(Dictionary.class);
			example.setOrderByClause(string);
			example.createCriteria().andEqualTo("treeId", treeNodeId);
			List<Dictionary> listPer = this.dictionaryMapper.selectByExample(example);
			return new PageInfo<Dictionary>(listPer);  
		}
		
	}
	
}
