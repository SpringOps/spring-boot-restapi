package com.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.service.TriangleTypeService;
import com.demo.web.rest.errors.CustomValidationException;
import com.demo.web.rest.errors.ErrorConstants;

/**
 * Service Implementation to check for triangle type based its edges.
 */
@Service
@Transactional
public class TriangleTypeServiceImpl implements TriangleTypeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TriangleTypeServiceImpl.class);

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
	@Override
	public String findTriangleType(Integer sideALength, Integer sideBLength, Integer sideCLength) {
		LOGGER.info("Going to find the triangle type ");
		if (sideALength <= 0 || sideBLength <= 0 || sideCLength <= 0)
	      {
			LOGGER.error("Triangle sides are 0 or nagetive");
	        throw new CustomValidationException("TriangleSide", ErrorConstants.TRIANGLE_SIDE_INVALID_CODE, ErrorConstants.TRIANGLE_SIDE_INVALID_MESSAGE);
	      }
		if (!this.isExistentTriangle(sideALength, sideBLength, sideCLength)) {
			LOGGER.info("Triangle type is  ", TriangleType.ERROR.getShape());
			return TriangleType.ERROR.getShape();
		} else if (this.isEquilateralType(sideALength, sideBLength, sideCLength)) {
			LOGGER.info("Triangle type is ", TriangleType.EQUILATERAL.getShape());
			return TriangleType.EQUILATERAL.getShape();
		} else if (this.isScaleneType(sideALength, sideBLength, sideCLength)) {
			LOGGER.info("Triangle type ", TriangleType.SCALENE.getShape());
			return TriangleType.SCALENE.getShape();
		} else if (this.isIsoscelesType(sideALength, sideBLength, sideCLength)) {
			LOGGER.info("Triangle type ", TriangleType.ISOSCELES.getShape());
			return TriangleType.ISOSCELES.getShape();
		} else {
			return "Not Found";
		}

	}

	/**
	 * This method is used to check for Existent Triangle type based its edges.
	 * 
	 * @param Integer a
	 * @param Integer b
	 * @param Integer c
	 * 
	 * @return boolean ,true/false
	 *
	 */
	private boolean isExistentTriangle(int a, int b, int c) {
		boolean triangleExist = true;

		// All sides must have positive length.
		if (a <= 0 || b <= 0 || c <= 0) {
			triangleExist = false;
		}
		// The sum of the lengths of any two sides of a triangle must be greater
		// than the length of the third side for non-degenerate triangle.
		else if (((long) a + b) <= c) {
			triangleExist = false;
		} else if (((long) a + c) <= b) {
			triangleExist = false;
		} else if (((long) b + c) <= a) {
			triangleExist = false;
		}
		LOGGER.info("existent triagle value is " , triangleExist);
		return triangleExist;
	}

	/**
	 * This method is used to check for Equilateral Triangle type based its edges.
	 * 
	 * @param Integer a
	 * @param Integer b
	 * @param Integer c
	 * 
	 * @return boolean ,true/false
	 *
	 */
	protected boolean isEquilateralType(int a, int b, int c) {
		LOGGER.info("Checking for equilateral type");
		return (a == b && a == c);
	}

	/**
	 * This method is used to check for Isosceles Triangle type based its edges.
	 * 
	 * @param Integer a
	 * @param Integer b
	 * @param Integer c
	 * 
	 * @return boolean ,true/false
	 *
	 */
	protected boolean isIsoscelesType(int a, int b, int c) {
		LOGGER.info("Checking for Isosceles type");
		return (a == b || a == c || b == c);
	}

	/**
	 * This method is used to check for Scalene Triangle type based its edges.
	 * 
	 * @param Integer a
	 * @param Integer b
	 * @param Integer c
	 * 
	 * @return boolean ,true/false
	 *
	 */
	protected boolean isScaleneType(int a, int b, int c) {
		LOGGER.info("Checking for Scalene type");
		return (a != b && a != c && b != c);
	}

}
