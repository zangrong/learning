/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseExt.java 
 * @date 2018年3月21日 上午11:40:15 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName:  CourseExt   
 * @Description:TODO
 * @date:  2018年3月21日 上午11:40:15
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "learning_centre_course_ext")
public class CourseExt {
	private String id;
	private String content;
	private String ext;
	private String createTime;
	private String updateTime;
	@Id
	@Column(name="course_id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="course_content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="course_ext")
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
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
