package com.demo.service.impl;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.service.FibonacciService;
import com.demo.web.rest.errors.CustomValidationException;
 

/**
 * Service Implementation for managing Fibonacci Series.
 */
@Service
@Transactional
public class FibonacciServiceImpl implements FibonacciService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciServiceImpl.class);
    protected Integer THRESHOLD = 90;
    
    /**
	 * This method is used to get Fibonacci series number based on input position
	 * @param Integer position
	 * @return Long series number
	 * Throws CustomValidationException if input is not correct
	 */
	@Override
	public Long getFibonacciSeriesValue(Integer position) {
		
		LOGGER.info("Going to calculate value based on provided position", position);
		if (position == null || position > THRESHOLD)
	      {
			LOGGER.error("Input cannot be greater than", THRESHOLD);
	        throw new CustomValidationException("position", "ERROR100", "Input cannot be null and greater than "+ THRESHOLD+ " since result may exceed integer value");
	      }

	      if (position < -THRESHOLD)
	      {
	    	  LOGGER.error("Input can not be below ", THRESHOLD);
	        throw new CustomValidationException("position", "ERROR101",  "Input can not be below "+ THRESHOLD+ " since result may exceed integer value");
	      }
	      Long result = CalculateSequence(position);
	      
	      LOGGER.info(" sequence has been calculated ", result);
	      
	      if (result < 0 && (result % 2 == 0))
	      {
	        result = -result;
	      }
	      
		return result;
	}
	
	/**
	 * This method is used to get calculate series number based on input position
	 * @param Integer number
	 * @return Long series number
	 */
	 protected Long CalculateSequence(Integer number)
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

		  Long roundedResult = Math.round(result);

	      return roundedResult;
	    }
	
}
