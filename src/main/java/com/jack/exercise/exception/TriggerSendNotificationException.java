package com.jack.exercise.exception;

public class TriggerSendNotificationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TriggerSendNotificationException() {
		super();
	}
	
	public TriggerSendNotificationException(String errorMessage) {
		super(errorMessage);
	}

}
