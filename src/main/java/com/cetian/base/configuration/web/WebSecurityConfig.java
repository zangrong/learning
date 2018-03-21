/**
 * @Copyright: 2018 cetian.com Inc. All rights reserved. 
 * @Title: WebSecurityConfig.java 
 * @date 2018年3月1日 下午1:15:59 
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.configuration.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: WebSecurityConfig
 * @Description:TODO
 * @date: 2018年3月1日 下午1:15:59
 * @author: zangrong
 * 
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().permitAll();
	}
	
}
