package com.ljy.manage.service.ztreenode;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.ljy.entity.Dictionary;
import com.ljy.entity.ZtreeNode;
import com.ljy.manage.mapper.DictionaryMapper;
import com.ljy.manage.mapper.ZtreeNodeMapper;
import com.ljy.manage.service.base.BaseServiceImpl;
import com.ljy.manage.service.systemlog.SystemServiceLog;

/**
 * ztree服务
 * 
 * @author LSQ
 * by QQ237442461 2016-10-18
 */
@Service("ztreeNodeService")
public class ZtreeNodeServiceImpl extends BaseServiceImpl<ZtreeNode> implements ZtreeNodeService{

	@Resource(name = "ztreeNodeMapper")
	private ZtreeNodeMapper ztreeNodeMapper;
	
	@Resource(name = "dictionaryMapper")
	private DictionaryMapper dictionaryMapper;

	/**
	 * 添加树节点，id为选中节点的id，name为添加的节点的名称
	 */
	@Override
	@SystemServiceLog(description = "添加树节点")
	public void addDictionaryZtreeNode(Long id,String name,Integer type) throws Exception {
		
		//添加新的节点设置自身为叶子节点
		ZtreeNode record = new ZtreeNode();
		record.setName(name);
		record.setpId(id);
		record.setType(type);
		record.setIsParent(false);
		this.ztreeNodeMapper.insertSelective(record);
		
		//保存父节点为文件节点
		ZtreeNode ztreeNode = this.ztreeNodeMapper.selectByPrimaryKey(id);
		ztreeNode.setIsParent(true);
		super.updateByIdSelective(ztreeNode);
	}

	/**
	 * 编辑节点，id为节点id，name为节点的新名称
	 */
	@Override
	@SystemServiceLog(description = "编辑节点")
	public void updateDicTreeNode(Long id, String name) throws Exception {
		ZtreeNode record = new ZtreeNode();
		record.setId(id);
		record.setName(name);
		this.ztreeNodeMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除树节点，并删除其子节点，及其子节点下的所有数据，并判断其父节点是否有其他的节点，否则将其父节点设置为叶子节点
	 */
	@Override
	@SystemServiceLog(description = "删除树节点")
	public void deleteNodeAndChild(Long id) throws Exception {
		ZtreeNode ztreeNode = this.ztreeNodeMapper.selectByPrimaryKey(id);
		//通用条件
		Example exampleDicTree = new Example(ZtreeNode.class);
		exampleDicTree.createCriteria().andEqualTo("pId", id);
		
		Example exampleDic = new Example(Dictionary.class);
		//判断其是否为父节点
		if(ztreeNode.isIsParent()){
			//获取所有的子节点
			List<ZtreeNode> list = this.ztreeNodeMapper.selectByExample(exampleDicTree);
			for (ZtreeNode dictionaryZtreeNode : list) {
				//获取每个子节点下的数据并进行删除
					exampleDic.createCriteria().andEqualTo("treeId", dictionaryZtreeNode.getId());
					this.dictionaryMapper.deleteByExample(exampleDic);
					//删除本身节点
					this.ztreeNodeMapper.deleteByPrimaryKey(dictionaryZtreeNode.getId());
			}
			
			//获取其父，判断其爸爸是否有其他子节点
			//size == 1 表示值有当前一个删除的子节点，
			if(list.size() == 1){
				//修改为叶子节点
				//修改其父节点为叶子节点的条件
				ZtreeNode record = new ZtreeNode();
				record.setId(ztreeNode.getpId());
				record.setIsParent(false);
				this.ztreeNodeMapper.updateByPrimaryKeySelective(record);
			}
			
			//删除其本身
			this.ztreeNodeMapper.deleteByPrimaryKey(ztreeNode.getId());
		}else{
			//删除其下的所有数据
			exampleDic.createCriteria().andEqualTo("treeId", ztreeNode.getId());
			this.dictionaryMapper.deleteByExample(exampleDic);
			
			//判断其父节点是否还有其他子节点
			List<ZtreeNode> list = this.ztreeNodeMapper.selectByExample(exampleDicTree);
			if(list.size() == 1){
				//修改为叶子节点
				ZtreeNode record = new ZtreeNode();
				record.setId(ztreeNode.getpId());
				record.setIsParent(false);
				this.ztreeNodeMapper.updateByPrimaryKeySelective(record);
			}
			//删除其本身
			this.ztreeNodeMapper.deleteByPrimaryKey(ztreeNode.getId());
		}
	}

	/**
	 * 查詢list根據id排序
	 */
	@Override
	@SystemServiceLog(description = "查询树列表")
	public Long queryListOrderId() throws Exception {
		Example example = new Example(this.getClass());
		example.setOrderByClause("id ASC");
		List<ZtreeNode> list = this.ztreeNodeMapper.selectByExample(example);
		return list.get(0).getId();
	}
	/**
	 * 根据树类型显示数据
	 */
	@Override
	@SystemServiceLog(description = "根据树类型查询树列表")
	public List<ZtreeNode> queryByType(Integer type) throws Exception {
		Example example = new Example(ZtreeNode.class);
		example.setOrderByClause("id ASC");
		example.createCriteria().andEqualTo("type", type);
		return this.ztreeNodeMapper.selectByExample(example);
	}
}
