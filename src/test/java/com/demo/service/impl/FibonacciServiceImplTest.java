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
		Integer seriesPosition = 4;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciWithNull() {
		Integer seriesPosition = null;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciException() {
		Integer seriesPosition = 98;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
	
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciExceptionWithNagetive() {
		Integer seriesPosition = -98;
		Long value = fibonacciService.getFibonacciSeriesValue(seriesPosition);
	 	assertNotNull(value);
	 	
	}
}
