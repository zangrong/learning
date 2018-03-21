/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CategoryDao.java 
 * @date 2018年3月21日 上午9:20:13 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.learning.entity.Category;

/**
 * @ClassName:  CategoryDao   
 * @Description:TODO
 * @date:  2018年3月21日 上午9:20:13
 * @author: zangrong
 * 
 */
public interface CategoryDao extends PagingAndSortingRepository<Category, String>, JpaSpecificationExecutor<Category> {

}
