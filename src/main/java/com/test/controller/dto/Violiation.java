package com.test.controller.dto;

public class Violiation {
	private String columnName;
	private String message;
	public Violiation(String columnName, String message) {
		super();
		this.columnName = columnName;
		this.message = message;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
