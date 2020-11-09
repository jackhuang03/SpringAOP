package com.jack.exercise.service;

import org.springframework.stereotype.Service;

import com.jack.exercise.annotation.LogExecutionTime;

@Service
public class ComplexAlgorithmService {
	
	@LogExecutionTime
	public void executeComplexAlgorightm() {
		Integer longExecutionTime = Integer.valueOf(9000);
		try {
			System.out.println("Complex algorithm is processing.......");
			Thread.sleep(longExecutionTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
