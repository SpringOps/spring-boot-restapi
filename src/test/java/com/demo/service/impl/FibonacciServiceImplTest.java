package com.demo.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciWithNull() {
		long seriesPosition = -1;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciException() {
		long seriesPosition = 101;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciExceptionWithNagetive() {
		long seriesPosition = -98;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
}
