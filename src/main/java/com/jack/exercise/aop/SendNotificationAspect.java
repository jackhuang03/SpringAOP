package com.jack.exercise.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jack.exercise.exception.TriggerSendNotificationException;

@Component
@Aspect
public class SendNotificationAspect {

	@AfterThrowing(pointcut="execution(public * com.jack..*(..))", throwing = "ex")
	public void afterThrowAdvice(JoinPoint joinPoint, TriggerSendNotificationException ex) {
		System.err.println("Responsible person was notified for error occurring in [" + joinPoint.getSignature() + "]");
		System.err.println("Exception was [ " + ex.getMessage() + " ]");
	}
	
}
