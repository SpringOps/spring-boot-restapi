package com.demo.web.rest;

import java.util.Optional;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.demo.web.rest.errors.ErrorConstants;

import io.swagger.annotations.ApiParam;

@Controller
public class DemoApiController implements DemoApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApiController.class);

	@Inject
	private FibonacciService fibonacciService;

	@Inject
	private MergeAndSortArrayService mergeAndSortArrayService;

	@Inject
	private StringReverseService stringReverseService;

	@Inject
	private TriangleTypeService triangleTypeService;
	
	private String pattern = "[0-9A-Za-z'! ]*" ;

	/**
	 * This method is used to get Fibonacci series number based on input
	 * position
	 * 
	 * @param long position
	 * @return ResponseEntity<Series> containing series number
	 * 
	 */

	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Series> getFibonacci(
			@Valid @ApiParam(value = "UserID (Principal)", required = false) @RequestHeader(value = "My-Api-Key", required = false) String myApiKey,
			@NotNull @ApiParam(value = "The index (position) of the Fibonacci sequence", required = true) @RequestParam(value = "position", required = true) long position) {
		
		LOGGER.info(" Going to get fibonacci series number based on input position ", position);
		Long seriesNumber = fibonacciService.getFibonacciSeriesValue(position);
		Series series = new Series();
		series.setResult(seriesNumber);
		LOGGER.info(" Got the series number and returning it ", seriesNumber);
		return Optional.ofNullable(series).map(result -> new ResponseEntity<>(series, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * This method is used to Merging and sorting of input arrays.
	 * 
	 * @param Arrays arrays
	 * 
	 * @return ResponseEntity<FinalArray> ,the merged array
	 * 
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<FinalArray> createOneArray(
			@ApiParam(value = "UserID (Principal)", required = false) @RequestHeader(value = "My-Api-Key", required = false) String myApiKey,
			@ApiParam(value = "Json Object with arrays", required = true) @Valid @RequestBody Arrays arrays) {
		
		LOGGER.info("got the array json and calling service to merge and sort it ", arrays);
		FinalArray mergedArray = mergeAndSortArrayService.createOneArray(arrays);
		LOGGER.info(" Final array has been created returing it ", mergedArray);
		return Optional.ofNullable(mergedArray).map(result -> new ResponseEntity<>(mergedArray, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * This method is used to reversing provided string input.
	 * 
	 * @param String sentence
	 * 
	 * @return ResponseEntity<ReversedString> ,containing the reversed string
	 *
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<ReversedString> getReverseWords(
			@ApiParam(value = "UserID (Principal)", required = false) @RequestHeader(value = "My-Api-Key", required = false) String myApiKey,
			@NotNull @ApiParam(value = "The sentence to be reveresed", required = true) @RequestParam(value = "sentence", required = true) String sentence) {
		if (sentence == null || sentence.length() <=0)
	      {
			LOGGER.error("String to be revered is null or empty");
	        throw new CustomValidationException("sourceString", ErrorConstants.SENTENCE_LENGTH_INVALID_CODE, ErrorConstants.SENTENCE_LENGTH_INVALID_MESSAGE);
	      }
		if (!Pattern.matches(pattern, sentence))
	      {
			LOGGER.error("String should have only alphabets and spaces");
	        throw new CustomValidationException("sourceString", ErrorConstants.SENTENCE_INVALID_CHARACTERS_CODE, ErrorConstants.SENTENCE_INVALID_CHARACTERS_MESSAGE);
	      }
		LOGGER.info("Got the sentence to be revered ", sentence);
		ReversedString inlineResponse2001 = new ReversedString();
		String reversedString = stringReverseService.getReversedWords(sentence);
		inlineResponse2001.setResult(reversedString);
		LOGGER.info("Api has revered the sentence and returning it ", reversedString);
		return Optional.ofNullable(inlineResponse2001)
				.map(result -> new ResponseEntity<>(inlineResponse2001, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * This method is used to check for triangle type based its edges.
	 * 
	 * @param Integer sideALength
	 * @param Integer sideBLength
	 * @param Integer sideCLength
	 * 
	 * @return ResponseEntity<Triangle> , containing the Triangle type
	 *
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Triangle> getTriangleType(
			@ApiParam(value = "UserID (Principal)", required = false) @RequestHeader(value = "My-Api-Key", required = false) String myApiKey,
			@NotNull @ApiParam(value = "The length of side a.", required = true)  @RequestParam(value = "sideALength", required = true) Integer sideALength,
			@NotNull @ApiParam(value = "The length of side b.", required = true)  @RequestParam(value = "sideBLength", required = true) Integer sideBLength,
			@NotNull @ApiParam(value = "The length of side c", required = true)  @RequestParam(value = "sideCLength", required = true) Integer sideCLength) {

		Triangle inlineResponse2001 = new Triangle();
		LOGGER.info(" Got the triangle's side length ", sideALength, sideBLength, sideCLength);
		if (sideALength == null|| sideBLength == null || sideCLength == null)
	      {
			LOGGER.error("At-least one side of triangle is null");
	        throw new CustomValidationException("TriangleSide", ErrorConstants.TRIANGLE_SIDE_INVALID_CODE, ErrorConstants.TRIANGLE_SIDE_INVALID_MESSAGE);
	      }
		String triangleType = triangleTypeService.findTriangleType(sideALength, sideBLength, sideCLength);
		inlineResponse2001.setResult(triangleType);
		LOGGER.info(" Triagle type has been identified ", triangleType);
		return Optional.ofNullable(inlineResponse2001)
				.map(result -> new ResponseEntity<>(inlineResponse2001, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
