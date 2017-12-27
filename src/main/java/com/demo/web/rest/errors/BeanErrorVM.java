package com.demo.web.rest.errors;

import java.io.Serializable;

public class BeanErrorVM implements Serializable {

	private static final long serialVersionUID = 1L;


	private final String field;
	private final String errorCode;

	private final String message;
	private final String description;

	public BeanErrorVM(String field, String errorCode, String message, String description) {
		this.field = field;
		this.errorCode = errorCode;
		this.message = message;
		this.description= description;
	}

	public String getField() {
		return field;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	

}
