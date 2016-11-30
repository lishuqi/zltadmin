package com.ljy.manage.service.user;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ljy.entity.User;
import com.ljy.entity.UserRole;
import com.ljy.manage.service.base.BaseService;

public interface UserService extends BaseService<User>{

	User queryByUserName(String username)throws Exception;

	void deleteByIdsVo(String ids)throws Exception;

	void saveuser(User user) throws Exception;

	PageInfo<User> queryListByPageAndTreeId(Object object, Long treeNodeId,
			Integer pageNumber, Integer pageSize, String string) throws Exception;

	void saveUserAuthenrization(Long userId, String roleId)throws Exception;

	List<UserRole> selectUserRoleListByUserId(Long userId)throws Exception;

}
