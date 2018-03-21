/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseRecord.java 
 * @date 2018年3月21日 上午11:44:35 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName:  CourseRecord   
 * @Description: 学习中心 课程记录
 * @date:  2018年3月21日 上午11:44:35
 * @author: zangrong
 * 
 */
@Entity
@Table(name = "learning_centre_course_record")
public class CourseRecord {
	
	private String id;
	private String userId;
	private String appOrgCode;
	private String orgId;
	private String courseId;
	private String startTime;
	private String endTime;
	private String learnTime;
	
	private FinishedEnum finished;
	private String createTime;
	private String updateTime;
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLearnTime() {
		return learnTime;
	}
	public void setLearnTime(String learnTime) {
		this.learnTime = learnTime;
	}
	@Enumerated
	@Column(name="is_finished")
	public FinishedEnum getFinished() {
		return finished;
	}
	public void setFinished(FinishedEnum finished) {
		this.finished = finished;
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
