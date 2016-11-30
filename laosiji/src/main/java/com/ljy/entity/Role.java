package com.ljy.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ljy.entity.base.BaseEntity;

/**
 * 角色
 * 
 * @author sq by qq237442461 2016-8-20
 */
@Table(name = "t_role")
public class Role extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 是否可用，1：可用，2：不可用
	 */
	private Integer available;
	
	/**
	 * 角色所属部门的id
	 */
	private Long treeId;
	
	/**
	 * 角色标识
	 */
	private String percode;

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
	
	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Long getTreeId() {
		return treeId;
	}

	public void setTreeId(Long treeId) {
		this.treeId = treeId;
	}

	@Override
	public String toString() {
		return "Role [available=" + available + ", id=" + id + ", name=" + name
				+ "]";
	}

}
