/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.demo.web.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.dto.Arrays;
import com.demo.dto.Errors;
import com.demo.dto.FinalArray;
import com.demo.dto.ReversedString;
import com.demo.dto.Series;
import com.demo.dto.Triangle;
import com.demo.web.rest.errors.CustomValidationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T09:43:56.688Z")

@RequestMapping("/api")
@Api(value = "api", description = "the Demo API")
public interface DemoApi {

	/**
	 * This method is used to get Fibonacci series number based on input position
	 * @param Integer n
	 * @return  ResponseEntity<Series> containing series number
	 * 
	 */
	@ApiOperation(value = "Returns the nth Fibonacci number.", notes = "Returns the nth number in the Fibonacci sequence.", response = Series.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Series Details.", response = Series.class),
        @ApiResponse(code = 400, message = "Parameter do not match the expected format.", response = Errors.class),
        @ApiResponse(code = 401, message = "Unauthorized -Identity token is not passed.", response = Errors.class),
        @ApiResponse(code = 403, message = "Forbidden - Identity does not have authority for the specified request.", response = Errors.class),
        @ApiResponse(code = 500, message = "Error Occured.", response = Errors.class),
        @ApiResponse(code = 503, message = "Service Unavailable -  Returned If this function is dependent on other services which are unavailable or DB connection failure etc.", response = Errors.class) })
    
    @RequestMapping(value = "/fibonacci",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Series> getFibonacci(@ApiParam(value = "UserID (Principal)" ,required=true) @RequestHeader(value="My-Api-Key", required=false) String myApiKey, @NotNull@ApiParam(value = "The index (n) of the Fibonacci sequence", required = true) @RequestParam(value = "n", required = true) Integer n);


	/**
	 * This method is used to Merging and sorting of input arrays.
	 * 
	 * @param Arrays arrays
	 * 
	 * @return  ResponseEntity<FinalArray> ,the merged array
	 * 
	 */
    @ApiOperation(value = "Accepts JSON objects with multiple number arrays. Combine these arrays, removes duplicate numbers and sorts them. Response is JSON object which contains this combined sorted array.", notes = "Combine, remove duplicate and sort all input arrays in request JSON object.", response = FinalArray.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The array found successfully.", response = FinalArray.class),
        @ApiResponse(code = 400, message = "Parameter do not match the expected format.", response = Errors.class),
        @ApiResponse(code = 401, message = "Unauthorized -Identity token is not passed.", response = Errors.class),
        @ApiResponse(code = 403, message = "Forbidden - Identity does not have authority for the specified request.", response = Errors.class),
        @ApiResponse(code = 500, message = "Error Occured.", response = Errors.class),
        @ApiResponse(code = 503, message = "Service Unavailable -  Returned If this function is dependent on other services which are unavailable or DB connection failure etc.", response = Errors.class) })
    
    @RequestMapping(value = "/makeonearray",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<FinalArray> createOneArray(@ApiParam(value = "UserID (Principal)" ,required=true) @RequestHeader(value="My-Api-Key", required=false) String myApiKey,@ApiParam(value = "Json Object with arrays" ,required=true )  @Valid @RequestBody Arrays arrays);


    /**
	 * This method is used to reversing provided string input.
	 * 
	 * @param String sentence
	 * 
	 * @return ResponseEntity<ReversedString> ,containing the reversed string
	 *
	 */
    @ApiOperation(value = "Reverses the letters of each word in a sentence.", notes = "Reverses the letters of each word in a sentence.", response = ReversedString.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "String reversed.", response = ReversedString.class),
        @ApiResponse(code = 400, message = "Parameter do not match the expected format.", response = Errors.class),
        @ApiResponse(code = 401, message = "Unauthorized -Identity token is not passed.", response = Errors.class),
        @ApiResponse(code = 403, message = "Forbidden - Identity does not have authority for the specified request.", response = Errors.class),
        @ApiResponse(code = 404, message = "Data Not found.", response = Errors.class),
        @ApiResponse(code = 500, message = "Error Occured.", response = Errors.class),
        @ApiResponse(code = 503, message = "Service Unavailable -  Returned If this function is dependent on other services which are unavailable or DB connection failure etc.", response = Errors.class) })
    
    @RequestMapping(value = "/reverseWords",
        produces = { "application/json"},
        method = RequestMethod.GET)
    ResponseEntity<ReversedString> getReverseWords(@ApiParam(value = "UserID (Principal)" ,required=true) @RequestHeader(value="My-Api-Key", required=false) String myApiKey, @NotNull@ApiParam(value = "The sentence to be reveresed", required = true) @RequestParam(value = "sentence", required = true) String sentence);


    /**
   	 * This method is used to check for triangle type based its edges.
   	 * 
   	 * @param Integer a
   	 * @param Integer b
   	 * @param Integer c
   	 * 
   	 * @return ResponseEntity<Triangle> , containing the Triangle type
   	 *
   	 */
       
    @ApiOperation(value = "RetrieveReturns the type of triangle given the lengths of its sides", notes = "Returns the type of triangle given the lengths of its sides", response = Triangle.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Triangle Details.", response = Triangle.class),
        @ApiResponse(code = 400, message = "Parameter do not match the expected format.", response = Errors.class),
        @ApiResponse(code = 401, message = "Unauthorized -Identity token is not passed.", response = Errors.class),
        @ApiResponse(code = 403, message = "Forbidden - Identity does not have authority for the specified request.", response = Errors.class),
        @ApiResponse(code = 500, message = "Error Occured.", response = Errors.class),
        @ApiResponse(code = 503, message = "Service Unavailable -  Returned If this function is dependent on other services which are unavailable or DB connection failure etc.", response = Errors.class) })
    @RequestMapping(value = "/triangleType",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Triangle> getTriangleType(@ApiParam(value = "UserID (Principal)" ,required=true) @RequestHeader(value="My-Api-Key", required=false) String myApiKey, @NotNull@ApiParam(value = "The length of side a.", required = true) @RequestParam(value = "a", required = true) Integer a, @NotNull@ApiParam(value = "The length of side b.", required = true) @RequestParam(value = "b", required = true) Integer b, @NotNull@ApiParam(value = "The length of side c", required = true) @RequestParam(value = "c", required = true) Integer c);

}
