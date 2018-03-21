/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: FinishedEnum.java 
 * @date 2018年3月21日 上午11:47:39 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.learning.entity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName:  FinishedEnum   
 * @Description:TODO
 * @date:  2018年3月21日 上午11:47:39
 * @author: zangrong
 * 
 */
public enum FinishedEnum {
	no("0"), // 非精选
	yes("1");// 精选

	private String value;

	private FinishedEnum(String value) { // 必须是private的，否则编译错误
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
