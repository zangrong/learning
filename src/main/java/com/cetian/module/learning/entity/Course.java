/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: Course.java 
 * @date 2018年3月21日 上午11:32:14 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName:  Course   
 * @Description: 学习中心 课程
 * @date:  2018年3月21日 上午11:32:14
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "learning_centre_course")
public class Course {
	private String id;
	private String catId;
	private String appOrgCode;
	private String orgId;
	private String title;
	private String intro;
	private int hour;
	private int credit;
	private String url;
	private int clicksCount;
	private String postTime;
	private String createTime;
	private String updateTime;
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getAppOrgCode() {
		return appOrgCode;
	}
	public void setAppOrgCode(String appOrgCode) {
		this.appOrgCode = appOrgCode;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Column(name="course_title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="course_intro")
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Column(name="course_hour")
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	@Column(name="course_credit")
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Column(name="course_url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getClicksCount() {
		return clicksCount;
	}
	public void setClicksCount(int clicksCount) {
		this.clicksCount = clicksCount;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
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
