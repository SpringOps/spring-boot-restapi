package com.demo.service;

import java.math.BigInteger;

/**
 * Service Interface get Fibonacci series number based on input position.
 */
public interface FibonacciService {
	
	/**
	 * This method is used to get Fibonacci series number based on input position
	 * @param Integer position
	 * @return Long series number
	 */
	Long getFibonacciSeriesValue(Integer position);
	
}
