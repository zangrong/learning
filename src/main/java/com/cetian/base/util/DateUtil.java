/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: DateUtil.java 
 * @date 2018年3月21日 上午10:32:36 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @ClassName:  DateUtil   
 * @Description:TODO
 * @date:  2018年3月21日 上午10:32:36
 * @author: zangrong
 * 
 */
public class DateUtil {

	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static String now() {
        Calendar date = Calendar.getInstance();
        String dateText = DateFormatUtils.format(date, DATETIME_FORMAT);
        return dateText;
    }
}
