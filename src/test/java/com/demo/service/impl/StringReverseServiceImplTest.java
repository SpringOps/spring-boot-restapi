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
public class StringReverseServiceImplTest {

	
	@InjectMocks
	private StringReverseServiceImpl stringReverseService;
	
	@Test
	public void testReverseWords() {
		String sentence = "This is test";
		String result = stringReverseService.getReversedWords(sentence);
	 
		assertNotNull(result);
        assertEquals("sihT si tset", result);
	}
	
	@Test(expected = CustomValidationException.class)
	public void testReverseWordsWithNull() {
		String sentence = null;
		String result =  stringReverseService.getReversedWords(sentence);
 
		assertNull(result);
	}
	
	@Test(expected = CustomValidationException.class)
	public void testReverseWordsWithEmptyString() {
		String sentence = "";
		String result =  stringReverseService.getReversedWords(sentence);
 
		assertNull(result);
	}
}
