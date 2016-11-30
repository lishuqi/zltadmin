package com.ljy.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ljy.entity.base.BaseEntity;

/**
 * 用户
 * 
 * @author sq by QQ237442461 2016-8-20
 */
@Table(name = "t_user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 用户名
	 */
	private String userCode;

	/**
	 * 姓名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 身份证号码
	 */
	private String idCard;
	
	/**
	 * 电子邮箱
	 */
	private String email;
	
	/**
	 * 电话号码
	 */
	private String phone;
	
	/**
	 * 树节点id
	 */
	private Long treeId;
	
	/**
	 * 登陆的ip地址
	 */
	private String ip;
	
	/**
	 * 上一次登陆时间
	 */
	private Date lastLoginDate;
	
	/**
	 * 本次登录时间
	 */
	private Date nowLoginDate;
	
	/**
	 * 是否锁定，1：锁定，0:未锁定
	 */
	private Integer locked;

	/**
	 * 修改时间
	 */
	private Date updated;

	/**
	 * 创建时间
	 */
	private Date created;

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	


	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getNowLoginDate() {
		return nowLoginDate;
	}

	public void setNowLoginDate(Date nowLoginDate) {
		this.nowLoginDate = nowLoginDate;
	}

	public Long getTreeId() {
		return treeId;
	}

	public void setTreeId(Long treeId) {
		this.treeId = treeId;
	}
}
