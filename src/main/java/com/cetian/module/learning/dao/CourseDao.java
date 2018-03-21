/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseDao.java 
 * @date 2018年3月21日 上午11:37:52 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.learning.entity.Course;

/**
 * @ClassName:  CourseDao   
 * @Description:TODO
 * @date:  2018年3月21日 上午11:37:52
 * @author: zangrong
 * 
 */
public interface CourseDao extends PagingAndSortingRepository<Course, String>, JpaSpecificationExecutor<Course> {

}
