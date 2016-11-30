package com.ljy.manage.service.role;


import java.util.List;

import com.ljy.common.bootstarp.PaginatorBootStarp;
import com.ljy.entity.Role;
import com.ljy.entity.vo.TreeVo;
import com.ljy.manage.service.base.BaseService;


public interface RoleService extends BaseService<Role>{

	List<Role> queryListByPage(PaginatorBootStarp paginatorBootStarp) throws Exception;

	Integer queryListByPageCount()throws Exception;

	void deleteByIdsVo(String ids) throws Exception;

	List<Role> queryListByPageLikeStr(Integer pageNumber, Integer pageSize,
			String queryString)throws Exception;

	void saveRole(Role role) throws Exception;

	List<TreeVo> selectRoleTree(Long userId) throws Exception;

	List<Role> queryRoleListByUserId(Long userId)throws Exception;

}
