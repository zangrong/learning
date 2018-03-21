/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: TestController.java 
 * @date 2018年3月21日 下午1:41:10 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.module.test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:  TestController   
 * @Description:TODO
 * @date:  2018年3月21日 下午1:41:10
 * @author: zangrong
 * 
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("")
	public String test() {
		return "test";
	}
}
