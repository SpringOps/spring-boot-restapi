package com.demo.web.rest.errors;

import java.io.Serializable;

public class BeanCommonErrorVM implements Serializable {

	private static final long serialVersionUID = 1L;


	
	private final String errorCode;

	private final String message;
	private final String description;

	public BeanCommonErrorVM(String errorCode, String message, String description) {
		this.errorCode = errorCode;
		this.message = message;
		this.description= description;
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
