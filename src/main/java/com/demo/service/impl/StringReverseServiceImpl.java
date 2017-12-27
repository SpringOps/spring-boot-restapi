package com.demo.service.impl;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.service.StringReverseService;
import com.demo.web.rest.errors.CustomValidationException;
 

/**
 * Service Implementation to reverse provided string.
 */
@Service
@Transactional
public class StringReverseServiceImpl implements StringReverseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StringReverseServiceImpl.class);

	/**
	 * This method is used to reversing provided string input.
	 * 
	 * @param String sourceString
	 * 
	 * @return String ,the reversed string
	 * 
	 * @throws CustomValidationException if , input string is null or empty
	 */
	@Override
	public String getReversedWords(String sourceString) {
		if (sourceString == null || sourceString.isEmpty())
	      {
			LOGGER.error("String to be revered is null or empty");
	        throw new CustomValidationException("sourceString", "ERROR102", "Sentence should have at-least 1 word to be revered");
	      }
		LOGGER.info("Going to reverse the provided string ", sourceString);
		String st = Pattern.compile(" +").splitAsStream(sourceString)
		        .map(word->new StringBuilder(word).reverse())
		        .collect(Collectors.joining(" "));
		 return st;
	}

}
