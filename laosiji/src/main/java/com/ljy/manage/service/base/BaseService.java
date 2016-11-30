package com.ljy.manage.service.base;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ljy.entity.base.BaseEntity;

public interface BaseService<T extends BaseEntity>{

	T queryById(Long id)throws Exception;
	
	List<T> queryAll()throws Exception;
	
	Integer queryAllCount()throws Exception;
	
	List<T> queryListByWhere(T t)throws Exception;
	
	PageInfo<T> queryListByPage(T t, Integer page, Integer rows)throws Exception;
	
	PageInfo<T> querListByPage2(T t,Integer page,Integer rows,String order) throws Exception;
	
	T queryOne(T t)throws Exception;
	
	Integer save(T t)throws Exception;
	
	Integer saveSelective(T t)throws Exception;
	
	Integer updateById(T t)throws Exception;
	
	Integer updateByIdSelective(T t)throws Exception;
	
	Integer deleteById(Long id)throws Exception;
	
	Integer deleteByIds(List<Object> ids)throws Exception;
	
	PageInfo<T> queryListByPage(T t, Integer page, Integer rows, String order) throws Exception;
	
}
