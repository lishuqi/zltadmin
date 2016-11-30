package com.ljy.manage.auth.relam;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ljy.entity.Permission;
import com.ljy.entity.Role;
import com.ljy.entity.User;
import com.ljy.manage.service.permission.PermissionService;
import com.ljy.manage.service.role.RoleService;
import com.ljy.manage.service.user.UserService;

/**
 * 自定义shiro Relam
 * 
 * @author LSQ
 * by QQ237442461 2016-10-7
 */
public class CustomRelam extends AuthorizingRealm{
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name = "roleService")
	private RoleService roleService;
	
	@Resource(name="permissionService")
	private PermissionService permissionService;
	@Override
	public String getName() {
		return "customRealm";
	}

	// 支持什么类型的token,选择 UsernamePasswordToken
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
			//从token中获取用户的身份信息
			String username = (String) token.getPrincipal();
			User user = null;
			try {
				user = this.userService.queryByUserName(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(user == null){
				return null;
			}
			return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取认证过后的用户信息
		User user = (User) principals.getPrimaryPrincipal();
		Long userId = user.getId();
		
		List<Permission> permissions = null;
		List<Role> roles = null;
		
		try {
			//资源权限
			permissions = this.permissionService.queryPermissionListByUserId(userId);
			//角色
			roles = this.roleService.queryRoleListByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//构建shiro授权信息
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (Permission permission : permissions) {
			simpleAuthorizationInfo.addStringPermission(permission.getPercode());
		}
		for (Role role : roles) {
			simpleAuthorizationInfo.addRole(role.getPercode());
		}	
		return simpleAuthorizationInfo;
	}
	//清空缓冲
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
