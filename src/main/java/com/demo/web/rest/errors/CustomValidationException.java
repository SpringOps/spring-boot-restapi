package com.demo.web.rest.errors;

public class CustomValidationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	private  String field;
	private  String  errorCode;
	private String message;
	
	public CustomValidationException(String field, String errorCode, String message) {
		super();
		this.field = field;
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

