package com.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.web.rest.errors.CustomValidationException;

@RunWith(MockitoJUnitRunner.class)
public class TriangleTypeServiceImplTest {

	@InjectMocks
	private TriangleTypeServiceImpl triangleTypeService;

	@Test
	public void testTriangleTypeIsosceles() {
		Integer sideALength = 1;
		Integer sideBLength = 2;
		Integer sideCLength = 2;
		String result = triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength);
		assertNotNull(result);
		assertEquals(TriangleType.ISOSCELES.getShape(), result);
	}

	@Test
	public void testTriangleTypeEquilateral() {
		Integer sideALength = 1;
		Integer sideBLength = 1;
		Integer sideCLength = 1;
		String result = triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength);
		assertNotNull(result);
		assertEquals(TriangleType.EQUILATERAL.getShape(), result); 
	}

	@Test
	public void testTriangleTypeScalene() {
		Integer sideALength = 3;
		Integer sideBLength = 5;
		Integer sideCLength = 4;
		String result = triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength);
		assertNotNull(result);
		assertEquals(TriangleType.SCALENE.getShape(), result);
	}

	@Test
	public void testTriangleTypeWithUndefined() {
		Integer sideALength = 1;
		Integer sideBLength = 2;
		Integer sideCLength = 4;
		String result = triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength);
		assertNotNull(result);
		assertEquals(TriangleType.ERROR.getShape(), result);
	}

	@Test(expected = CustomValidationException.class)
	public void testTriangleTypeWithNull() {
		Integer sideALength = 0;
		Integer sideBLength = 0;
		Integer sideCLength = 0;
		String result = triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength);
        assertNull(result);
	}
}
