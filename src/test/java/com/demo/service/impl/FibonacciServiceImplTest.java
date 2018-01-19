package com.demo.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.web.rest.errors.CustomValidationException;

@RunWith(MockitoJUnitRunner.class)
public class FibonacciServiceImplTest {

	@InjectMocks
	private FibonacciServiceImpl fibonacciService;
	
	@Test
	public void testGetFibonacci() {
		long seriesPosition = 4;
		BigDecimal value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciWithNull() {
		long seriesPosition = -1;
		BigDecimal value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciException() {
		long seriesPosition = 999999;
		BigDecimal value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciExceptionWithNagetive() {
		long seriesPosition = -98;
		BigDecimal value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test
	public void testMyApp(){
		  int number = 57;
//			 LOGGER.info("calculating sequence ", number);
//		      if (number <= 1)
//		      {
//		        return number;
//		      }
	//
//		      return CalculateSequence(number - 1) + CalculateSequence(number - 2);
			 
			 BigDecimal numerator = BigDecimal.valueOf( Math.pow((1.0 + Math.sqrt(5.0)), number) - Math.pow((1.0 - Math.sqrt(5.0)), number));
			 BigDecimal denominator = BigDecimal.valueOf(Math.pow(2.0, number) * Math.sqrt(5.0));
			 BigDecimal result = numerator.divide(denominator, 3, RoundingMode.CEILING);
			 System.out.println(" result is " + result);
			//  BigDecimal roundedResult = Math.round(result);

		     // return roundedResult;
			 
	}
}
