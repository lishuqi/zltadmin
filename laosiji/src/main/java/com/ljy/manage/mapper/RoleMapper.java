package com.ljy.manage.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.abel533.mapper.Mapper;
import com.ljy.common.bootstarp.PaginatorBootStarp;
import com.ljy.entity.Role;

@Repository("roleMapper")
public interface RoleMapper extends Mapper<Role>{

	List<Role> queryListByPage(PaginatorBootStarp paginatorBootStarp);

	Integer queryListByPageCount();

	List<Role> queryListByPageLikeStr(PaginatorBootStarp paginatorBootStarp);

	void deleteUserRoleByRoleId(long roleId) throws Exception;

	void deleteRolePermissionByRoleId(long roleId)throws Exception;

	List<Role> queryRoleListByUserId(Long userId)throws Exception;


}
