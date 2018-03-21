/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: ResponseMessage.java 
 * @date 2018年3月21日 上午9:51:22 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName:  ResponseMessage   
 * @Description:TODO
 * @date:  2018年3月21日 上午9:51:22
 * @author: zangrong
 * 
 */
public class ResponseMessage {
	
	public static final int STATE_CODE_SUCCESS = 200;//成功
	public static final int STATE_CODE_NO_DATA = 1001;// 暂无数据 
	public static final int STATE_CODE_PARAMETER_INVALID = 1002;// 参数错误
	public static final int STATE_CODE_SERVICE_EXCEPTION = 500;// 服务异常
	public static final int STATE_CODE_UNAUTHORIZED = 401;// 无权限
	
	public static final String STATE_INFO_OK = "OK";
	
	@JsonProperty("StateInfo")
	private String stateInfo = "";
	@JsonProperty("StateCode")
	private int stateCode;
	@JsonProperty("DataCount")
	private int dataCount = 0;
	@JsonProperty("Data")
	private Object data;
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
		if (this.stateCode == STATE_CODE_SUCCESS) {
			this.stateInfo = STATE_INFO_OK;
		}
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
