package com.ljy.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.ljy.entity.User;
import com.ljy.entity.UserRole;

public interface UserMapper extends Mapper<User>{

	void saveUserAuthenrization(UserRole userRole)throws Exception;

	void deleteUserRoleByUserId(Long userId)throws Exception;

	List<UserRole> selectUserRoleListByUserId(Long userId)throws Exception;

}
