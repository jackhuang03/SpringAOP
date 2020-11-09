package com.jack.exercise.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class LogControllerAspectTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
	
	private MockMvc mvc;
	
	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testLogRequestForListBookByIdResourceFetched() throws Exception {
		String uri = "/books/1";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		int expected = HttpStatus.OK.value();
		int actual = result.getResponse().getStatus();
		assertEquals(expected, actual);
	}

	@Test
	public void testLogRequestForListBooksResourceFetched() throws Exception {
		String uri = "/books/";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		int expected = HttpStatus.OK.value();
		int actual = result.getResponse().getStatus();
		assertEquals(expected, actual);
	}
}
