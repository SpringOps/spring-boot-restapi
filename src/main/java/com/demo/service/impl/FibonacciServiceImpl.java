package com.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.service.FibonacciService;
import com.demo.web.rest.errors.CustomValidationException;
import com.demo.web.rest.errors.ErrorConstants;
 

/**
 * Service Implementation for managing Fibonacci Series.
 */
@Service
@Transactional
public class FibonacciServiceImpl implements FibonacciService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciServiceImpl.class);
    protected Integer THRESHOLD = 92;
    
    /**
	 * This method is used to get Fibonacci series number based on input position
	 * @param long position
	 * @return Long series number
	 * Throws CustomValidationException if input is not correct
	 */
	@Override
	public Long getFibonacciSeriesValue(long position) {
		
		LOGGER.info("Going to calculate value based on provided position", position);
		if ( position > THRESHOLD)
	      {
			LOGGER.error("Input cannot be greater than", THRESHOLD);
	        throw new CustomValidationException("position", ErrorConstants.FIBONACCI_INPUT_THRESHOLD_CODE, ErrorConstants.FIBONACCI_INPUT_THRESHOLD_MESSAGE);
	      }

	      if (position < 0)
	      {
	    	  LOGGER.error("Input can not be below ", 0);
	        throw new CustomValidationException("position", ErrorConstants.FIBONACCI_NAGETIVE_INPUT_CODE, ErrorConstants.FIBONACCI_NAGETIVE_INPUT_MESSAGE);
	      }
	      Long result = CalculateSequence(position);
	      
	      LOGGER.info(" sequence has been calculated ", result);
	      
		return result;
	}
	
	/**
	 * This method is used to get calculate series number based on input position
	 * @param Integer number
	 * @return Long series number
	 */
	 protected Long CalculateSequence(long number)
	    {
//		 LOGGER.info("calculating sequence ", number);
//	      if (number <= 1)
//	      {
//	        return number;
//	      }
//
//	      return CalculateSequence(number - 1) + CalculateSequence(number - 2);
		 
		 Double numerator = Math.pow((1.0 + Math.sqrt(5.0)), number) - Math.pow((1.0 - Math.sqrt(5.0)), number);
		 Double denominator = Math.pow(2.0, number) * Math.sqrt(5.0);
		 Double result = numerator / denominator;
		 LOGGER.info(" Below line always round of the result to maximum value " + Long.MAX_VALUE + " of long data type" );
		  Long roundedResult = Math.round(result);

	      return roundedResult;
	    }
	
}
