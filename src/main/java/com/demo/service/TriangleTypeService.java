package com.demo.service;

/**
 * Service Interface for calculating triangle type based inputs.
 */
public interface TriangleTypeService {
	
	/**
	 * This method is used to check for triangle type based its edges.
	 * 
	 * @param Integer sideALength
	 * @param Integer sideBLength
	 * @param Integer sideCLength
	 * 
	 * @return String ,the Triangle type
	 * 
	 * @throws CustomValidationException if , input triangle sides are null or 0
	 */
	String findTriangleType(Integer sideALength, Integer sideBLength, Integer sideCLength);

	 
}
