/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Category.java 
 * @date 2018年3月21日 上午9:20:25 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName:  Category   
 * @Description: 学习中心 分类
 * @date:  2018年3月21日 上午9:20:25
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "learning_centre_category")
public class Category {
	
	private String id;
	private String name;
	private String parentId;
	private String parentName;
	private String fullPath;
	private String createTime;
	private String updateTime;
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="cat_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="cat_parent_id")
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Column(name="cat_parent_name")
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	@Column(name="cat_full_path")
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
