package com.deu.jdbc.exception;

public class DuplicateSsnException extends Exception {
	
	public DuplicateSsnException() {
		this("This is DuplicationException...");
	}
	
	public DuplicateSsnException(String message) {
		super(message);
	}
}
