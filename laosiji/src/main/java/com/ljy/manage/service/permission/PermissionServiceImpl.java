package com.ljy.manage.service.permission;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljy.entity.Dictionary;
import com.ljy.entity.Permission;
import com.ljy.entity.RolePermission;
import com.ljy.entity.ZtreeNode;
import com.ljy.entity.vo.TreeVo;
import com.ljy.manage.mapper.PermissionMapper;
import com.ljy.manage.mapper.ZtreeNodeMapper;
import com.ljy.manage.service.base.BaseServiceImpl;
import com.ljy.manage.service.systemlog.SystemServiceLog;

/**
 * 权限服务
 * @author sq
 *
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService{

	@Resource(name="permissionMapper")
	private PermissionMapper permissionMapper;
	
	@Resource(name="ztreeNodeMapper")
	private ZtreeNodeMapper ztreeNodeMapper;
	/**
	 * 根据用户Id查询所有的权限信息
	 */
	@Override
	@SystemServiceLog(description = "查询用户权限信息")
	public List<Permission> queryPermissionListByUserId(Long userId)
			throws Exception {
		List<Permission> list =this.permissionMapper.queryPermissionListByUserId(userId);
		return list;
	}
	
	/**
	 * 忽略非空字段保存资源信息
	 */
	@Override
	public void saveSelectiveColudPermissionType(Permission dictionary)
			throws Exception {
		//设置资源类型
		Example example = new Example(ZtreeNode.class);
		example.createCriteria().andEqualTo("id", dictionary.getTreeId());
		List<ZtreeNode> list = this.ztreeNodeMapper.selectByExample(example);
		if("菜单".equals(list.get(0).getName())){
			dictionary.setType("menu");
		}
		if("按钮".equals(list.get(0).getName())){
			dictionary.setType("button");
		}
		dictionary.setCreated(new Date());
		this.permissionMapper.insertSelective(dictionary);
	}

	/**
	 * 根据treeId分页查询资源list
	 */
	@Override
	@SystemServiceLog(description = "根据treeId分页查询资源list")
	public PageInfo<Permission> queryListByPageAndTreeId(Permission dictionary,
			Long treeNodeId, Integer pageNumber, Integer pageSize, String string)
			throws Exception {
		//1.查询选中的树节点实体
		ZtreeNode ztreeNode = this.ztreeNodeMapper.selectByPrimaryKey(treeNodeId);
		//2.如果此实体的pId == 0，说明为父节点
		if(ztreeNode.getpId() == 0){
			//3.根据id查询子树节点
			Example treeEx = new Example(ZtreeNode.class);
			treeEx.createCriteria().andEqualTo("pId", ztreeNode.getId());
			List<ZtreeNode> treeList = this.ztreeNodeMapper.selectByExample(treeEx);
			//4.将树节点的id封装为list
			List<Object> treeIdList = new ArrayList<Object>();
			for (ZtreeNode node : treeList) {
				treeIdList.add(node.getId());
			}
			PageHelper.startPage(pageNumber, pageSize);
			Example exDic = new Example(Dictionary.class);
			exDic.setOrderByClause(string);
			exDic.createCriteria().andIn("treeId", treeIdList);
			List<Permission> dictionaryList = this.permissionMapper.selectByExample(exDic);
			//5.设置分页
			return new PageInfo<Permission>(dictionaryList);
		}else{
			PageHelper.startPage(pageNumber, pageSize);
			//1.根据treeId分页查询
			Example example = new Example(Permission.class);
			example.setOrderByClause(string);
			example.createCriteria().andEqualTo("treeId", treeNodeId);
			List<Permission> listPer = this.permissionMapper.selectByExample(example);
			//5.设置分页
			return new PageInfo<Permission>(listPer);
		}
		
	}

	@Override
	@SystemServiceLog(description = "查询资源授权树")
	public List<TreeVo> selectPermisssionTree() throws Exception {
		List<TreeVo> list = new ArrayList<TreeVo>();
		//根据ztree——node的树类型查询树的所有节点
		Example treeEx = new Example(ZtreeNode.class);
		treeEx.createCriteria().andEqualTo("type", 2);
		List<ZtreeNode> ztreeNodes = this.ztreeNodeMapper.selectByExample(treeEx);
		for (ZtreeNode ztreeNode : ztreeNodes) {
			TreeVo treeVo = new TreeVo();
			treeVo.setId(ztreeNode.getId());
			treeVo.setName(ztreeNode.getName());
			treeVo.setOpen(0);
			treeVo.setpId(ztreeNode.getpId());
			treeVo.setParent(true);
			list.add(treeVo);
		}
		
		//设置资源到树中
		List<Permission> permissionList = super.queryAll();
		for (Permission permission : permissionList) {
			TreeVo treeVo = new TreeVo();
			treeVo.setPermissionId(permission.getId());
			treeVo.setName(permission.getName());
			treeVo.setOpen(0);
			treeVo.setpId(permission.getTreeId());
			treeVo.setParent(false);
			list.add(treeVo);
		}
		return list;
	}

	@Override
	@SystemServiceLog(description = "角色授权")
	public void saveRoleAuthenrization(Long roleId, String permission)
			throws Exception {
		
		//先删除已存在的权限信息
		this.permissionMapper.deleteRolePermissionByRoleId(roleId);
		
		//删除后重新添加
		String[] permissions = permission.split(",");
		for (String per : permissions) {
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(Long.parseLong(per));
			this.permissionMapper.savePermissionAuthenrization(rolePermission);
		}
	}

	@Override
	@SystemServiceLog(description = "角色授权回显")
	public List<RolePermission> selectRolePermissionListByRoleId(Long roleId)
			throws Exception {
		List<RolePermission> list = this.permissionMapper.selectRolePermissionListByRoleId(roleId);
		return list;
	}

}
