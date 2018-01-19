package com.demo.web.rest.errors;

public final class ErrorConstants {

	private static final int THRESHOLD = 92;
	public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
	public static final String ERR_ACCESS_DENIED = "error.accessDenied";
	public static final String ERR_VALIDATION = "error.validation";
	public static final String ERR_METHOD_NOT_SUPPORTED = "error.methodNotSupported";
	public static final String ERR_INTERNAL_SERVER_ERROR = "error.internalServerError";
	public static final String ERR_SQL_ERROR = "error.sqlerError";
	public static final String TYPE_MISMATCH = "error.typeMismatch";
	public static final String ERR_FIELD = "error.fieldNotFound";

	public static final String ERR_SIZE_LENGTH ="{javax.validation.constraints.Size.message}";
 	
    /* Demo Service error codes start here */
	public static final String FIBONACCI_NAGETIVE_INPUT_CODE = "ERROR100";
	public static final String FIBONACCI_NAGETIVE_INPUT_MESSAGE = "Input can not be nagetive as fibonacci series starts with 0";
	public static final String FIBONACCI_INPUT_THRESHOLD_CODE = "ERROR101";
	public static final String FIBONACCI_INPUT_THRESHOLD_MESSAGE = "Input position must be 0 to "+ THRESHOLD+ " since result may exceed maximum "+Long.MAX_VALUE + " value for used datatype";
	public static final String SENTENCE_LENGTH_INVALID_CODE = "ERROR102";
	public static final String SENTENCE_LENGTH_INVALID_MESSAGE = "Sentence should have at-least 1 word to be reversed";
	public static final String SENTENCE_INVALID_CHARACTERS_CODE = "ERROR103" ;
	public static final String SENTENCE_INVALID_CHARACTERS_MESSAGE = "Sentence should have only alphabets and spaces";
	public static final String ARRAY_JSON_INPUT_NULL_CODE = "ERROR104";
	public static final String ARRAY_JSON_INPUT_NULL_MESSAGE = "JSON should contains at-least one integer array to get sorted";
	public static final String JSON_INPUT_WITH_ALL_NULL_ARRAYS_CODE = "ERROR105";
	public static final String JSON_INPUT_WITH_ALL_NULL_ARRAYS_MESSAGE = "At-least one array should contains integers to be sorted";
	public static final String TRIANGLE_SIDE_INVALID_CODE = "ERROR106";
	public static final String TRIANGLE_SIDE_INVALID_MESSAGE = "Please provide valid value for triangle sides";
	public static final String ERR_CONTENT_TYPE_NOT_SUPPORTED="ERROR107";
	public static final String ERR_MISSING_PARAMETER="ERROR108";
	public static final String INVALID_DATA_TYPE = "ERROR109";
	public static final String INVALID_DATA_TYPE_MESSAGE = "Please input only numeric values";
	 /* Demo Service error codes end here */
	
	private ErrorConstants() {
	}

}
