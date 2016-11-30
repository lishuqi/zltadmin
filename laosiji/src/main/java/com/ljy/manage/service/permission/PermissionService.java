package com.ljy.manage.service.permission;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ljy.entity.Permission;
import com.ljy.entity.RolePermission;
import com.ljy.entity.vo.TreeVo;
import com.ljy.manage.service.base.BaseService;

public interface PermissionService extends BaseService<Permission>{

	List<Permission> queryPermissionListByUserId(Long userId)throws Exception;

	void saveSelectiveColudPermissionType(Permission dictionary)throws Exception;

	PageInfo<Permission> queryListByPageAndTreeId(Permission dictionary,
			Long treeNodeId, Integer pageNumber, Integer pageSize, String string)throws Exception;

	List<TreeVo> selectPermisssionTree() throws Exception;

	void saveRoleAuthenrization(Long roleId, String permissionId)throws Exception;

	List<RolePermission> selectRolePermissionListByRoleId(Long roleId) throws Exception;

}
