package com.service.spring.domain;

public class QueryCommand {
	
	private String command;
	private String value;
	
	QueryCommand(){
	}
	
	
	
	public QueryCommand(String command, String value) {
		super();
		this.command = command;
		this.value = value;
	}



	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
