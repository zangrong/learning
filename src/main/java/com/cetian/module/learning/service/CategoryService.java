/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CategoryService.java 
 * @date 2018年3月21日 上午9:20:45 
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
import com.cetian.module.learning.dao.CategoryDao;
import com.cetian.module.learning.entity.Category;

/**
 * @ClassName:  CategoryService   
 * @Description: 
 * @date:  2018年3月21日 上午9:20:45
 * @author: zangrong
 * 
 */
@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * @Title: create   
	 * @Description: 创建一个分类
	 * @param category
	 * @return: ResponseMessage      
	 * @throws:
	 */
	public ResponseMessage create(Category category) {
		ResponseMessage responseMessage = new ResponseMessage();
		// TODO 可能会要对字段有效性进行校验
		
		category.setId(IdWorker.getInstance().getId());
		String datetime = DateUtil.now();
		category.setCreateTime(datetime);
		category.setUpdateTime(datetime);
		categoryDao.save(category);
		responseMessage.setDataCount(1);
		responseMessage.setData(category);
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
		List<Category> list = (List<Category>) categoryDao.findAll();
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
	 * @Description: 更新分类
	 * @param id
	 * @param name
	 * @param fullPath
	 * @return: ResponseMessage      
	 * @throws:
	 */
	public ResponseMessage update(String id, String name, String fullPath) {
		ResponseMessage responseMessage = new ResponseMessage();
		// TODO 可能需要字段有效性校验
		
		Optional<Category> optional = categoryDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		Category exist = optional.get();
		exist.setName(name);
		exist.setFullPath(fullPath);
		exist.setUpdateTime(DateUtil.now());
		categoryDao.save(exist);
		
		responseMessage.setDataCount(1);
		responseMessage.setData(exist);
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: delete   
	 * @Description: 删除分类
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage delete(String id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<Category> optional = categoryDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		// 删除对象
		Category exist = optional.get();
		categoryDao.delete(exist);
		
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

	/**
	 * @Title: get   
	 * @Description: 根据id获取分类
	 * @param id
	 * @return: ResponseMessage      
	 * @throws: 
	 */
	public ResponseMessage get(String id) {
		ResponseMessage responseMessage = new ResponseMessage();
		Optional<Category> optional = categoryDao.findById(id);
		// 不存在
		if (!optional.isPresent()) {
			responseMessage.setStateCode(ResponseMessage.STATE_CODE_NO_DATA);
			return responseMessage;
		}
		
		Category exist = optional.get();
		responseMessage.setDataCount(1);
		responseMessage.setData(exist);
		
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SUCCESS);
		return responseMessage;
	}

}
