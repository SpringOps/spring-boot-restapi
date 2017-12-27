package com.demo.web.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.dto.Arrays;
import com.demo.dto.FinalArray;
import com.demo.dto.ReversedString;
import com.demo.dto.Series;
import com.demo.dto.Triangle;
import com.demo.service.FibonacciService;
import com.demo.service.MergeAndSortArrayService;
import com.demo.service.StringReverseService;
import com.demo.service.TriangleTypeService;
import com.demo.web.rest.errors.CustomValidationException;
import com.demo.web.rest.util.TestUtil;
 
@RunWith(MockitoJUnitRunner.class)
public class DemoApiControllerTest {

	@InjectMocks
	DemoApiController demoApiController;

	@Mock
	private FibonacciService fibonacciService;
	
	@Mock
	private MergeAndSortArrayService mergeSortService;
	
	@Mock
	private StringReverseService stringReverseService;
	
	@Mock
	private TriangleTypeService triangleTypeService;
	
	 
	private TestUtil util = new TestUtil();
	
	private Arrays array ;
	
	private FinalArray finalArr;
	
	@Before
	public void initTest() {
		array = util.getArraysJson();
		finalArr = util.getFinalArray(array);
	}
	
	@Test
	public void testGetFibonacci() {
		Integer seriesPosition = 4;
		Mockito.when(fibonacciService.getFibonacciSeriesValue(seriesPosition)).thenReturn(3L);
		ResponseEntity<Series> responseEntity = demoApiController.getFibonacci(
				"testUser",
				seriesPosition);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(3L, responseEntity.getBody().getResult().longValue());
	}
	
	@Test
	public void testGetFibonacciWithoutApiKey() {
		Integer seriesPosition = 4;
		Mockito.when(fibonacciService.getFibonacciSeriesValue(seriesPosition)).thenReturn(3L);
		ResponseEntity<Series> responseEntity = demoApiController.getFibonacci(
				null,
				seriesPosition);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
       
	}
	
	@Test
	public void testGetFibonacciWithNull() {
		Integer seriesPosition = null;
		Mockito.when(fibonacciService.getFibonacciSeriesValue(seriesPosition)).thenReturn(null);
		ResponseEntity<Series> responseEntity = demoApiController.getFibonacci(
				"testUser",
				seriesPosition);
		assertNull(responseEntity.getBody().getResult());
		
	}
	@Test(expected = CustomValidationException.class)
	public void testGetFibonacciWithThresholdValue() {
		Integer seriesPosition = 98;
		Mockito.when(fibonacciService.getFibonacciSeriesValue(seriesPosition)).thenThrow(CustomValidationException.class);
		ResponseEntity<Series> responseEntity = demoApiController.getFibonacci(
				"testUser",
				seriesPosition);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
	
	@Test
	public void testReverseWords() {
		String sentence = "This is test";
		Mockito.when(stringReverseService.getReversedWords(sentence)).thenReturn("sihT si tset");
		ResponseEntity<ReversedString> responseEntity = demoApiController.getReverseWords(
				"testUser",
				sentence);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("sihT si tset", responseEntity.getBody().getResult());
	}
	
	@Test
	public void testReverseWordsWithoutApiKey() {
		String sentence = "This is test";
		Mockito.when(stringReverseService.getReversedWords(sentence)).thenReturn("sihT si tset");
		ResponseEntity<ReversedString> responseEntity = demoApiController.getReverseWords(
				null,
				sentence);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
       
	}
	@Test(expected = CustomValidationException.class)
	public void testReverseWordsWithEmptyString() {
		String sentence = "";
		ResponseEntity<ReversedString> responseEntity = demoApiController.getReverseWords(
				null,
				sentence);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
       
	}
	
	@Test(expected = CustomValidationException.class)
	public void testReverseWordsWithNull() {
		String sentence = null;
		Mockito.when(stringReverseService.getReversedWords(sentence)).thenThrow(CustomValidationException.class);
		ResponseEntity<ReversedString> responseEntity = demoApiController.getReverseWords(
				"testUser",
				sentence);
		
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
	
	@Test
	public void testTriangleTypeIsosceles() {
		Integer sideALength = 1;
		Integer sideBLength = 2;
		Integer sideCLength = 2;
		String type = "Isosceles";
		Mockito.when(triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength)).thenReturn(type);
		ResponseEntity<Triangle> responseEntity = demoApiController.getTriangleType(
				"testUser",
				sideALength, sideBLength, sideCLength);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(type, responseEntity.getBody().getResult());
	}
	
	@Test
	public void testTriangleTypeIsoscelesWithoutApiKey() {
		Integer sideALength = 1;
		Integer sideBLength = 2;
		Integer sideCLength = 2;
		String type = "Isosceles";
		Mockito.when(triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength)).thenReturn(type);
		ResponseEntity<Triangle> responseEntity = demoApiController.getTriangleType(
				null,
				sideALength, sideBLength, sideCLength);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        
	}
	
	@Test
	public void testTriangleTypeEquilateral() {
		Integer sideALength = 1;
		Integer sideBLength = 1;
		Integer sideCLength = 1;
		String type = "Equilateral";
		Mockito.when(triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength)).thenReturn(type);
		ResponseEntity<Triangle> responseEntity = demoApiController.getTriangleType(
				"testUser",
				sideALength, sideBLength, sideCLength);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(type, responseEntity.getBody().getResult());
	}
	
	@Test
	public void testTriangleTypeScalene() {
		Integer sideALength = 3;
		Integer sideBLength = 5;
		Integer sideCLength = 4;
		String type = "Scalene";
		Mockito.when(triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength)).thenReturn(type);
		ResponseEntity<Triangle> responseEntity = demoApiController.getTriangleType(
				"testUser",
				sideALength, sideBLength, sideCLength);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(type, responseEntity.getBody().getResult());
	}
	
	@Test
	public void testTriangleTypeWithUndefined() {
		Integer sideALength = 1;
		Integer sideBLength = 2;
		Integer sideCLength = 4;
		String type = "Undefine-Shape";
		Mockito.when(triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength)).thenReturn(type);
		ResponseEntity<Triangle> responseEntity = demoApiController.getTriangleType(
				"testUser",
				sideALength, sideBLength, sideCLength);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(type, responseEntity.getBody().getResult());
	}
	
	@Test(expected = CustomValidationException.class)
	public void testTriangleTypeWithNull() {
		Integer sideALength = 0;
		Integer sideBLength = 0;
		Integer sideCLength = 0;
		String type = "Undefine-Shape";
		Mockito.when(triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength)).thenThrow(CustomValidationException.class);
		ResponseEntity<Triangle> responseEntity = demoApiController.getTriangleType(
				"testUser",
				sideALength, sideBLength, sideCLength);
	}
	
	@Test
	public void testCreateOneArray() {
		 
		Mockito.when(mergeSortService.createOneArray(array)).thenReturn(finalArr);
		ResponseEntity<FinalArray> responseEntity = demoApiController.createOneArray(
				"testUser",
				array);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(finalArr, responseEntity.getBody());
	}
	
	@Test
	public void testCreateOneArrayWithouApiKey() {
		 
		Mockito.when(mergeSortService.createOneArray(array)).thenReturn(finalArr);
		ResponseEntity<FinalArray> responseEntity = demoApiController.createOneArray(
				null,
				array);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
 
	}
	
	@Test(expected = CustomValidationException.class)
	public void testCreateOneArrayWithNull() {
		 
		Mockito.when(mergeSortService.createOneArray(null)).thenThrow(CustomValidationException.class);
		ResponseEntity<FinalArray> responseEntity = demoApiController.createOneArray(
				"testUser",
				null);
		
	}
}	