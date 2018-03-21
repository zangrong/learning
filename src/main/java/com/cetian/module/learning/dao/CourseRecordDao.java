/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: CourseRecordDao.java 
 * @date 2018年3月21日 下午1:20:40 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cetian.module.learning.entity.CourseRecord;

/**
 * @ClassName:  CourseRecordDao   
 * @Description:TODO
 * @date:  2018年3月21日 下午1:20:40
 * @author: zangrong
 * 
 */
public interface CourseRecordDao extends PagingAndSortingRepository<CourseRecord, String>, JpaSpecificationExecutor<CourseRecord> {

	List<CourseRecord> findByUserIdOrderByUpdateTimeAsc(String userId);

}
