package com.demo.service;

import com.demo.dto.Arrays;
import com.demo.dto.FinalArray;

/**
 * Service Interface for managing Merging and sorting of input arrays.
 */
public interface MergeAndSortArrayService {
	
	/**
	 * This method is used to  Merging and sorting of input arrays.
	 * @param Arrays arrayJson
	 * @return FinalArray ,the merged array
	 */
	FinalArray createOneArray(Arrays arrayJson);
	 
}
