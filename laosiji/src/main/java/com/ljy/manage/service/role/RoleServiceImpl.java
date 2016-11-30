package com.ljy.manage.service.role;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.ljy.common.bootstarp.PaginatorBootStarp;
import com.ljy.entity.Role;
import com.ljy.entity.User;
import com.ljy.entity.vo.TreeVo;
import com.ljy.manage.mapper.RoleMapper;
import com.ljy.manage.mapper.UserMapper;
import com.ljy.manage.service.base.BaseServiceImpl;
import com.ljy.manage.service.systemlog.SystemServiceLog;

/**
 * 角色SERVICE
 * @author LSQ
 * by QQ237442461 2016-10-6
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Resource(name = "roleMapper")
	private RoleMapper roleMapper;
	
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	

	@Override
	@SystemServiceLog(description = "分页查询角色列表")
	public List<Role> queryListByPage(PaginatorBootStarp paginatorBootStarp) {
		return this.roleMapper.queryListByPage(paginatorBootStarp);
	}

	@Override
	@SystemServiceLog(description = "分页查询角色count")
	public Integer queryListByPageCount() throws Exception {
		return this.roleMapper.queryListByPageCount();
	}

	@Override
	@SystemServiceLog(description = "删除角色")
	public void deleteByIdsVo(String ids) throws Exception {
		String[] idsArr = ids.split("\\|");
		List<Object> list = new ArrayList<Object>();
		for (String id : idsArr) {
			list.add(id);
		}
		super.deleteByIds(list);
		
		//删除角色的同时需要删除，user_role表中的roleId = 删除的roleId
		//删除角色的同时需要删除，role_permission表中的roleId = 删除的roleId
		for (Object object : list) {
			this.roleMapper.deleteUserRoleByRoleId(Long.parseLong(object.toString()));
			this.roleMapper.deleteRolePermissionByRoleId(Long.parseLong(object.toString()));
		}
	}

	@Override
	@SystemServiceLog(description = "根据条件分页查询角色列表")
	public List<Role> queryListByPageLikeStr(Integer pageNumber,
			Integer pageSize, String queryString) throws Exception {
		PaginatorBootStarp paginatorBootStarp = new PaginatorBootStarp(pageNumber, pageSize, "updated", "asc");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", queryString);
		paginatorBootStarp.setCondition(map);
		return this.roleMapper.queryListByPageLikeStr(paginatorBootStarp);
	}

	@Override
	@SystemServiceLog(description = "添加角色")
	public void saveRole(Role role) throws Exception {
		role.setCreated(new Date());
		role.setUpdated(role.getCreated());
		super.save(role);
	}

	@Override
	@SystemServiceLog(description = "获取角色树")
	public List<TreeVo> selectRoleTree(Long userId) throws Exception {
		List<TreeVo> list = new ArrayList<TreeVo>();
		User user = this.userMapper.selectByPrimaryKey(userId);
		if(String.valueOf(user.getTreeId()).startsWith("1")){
			//1.创建初始化的分类根节点
			TreeVo roleTree = new TreeVo(Long.parseLong("1"), Long.parseLong("0"), "客户端", true, 1);
			list.add(roleTree);
			Example example1 = new Example(Role.class);
			example1.createCriteria().andEqualTo("treeId", 1);
			List<Role> list101 = this.roleMapper.selectByExample(example1);
			for (Role role : list101) {
				TreeVo roleTree2 = new TreeVo(null, Long.parseLong("1"), role.getName(), false, 0);
				roleTree2.setRoleId(role.getId());
				list.add(roleTree2);
			}
			return list;
		}
		
		if(String.valueOf(user.getTreeId()).startsWith("2")){
			//1.创建初始化的分类根节点服务端
			TreeVo roleTreeServer = new TreeVo(Long.parseLong("2"), Long.parseLong("0"), "服务端", true, 1);
			list.add(roleTreeServer);
			Example example3 = new Example(Role.class);
			example3.createCriteria().andEqualTo("treeId", 2);
			List<Role> list201 = this.roleMapper.selectByExample(example3);
			for (Role role : list201) {
				TreeVo roleTree2 = new TreeVo(null, Long.parseLong("2"), role.getName(), false, 0);
				roleTree2.setRoleId(role.getId());
				list.add(roleTree2);
			}
			return list;
		}
		return list;
	}

	@Override
	@SystemServiceLog(description = "用户分配角色")
	public List<Role> queryRoleListByUserId(Long userId) throws Exception {
		
		return this.roleMapper.queryRoleListByUserId(userId);
	}
}
