package com.jack.exercise.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jack.exercise.service.ComplexAlgorithmService;

@SpringBootTest
public class LogExecutionTimeAspectTest {

	@Autowired
	private ComplexAlgorithmService service;

	@Test
	public void testLogExecutionTime() {
		service.executeComplexAlgorightm();
	}
	
}
