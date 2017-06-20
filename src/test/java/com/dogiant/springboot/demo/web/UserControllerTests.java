package com.dogiant.springboot.demo.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class) 
@MockBean(classes = MockServletContext.class) 
@WebAppConfiguration 
public class UserControllerTests { 
 
	private MockMvc mockMvc; 
 
	@Before 
	public void setUp() throws Exception { 
		mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build(); 
	} 
 
	@Test 
	public void testUserController() throws Exception { 
        // 测试UserController 
		RequestBuilder request = null; 
 
		// 1、get查一下user列表，应该为空 
		request = get("/users/"); 
		mockMvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]"))); 
 
		// 2、post提交一个user 
		request = post("/users/") 
				.param("id", "1") 
				.param("username", "tmd") 
				.param("nickname", "测试大师") 
				.param("realname", "李永泉"); 
		mockMvc.perform(request) 
		        .andExpect(content().string(equalTo("success"))); 
 
		// 3、get获取user列表，应该有刚才插入的数据 
		request = get("/users/"); 
		mockMvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"realname\":\"李永泉\"}]"))); 
 
		// 4、put修改id为1的user 
		request = put("/users/1") 
				.param("nickname", "测试终极大师") 
				.param("age", "30"); 
		mockMvc.perform(request) 
				.andExpect(content().string(equalTo("success"))); 
 
		// 5、get一个id为1的user 
		request = get("/users/1"); 
		mockMvc.perform(request) 
				.andExpect(content().string(equalTo("{\"id\":1,\"nickname\":\"测试终极大师\",\"realname\":\"李永泉\"}"))); 
 
		// 6、del删除id为1的user 
		request = delete("/users/1"); 
		mockMvc.perform(request) 
				.andExpect(content().string(equalTo("success"))); 
 
		// 7、get查一下user列表，应该为空 
		request = get("/users/"); 
		mockMvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]"))); 
 
	} 
	
	@Test
	public void testByRequestResult() throws Exception{
		String json = "{\"id\":1,\"name\":\"测试大师\",\"realname\":\"李永泉\"}";
		MvcResult result = (MvcResult) mockMvc.perform(post("/users/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json)
		//.param("epsToken", "token")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()) 
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		System.out.println("----------"+result.getResponse().getStatus());
		System.out.println("----------"+result.getResponse().getContentAsString());
		Assert.assertEquals(200, result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse().getContentAsString());

	}
 
}
