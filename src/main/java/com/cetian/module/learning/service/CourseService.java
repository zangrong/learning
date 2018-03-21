/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseService.java 
 * @date 2018年3月21日 上午11:38:34 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetian.base.entity.IdWorker;
import com.cetian.base.entity.ResponseMessage;
import com.cetian.base.util.DateUtil;
import com.cetian.module.learning.dao.CourseDao;
import com.cetian.module.learning.dao.CourseExtDao;
import com.cetian.module.learning.entity.Course;

/**
 * @ClassName:  CourseService   
 * @Description:TODO
 * @date:  2018年3月21日 上午11:38:34
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private CourseExtDao courseExtDao;
	
	/**
	 * @Title: create   
	 * @Description: 创建一个课程
	 * @param course
	 * @return: ResponseMessage      
	 * @throws:
	 */
	public ResponseMessage create(Course course) {
		ResponseMessage responseMessage = new ResponseMessage();
		// TODO 可能会要对字段有效性进行校验
		
		course.setId(IdWorker.getInstance().getId());
		String datetime = DateUtil.now();
		course.setCreateTime(datetime);
		course.setUpdateTime(datetime);
		courseDao.save(course);
		responseMessage.setDataCount(1);
		responseMessage.setData(course);
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: list   
	 * @Description: 列表
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage list() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Course> list = (List<Course>) courseDao.findAll();
		// 如果集合为空
		if (CollectionUtils.isEmpty(list)) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		responseMessage.setDataCount(list.size());
		responseMessage.setData(list);
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: update   
	 * @Description: 更新课程
	 * @param id
	 * @param name
	 * @param fullPath
	 * @return: ResponseMessage      
	 * @throws:
	 */
	public ResponseMessage update(Course course) {
		ResponseMessage responseMessage = new ResponseMessage();
		// TODO 可能需要字段有效性校验
		
		Optional<Course> optional = courseDao.findById(course.getId());
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		Course exist = optional.get();
		exist.setTitle(course.getTitle());
		exist.setCredit(course.getCredit());
		exist.setHour(course.getHour());
		exist.setIntro(course.getIntro());
		exist.setUrl(course.getUrl());
		exist.setUpdateTime(DateUtil.now());
		courseDao.save(exist);
		
		responseMessage.setDataCount(1);
		responseMessage.setData(exist);
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: delete   
	 * @Description: 删除课程
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage delete(String id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<Course> optional = courseDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		// 删除对象
		Course exist = optional.get();
		courseDao.delete(exist);
		
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: get   
	 * @Description: 根据id获取课程
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage get(String id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<Course> optional = courseDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		Course exist = optional.get();
		responseMessage.setDataCount(1);
		responseMessage.setData(exist);
		
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}
	
}
