/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseRecordController.java 
 * @date 2018年3月21日 下午1:13:26 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.learning.entity.CourseRecord;
import com.cetian.module.learning.entity.FinishedEnum;
import com.cetian.module.learning.service.CourseRecordService;

/**
 * @ClassName:  CourseRecordController   
 * @Description: 学习中心 课程记录
 * @date:  2018年3月21日 下午1:13:26
 * @author: zangrong
 * 
 */
@RestController
@RequestMapping("/course/record")
public class CourseRecordController {
	
	@Autowired
	private CourseRecordService courseRecordService;
	
	/**
	 * @Title: create   
	 * @Description: 创建学习记录
	 * @param record
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/create")
	public ResponseMessage create(CourseRecord record) {
		ResponseMessage responseMessage = this.courseRecordService.create(record);
		return responseMessage;
	}
	
	/**
	 * @Title: update   
	 * @Description: 更新学习记录
	 * @param id 
	 * @param learnTime 已经学习多少分钟
	 * @param finished 是否已学完 0未完 1学完
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/update")
	public ResponseMessage update(String id, String learnTime, FinishedEnum finished) {
		ResponseMessage responseMessage = this.courseRecordService.update(id, learnTime, finished);
		return responseMessage;
	}
	
	
	@PostMapping("/delete")
	public ResponseMessage delete(String id) {
		ResponseMessage responseMessage = this.courseRecordService.delete(id);
		return responseMessage;
	}
	
	/**
	 * @Title: get   
	 * @Description: 学习记录
	 * @param id
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@GetMapping("/get")
	public ResponseMessage get(String id){
		ResponseMessage responseMessage = courseRecordService.get(id);
		return responseMessage;
	}
	
	@GetMapping("/list/by/userid")
	public ResponseMessage listByUserId(String userId){
		ResponseMessage responseMessage = courseRecordService.listByUserId(userId);
		return responseMessage;
	}
}
