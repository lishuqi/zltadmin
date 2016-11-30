package com.ljy.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.ljy.entity.Permission;
import com.ljy.entity.RolePermission;

public interface PermissionMapper extends Mapper<Permission>{

	List<Permission> queryPermissionListByUserId(Long userId)throws Exception;

	void savePermissionAuthenrization(RolePermission rolePermission)throws Exception;

	void deleteRolePermissionByRoleId(Long roleId)throws Exception;

	List<RolePermission> selectRolePermissionListByRoleId(Long roleId)throws Exception;

}
