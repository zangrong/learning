/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseRecordRecordService.java 
 * @date 2018年3月21日 下午1:13:04 
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

import com.cetian.base.entity.ResponseMessage;
import com.cetian.base.util.DateUtil;
import com.cetian.base.util.IdWorker;
import com.cetian.module.learning.dao.CourseRecordDao;
import com.cetian.module.learning.entity.CourseRecord;
import com.cetian.module.learning.entity.FinishedEnum;

/**
 * @ClassName:  CourseRecordRecordService   
 * @Description: 课程记录
 * @date:  2018年3月21日 下午1:13:04
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class CourseRecordService {
	
	@Autowired
	private CourseRecordDao courseRecordDao;
	
	/**
	 * @Title: create   
	 * @Description: 创建一个课程记录
	 * @param courseRecord
	 * @return: ResponseMessage      
	 * @throws:
	 */
	public ResponseMessage create(CourseRecord courseRecord) {
		ResponseMessage responseMessage = new ResponseMessage();
		// TODO 可能会要对字段有效性进行校验
		
		courseRecord.setId(IdWorker.getInstance().getId());
		String datetime = DateUtil.now();
		courseRecord.setCreateTime(datetime);
		courseRecord.setUpdateTime(datetime);
		courseRecordDao.save(courseRecord);
		responseMessage.setDataCount(1);
		responseMessage.setData(courseRecord);
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
		List<CourseRecord> list = (List<CourseRecord>) courseRecordDao.findAll();
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
	 * @Description: 更新课程记录
	 * @param id
	 * @param learnTime
	 * @param finished
	 * @return: ResponseMessage      
	 * @throws:
	 */
	public ResponseMessage update(String id, String learnTime, FinishedEnum finished) {
		ResponseMessage responseMessage = new ResponseMessage();
		// TODO 可能需要字段有效性校验
		
		Optional<CourseRecord> optional = courseRecordDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		CourseRecord exist = optional.get();
		exist.setLearnTime(learnTime);
		exist.setFinished(finished);
		exist.setUpdateTime(DateUtil.now());
		courseRecordDao.save(exist);
		
		responseMessage.setDataCount(1);
		responseMessage.setData(exist);
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: delete   
	 * @Description: 删除课程记录
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage delete(String id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<CourseRecord> optional = courseRecordDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		// 删除对象
		CourseRecord exist = optional.get();
		courseRecordDao.delete(exist);
		
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: get   
	 * @Description: 根据id获取课程记录
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage get(String id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<CourseRecord> optional = courseRecordDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		CourseRecord exist = optional.get();
		responseMessage.setDataCount(1);
		responseMessage.setData(exist);
		
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: listByUserId   
	 * @Description: 根据userId查询符合条件的学习记录列表
	 * @param userId
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage listByUserId(String userId) {
		ResponseMessage responseMessage = new ResponseMessage();
		List<CourseRecord> list = courseRecordDao.findByUserIdOrderByUpdateTimeAsc(userId);
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
}
