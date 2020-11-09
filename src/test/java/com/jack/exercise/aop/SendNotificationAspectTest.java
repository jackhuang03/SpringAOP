package com.jack.exercise.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jack.exercise.exception.TriggerSendNotificationException;
import com.jack.exercise.service.TriggerSendNotificationService;

@SpringBootTest
public class SendNotificationAspectTest {

	@Autowired
	private TriggerSendNotificationService service;
	
	@Test
	public void testNotifyPersonAfterThrowCustomException() {
		Exception exception = assertThrows(TriggerSendNotificationException.class, () -> { service.throwException(); });
		
		String expected = "Oops... Critial issue happend.";
		String actual = exception.getMessage();
		
		assertEquals(expected, actual);
	}
	
}
