package com.ljy.manage.service.dictionary;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ljy.entity.Dictionary;
import com.ljy.manage.service.base.BaseService;

public interface DictionaryService extends BaseService<Dictionary>{

	List<Dictionary> queryAllByTreeId(Long treeId)throws Exception;
	
	PageInfo<Dictionary> queryListByPageAndTreeId(Dictionary dictionary,
			Long treeNodeId, Integer pageNumber, Integer pageSize, String string)
			throws Exception;
}
