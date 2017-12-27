package com.demo.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * FinalArray
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T09:43:56.688Z")

public class FinalArray implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1412802177839911062L;

	@JsonProperty("MergedArray")
	private Integer[] mergedArray = null;

	public FinalArray mergedArray(Integer[] mergedArray) {
		this.mergedArray = mergedArray;
		return this;
	}

	/**
	 * Get mergedArray
	 * 
	 * @return mergedArray
	 **/
	@ApiModelProperty(value = "")

	public Integer[] getMergedArray() {
		return mergedArray;
	}

	public void setMergedArray(Integer[] mergedArray) {
		this.mergedArray = mergedArray;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FinalArray finalArray = (FinalArray) o;
		return Objects.equals(this.mergedArray, finalArray.mergedArray);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mergedArray);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FinalArray {\n");

		sb.append("    mergedArray: ").append(toIndentedString(mergedArray)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
