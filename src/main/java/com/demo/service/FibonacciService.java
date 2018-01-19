package com.demo.service;

import java.math.BigDecimal;

/**
 * Service Interface get Fibonacci series number based on input position.
 */
public interface FibonacciService {
	
	/**
	 * This method is used to get Fibonacci series number based on input position
	 * @param Integer position
	 * @return Long series number
	 */
	BigDecimal getFibonacciSeriesValue(long position);
	
}
