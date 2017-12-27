package com.demo.service.impl;

import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.Arrays;
import com.demo.dto.FinalArray;
import com.demo.service.MergeAndSortArrayService;
import com.demo.web.rest.errors.CustomValidationException;

/**
 * Service Implementation for managing Merging and sorting of input arrays.
 */
@Service
@Transactional
public class MergeAndSortArrayServiceImpl implements MergeAndSortArrayService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MergeAndSortArrayServiceImpl.class);

	/**
	 * This method is used to Merging and sorting of input arrays.
	 * 
	 * @param Arrays arrayJson
	 * 
	 * @return FinalArray ,the merged array
	 * @throws CustomValidationException if , array json is empty
	 */
	@Override
	public FinalArray createOneArray(Arrays arrayJson) {
		LOGGER.info("Going to merge and sort arrays", arrayJson);
		if (arrayJson == null) {
			LOGGER.error("Array json is null , can not merge it");
			throw new CustomValidationException("sourceString", "ERROR103", "JSON should contains at-least 1 array");
		}
		Integer[] mergedArray = mergeAndSortArrays(arrayJson.getArray1(), arrayJson.getArray2(), arrayJson.getArray3());
		LOGGER.info("got merged array ");
		FinalArray finalArray = new FinalArray();
		finalArray.setMergedArray(mergedArray);
		LOGGER.info("Returning final array ", finalArray);
		return finalArray;
	}

	/**
	 * This method is used to Merging and sorting of input arrays.
	 * 
	 * @param Integer array arrayOne
	 * @param Integer array arrayTwo
	 * @param Integer array arrayThree
	 * 
	 * @return Integer[] ,the merged array
	 */
	private Integer[] mergeAndSortArrays(Integer[] arrayOne, Integer[] arrayTwo, Integer[] arrayThree) {

		LOGGER.info("merging arrays");
		TreeSet<Integer> hashedArray = new TreeSet<Integer>();
		if (arrayOne == null && arrayTwo == null && arrayThree == null) {
			LOGGER.error("Arrays does'nt have elements , can not merge it");
			throw new CustomValidationException("sourceString", "ERROR103", "JSON should contains at-least 1 array");
		}
		if (arrayOne != null) {
			for (Integer entry : arrayOne) {
				hashedArray.add(entry);
			}
		}
		if (arrayTwo != null) {
			for (Integer entry : arrayTwo) {
				hashedArray.add(entry);
			}
		}
		if (arrayThree != null) {
			for (Integer entry : arrayThree) {
				hashedArray.add(entry);
			}
		}
		LOGGER.info("Arrays has been merge and sorted");
		return hashedArray.toArray(new Integer[0]);
	}

}
