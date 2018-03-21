/**
 * @Copyright: 2017 cetian.com Inc. All rights reserved. 
 * @Title: GlobalExceptionHandler.java 
 * @date 2017年2月28日 下午5:53:08 
 * @version V1.0
 * @author liliying
 */
package com.cetian.base.exception.handler;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
/**
 * @ClassName:  GlobalExceptionHandler   
 * @Description:全局异常捕获
 * @date:  2017年2月28日 下午5:53:08
 * @author: liliying
 * 
 */
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cetian.base.entity.ResponseMessage;


/**
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理
 * @date: 2017年6月23日 上午9:12:10
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler // 处理所有异常
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public ResponseMessage exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
		log.warn("ResponseMessage (系统异常): message[{}], Exception[{}], URI[{}]", e.getMessage(), e.getClass(),
				request.getRequestURI());
		try {
			Map<String, String[]> parameterMap = request.getParameterMap();
			for (Entry<String, String[]> entry : parameterMap.entrySet()) {
				log.warn("key[{}],value[{}]", entry.getKey(), StringUtils.join(entry.getValue(), ","));
			}
		} catch (Exception e2) {
			log.error("Log request parameter: ", e2);
		}

		log.error("", e);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStateCode(ResponseMessage.STATE_CODE_SERVICE_EXCEPTION);
		return responseMessage;
	}


}