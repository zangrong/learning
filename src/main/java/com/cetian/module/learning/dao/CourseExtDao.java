/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseExtDao.java 
 * @date 2018年3月21日 上午11:42:48 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.learning.entity.CourseExt;

/**
 * @ClassName:  CourseExtDao   
 * @Description:TODO
 * @date:  2018年3月21日 上午11:42:48
 * @author: zangrong
 * 
 */
public interface CourseExtDao extends PagingAndSortingRepository<CourseExt, String>, JpaSpecificationExecutor<CourseExt> {

}
