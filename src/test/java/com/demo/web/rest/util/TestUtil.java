package com.demo.web.rest.util;

import java.util.TreeSet;

import com.demo.dto.Arrays;
import com.demo.dto.FinalArray;
import com.demo.web.rest.errors.CustomValidationException;

public class TestUtil {
	
	public Arrays getArraysJson(){
		Integer[] arr1 = {1,2};
		Integer[] arr2 = {3,6};
		Integer[] arr3 = {5,7};
		
		Arrays array = new Arrays();
		array.setArray1(arr1);
		array.setArray2(arr2);
		array.setArray3(arr3);
		return array;
	}
	
	public Arrays getArraysJsonWithNull(){
		Integer[] arr1 = null;
		Integer[] arr2 = null;
		Integer[] arr3 = null;
		
		Arrays array = new Arrays();
		array.setArray1(arr1);
		array.setArray2(arr2);
		array.setArray3(arr3);
		return array;
	}
	
	 public FinalArray getFinalArray (Arrays arrayJson){
		 TreeSet<Integer> hashedArray = new TreeSet<Integer>();
		 Integer arrayOne[] = arrayJson.getArray1();
		 Integer arrayTwo[] = arrayJson.getArray2();
		 Integer arrayThree[] = arrayJson.getArray3();
		 
			if (arrayOne == null && arrayTwo == null && arrayThree == null)
		    {
				return null;
			}
			if(arrayOne != null){
				for (int entry : arrayOne) {
					hashedArray.add(entry);
				}
			}
			if(arrayTwo != null){
				for (int entry : arrayTwo) {
					hashedArray.add(entry);
				}
			}
			if(arrayThree != null){
				for (int entry : arrayThree) {
					hashedArray.add(entry);
				}
			}
			FinalArray finalArray = new FinalArray();
			finalArray.setMergedArray(hashedArray.toArray(new Integer[0]));
			return finalArray;
	 }

}
