package com.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.dto.Arrays;
import com.demo.dto.FinalArray;
import com.demo.web.rest.errors.CustomValidationException;
import com.demo.web.rest.util.TestUtil;

@RunWith(MockitoJUnitRunner.class)
public class MergeAndSortArrayServiceImplTest {

	@InjectMocks
	private MergeAndSortArrayServiceImpl mergeSortService;

	private TestUtil util = new TestUtil();

	private Arrays array;

	private FinalArray finalArr;

	@Before
	public void initTest() {
		array = util.getArraysJson();
		finalArr = util.getFinalArray(array);
	}

	@Test
	public void testCreateOneArray() {

		FinalArray result = mergeSortService.createOneArray(array);
		assertNotNull(result);
		assertEquals(finalArr.getMergedArray(), result.getMergedArray());
	}

	
	@Test(expected = CustomValidationException.class)
	public void testCreateOneArrayWithNull() {

		FinalArray result = mergeSortService.createOneArray(null);
		assertNull(result);
	}
	
	@Test(expected = CustomValidationException.class)
	public void testCreateOneArrayWithNullArrays() {
		array = util.getArraysJsonWithNull();
		FinalArray result = mergeSortService.createOneArray(array);
		assertNull(result);
	}
}
