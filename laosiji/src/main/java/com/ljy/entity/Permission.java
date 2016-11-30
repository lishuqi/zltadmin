package com.ljy.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ljy.entity.base.BaseEntity;

/**
 * 资源
 * @author sq
 * by qq237442461 2016-8-20
 */
@Table(name="t_permission")
public class Permission extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 资源名称
	 */
	private String name;
	
	/**
	 * 资源类型包括：菜单，按钮，menu button
	 */
	private String type;
	
	/**
	 * 访问url的地址
	 */
	private String url;
	
	/**
	 * 权限代码字符串
	 */
	private String percode;
	
	/**
	 * 父节点id
	 */
	private Long parentId;
	
	/**
	 * 父节点字符串
	 */
	private String parentIds;
	
	/**
	 * 树节点id
	 */
	private Long treeId;
	
	/**
	 * 排序号
	 */
	private Integer sort;
	
	/**
	 * 资源是否可用 1：可用 0：不可用
	 */
	private Integer available;
	
	/**
	 * 创建时间
	 */
	private Date created;
	
	public Long getTreeId() {
		return treeId;
	}

	public void setTreeId(Long treeId) {
		this.treeId = treeId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Permission [available=" + available + ", id=" + id + ", name="
				+ name + ", parentId=" + parentId + ", parentIds=" + parentIds
				+ ", percode=" + percode + ", sort=" + sort + ", type=" + type
				+ ", url=" + url + "]";
	}
}
