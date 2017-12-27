package com.demo.service;

/**
 * Service Interface for reversing provided string input.
 */
public interface StringReverseService {
	
	/**
	 * This method is used to reversing provided string input.
	 * 
	 * @param String sourceString
	 * 
	 * @return String ,the reversed string
	 * 
	 * @throws CustomValidationException if , input string is null or empty
	 */
	String getReversedWords(String sourceString);
	 
}
