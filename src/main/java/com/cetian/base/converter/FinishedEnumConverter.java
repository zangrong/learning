/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: FinishedEnumConverter.java 
 * @date 2018年3月21日 下午1:37:36 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cetian.module.learning.entity.FinishedEnum;

/**
 * @ClassName:  FinishedEnumConverter   
 * @Description: FinishedEnum转换器
 * @date:  2018年3月21日 下午1:37:36
 * @author: zangrong
 * 
 */
@Component
public class FinishedEnumConverter implements Converter<String, FinishedEnum> {

	private static final Logger log = LoggerFactory.getLogger(FinishedEnumConverter.class);

	@Override
	public FinishedEnum convert(String source) {
		FinishedEnum ae = null;
		switch (source) {
		case "0":
			ae = FinishedEnum.no;
			break;
		case "1":
			ae = FinishedEnum.yes;
			break;
		default:
			log.warn("FinishedEnum 转换不正确 source [{}]", source);
			break;
		}
		return ae;
	}

}
