package com.deu.jdbc.exception;

public class RecordNotFoundException extends Exception {
	
	public RecordNotFoundException() {
		this("This is RecordNotFoundExceptionn...");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
}
