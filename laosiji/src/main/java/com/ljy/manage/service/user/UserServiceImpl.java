package com.ljy.manage.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljy.entity.User;
import com.ljy.entity.UserRole;
import com.ljy.manage.mapper.UserMapper;
import com.ljy.manage.service.base.BaseServiceImpl;
import com.ljy.manage.service.systemlog.SystemServiceLog;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Override
	public User queryByUserName(String username) throws Exception {
		User user = new User();
		user.setUserCode(username);
		return super.queryOne(user);
	}

	@Override
	@SystemServiceLog(description = "删除用戶")
	public void deleteByIdsVo(String ids) throws Exception {
		String[] idsArr = ids.split("\\|");
		List<Object> list = new ArrayList<Object>();
		for (String id : idsArr) {
			list.add(id);
		}
		super.deleteByIds(list);
		//删除角色信息
		for (Object object : list) {
			this.userMapper.deleteUserRoleByUserId(Long.parseLong(object.toString()));
		}
	}

	@Override
	@SystemServiceLog(description = "添加用戶")
	public void saveuser(User user) throws Exception {
		user.setCreated(new Date());
		user.setUpdated(user.getCreated());
		super.save(user);
	}

	@Override
	@SystemServiceLog(description = "分页查询用户")
	public PageInfo<User> queryListByPageAndTreeId(Object object,
			Long treeNodeId, Integer pageNumber, Integer pageSize, String string)
			throws Exception {
		//treeNodeId == 1说明为客户端用户
		if(treeNodeId == 1){
			//101，102
			PageHelper.startPage(pageNumber, pageSize);
			List<Object> listNodeId = new ArrayList<Object>();
			listNodeId.add(101);
			listNodeId.add(102);
			Example example = new Example(User.class);
			example.createCriteria().andIn("treeId", listNodeId);
			List<User> users = this.userMapper.selectByExample(example);
			return new PageInfo<User>(users);
		}
		//treeNodeId == 1说明为服务端用户
		if(treeNodeId == 2){
			//101，102
			PageHelper.startPage(pageNumber, pageSize);
			List<Object> listNodeId = new ArrayList<Object>();
			listNodeId.add(201);
			listNodeId.add(202);
			Example example = new Example(User.class);
			example.createCriteria().andIn("treeId", listNodeId);
			List<User> users = this.userMapper.selectByExample(example);
			return new PageInfo<User>(users);
		}
		
		return null;
	}

	@Override
	@SystemServiceLog(description = "用户授权")
	public void saveUserAuthenrization(Long userId, String roleId)
			throws Exception {
		
		//先删除已存在的角色信息
		this.userMapper.deleteUserRoleByUserId(userId);
		
		//删除后重新添加
		String[] roles = roleId.split(",");
		for (String role : roles) {
			UserRole userRole = new UserRole();
			userRole.setRoleId(Long.parseLong(role));
			userRole.setUserId(userId);
			this.userMapper.saveUserAuthenrization(userRole);
		}
	}

	@Override
	@SystemServiceLog(description = "用户授权信息回显")
	public List<UserRole> selectUserRoleListByUserId(Long userId)
			throws Exception {
		List<UserRole> list = this.userMapper.selectUserRoleListByUserId(userId);
		return list;
	}
}
