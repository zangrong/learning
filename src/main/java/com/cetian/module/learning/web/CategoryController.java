/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CategoryController.java 
 * @date 2018年3月21日 上午9:20:57 
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
import com.cetian.module.learning.entity.Category;
import com.cetian.module.learning.service.CategoryService;

/**
 * @ClassName:  CategoryController   
 * @Description: 学习中心 分类
 * @date:  2018年3月21日 上午9:20:57
 * @author: zangrong
 * 
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * @Title: create   
	 * @Description: 创建分类
	 * @param category
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/create")
	public ResponseMessage create(Category category) {
		ResponseMessage responseMessage = this.categoryService.create(category);
		return responseMessage;
	}
	
	/**
	 * @Title: update   
	 * @Description: 更新分类
	 * @param id
	 * @param name 分类名
	 * @param fullPath 路径
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/update")
	public ResponseMessage update(String id, String name, String fullPath) {
		ResponseMessage responseMessage = this.categoryService.update(id, name, fullPath);
		return responseMessage;
	}
	
	/**
	 * @Title: delete   
	 * @Description: 根据id删除分类
	 * @param id
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@PostMapping("/delete")
	public ResponseMessage delete(String id) {
		ResponseMessage responseMessage = this.categoryService.delete(id);
		return responseMessage;
	}
	
	/**
	 * @Title: get   
	 * @Description: 根据id获取分类
	 * @param id
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@GetMapping("/get")
	public ResponseMessage get(String id){
		ResponseMessage responseMessage = categoryService.get(id);
		return responseMessage;
	}
	
	/**
	 * @Title: list   
	 * @Description: 获取所有分类列表
	 * @return: ResponseMessage      
	 * @throws:
	 */
	@GetMapping("/list")
	public ResponseMessage list(){
		ResponseMessage responseMessage = categoryService.list();
		return responseMessage;
	}
}
