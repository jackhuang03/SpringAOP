package com.jack.exercise.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LogControllerAspect {

	private static final Logger log = LoggerFactory.getLogger(LogControllerAspect.class);
	
	@Pointcut("within(com.jack.exercise.controller.*)")
	public void pointcut() {}
	
	@Before("@annotation(getMapping) && pointcut()")
	public void logGetRequest(JoinPoint joinPoint, GetMapping getMapping) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		log.info("請求來源: " + request.getRemoteAddr());
		log.info("Session ID: " + request.getSession().getId());
		log.info("資源類: " + joinPoint.getTarget().getClass().getName());
		log.info("資源目的: " + joinPoint.getSignature().getName());
		log.info("資源參數: " + Arrays.asList(joinPoint.getArgs()));
		log.info("資源URI: " + Arrays.asList(getMapping.value()));
	}
	
	
	
}
