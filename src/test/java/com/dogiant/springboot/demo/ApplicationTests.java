package com.dogiant.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dogiant.springboot.demo.domain.BlogPropeties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private BlogPropeties blogPropeties;
	
	@Test
	public void blog(){
		System.out.println(blogPropeties.getName());
	}
}
