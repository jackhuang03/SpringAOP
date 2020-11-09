package com.jack.exercise.service;

import org.springframework.stereotype.Service;

import com.jack.exercise.exception.TriggerSendNotificationException;

@Service
public class TriggerSendNotificationService {

	public void throwException() {
		throw new TriggerSendNotificationException("Oops... Critial issue happend.");
	}
	
}
