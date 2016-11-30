package com.ljy.manage.service.ztreenode;

import java.util.List;

import com.ljy.entity.ZtreeNode;
import com.ljy.manage.service.base.BaseService;

public interface ZtreeNodeService extends BaseService<ZtreeNode>{

	void addDictionaryZtreeNode(Long id,String name,Integer type) throws Exception;

	void updateDicTreeNode(Long id, String name) throws Exception;

	void deleteNodeAndChild(Long id) throws Exception;

	Long queryListOrderId() throws Exception;

	List<ZtreeNode> queryByType(Integer type)throws Exception;

}
