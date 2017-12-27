package com.demo.web.rest.errors;

public final class ErrorConstants {

	public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
	public static final String ERR_ACCESS_DENIED = "error.accessDenied";
	public static final String ERR_VALIDATION = "error.validation";
	public static final String ERR_METHOD_NOT_SUPPORTED = "error.methodNotSupported";
	public static final String ERR_INTERNAL_SERVER_ERROR = "error.internalServerError";
	public static final String ERR_SQL_ERROR = "error.sqlerError";
	public static final String TYPE_MISMATCH = "error.typeMismatch";
	public static final String ERR_FIELD = "error.fieldNotFound";
	public static final String ERR_DB_NO_RECORD_FOUND="BAP100";
	public static final String ERR_INVALID_DATEFORMAT="BAP101";
	public static final String ERR_MISSING_PARAMETER="BAP102";
	public static final String ERR_SERVICE_DOWN="BAP103";
	public static final String ERR_CONTENT_TYPE_NOT_SUPPORTED="BAP104";


	
	public static final String ERR_ITEM_COUNT_REQUIRED ="error.itemCount.notnull";

	public static final String ERR_ITEM_COUNT_INVALID ="error.itemCount.format";
	
	public static final String ERR_MAX_LENGTH ="DEM100";
	public static final String ERR_MIN_LENGTH ="DEM101";

	
	
	public static final String ERR_SIZE_LENGTH ="{javax.validation.constraints.Size.message}";
	

	private ErrorConstants() {
	}

}
