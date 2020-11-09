package com.jack.exercise.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogExecutionTimeAspect {
	
	@Around("@annotation(com.jack.exercise.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object proceed = joinPoint.proceed();
		
		long duration = System.currentTimeMillis() - start;
		
		System.err.println(joinPoint.getSignature() + " executed in " + duration + "ms.");
		
		return proceed;
	}
	
}
