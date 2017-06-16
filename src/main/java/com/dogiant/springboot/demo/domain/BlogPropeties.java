package com.dogiant.springboot.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "com.dogiant.blog")
@PropertySource("classpath:config/blog.properties")
public class BlogPropeties {

	// @Value("${com.dogiant.blog.name}")
	private String name;

	// @Value("${com.dogiant.blog.desc}")
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
