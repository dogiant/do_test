package com.dogiant.springboot.demo.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dogiant.springboot.demo.config.BlogPropeties;

@RestController
public class HelloController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private BlogPropeties blogPropeties;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello spring boot.";
	}
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog() {
		return "hello " + blogPropeties.getName() +","+blogPropeties.getDesc();
	}
	

}
