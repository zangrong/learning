/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseController.java 
 * @date 2018年3月21日 上午11:38:57 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetian.base.entity.ResponseMessage;
import com.cetian.module.learning.entity.Course;
import com.cetian.module.learning.service.CourseService;

/**
 * @ClassName:  CourseController   
 * @Description: 学习中心 课程
 * @date:  2018年3月21日 上午11:38:57
 * @author: zangrong
 * 
 */
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * @Title: create   
	 * @Description: 创建课程
	 * @param course
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/create")
	public ResponseMessage create(Course course) {
		ResponseMessage responseMessage = this.courseService.create(course);
		return responseMessage;
	}
	
	/**
	 * @Title: update   
	 * @Description: 更新课程
	 * @param course
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/update")
	public ResponseMessage update(Course course) {
		ResponseMessage responseMessage = this.courseService.update(course);
		return responseMessage;
	}
	
	/**
	 * @Title: delete   
	 * @Description: 删除一门课程
	 * @param id
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/delete")
	public ResponseMessage delete(@RequestParam String id) {
		ResponseMessage responseMessage = this.courseService.delete(id);
		return responseMessage;
	}
	
	/**
	 * @Title: get   
	 * @Description: 根据 id 获取课程
	 * @param id
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@GetMapping("/get")
	public ResponseMessage get(@RequestParam String id){
		ResponseMessage responseMessage = courseService.get(id);
		return responseMessage;
	}
	
	/**
	 * @Title: list   
	 * @Description: 分页获取课程列表
	 * @param pageNo 页码 从1开始 默认1
	 * @param pageSize 每页记录数 默认10
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@GetMapping("/list")
	public ResponseMessage list(@RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10") int pageSize){
		ResponseMessage responseMessage = courseService.list(pageNo, pageSize);
		return responseMessage;
	}

}
