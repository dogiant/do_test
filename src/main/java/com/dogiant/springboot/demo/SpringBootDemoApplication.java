package com.dogiant.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dogiant.springboot.demo.domain.BlogPropeties;

@SpringBootApplication
@ConfigurationProperties(prefix="application")
@EnableConfigurationProperties({BlogPropeties.class})  
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
