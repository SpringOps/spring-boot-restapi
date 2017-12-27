package com.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Errors
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T09:43:56.688Z")

public class Errors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038618370039644906L;
	@JsonProperty("ErrorList")
	private List<Error> errorList = null;

	public Errors errorList(List<Error> errorList) {
		this.errorList = errorList;
		return this;
	}

	public Errors addErrorListItem(Error errorListItem) {
		if (this.errorList == null) {
			this.errorList = new ArrayList<Error>();
		}
		this.errorList.add(errorListItem);
		return this;
	}

	/**
	 * Get errorList
	 * 
	 * @return errorList
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Error> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<Error> errorList) {
		this.errorList = errorList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Errors errors = (Errors) o;
		return Objects.equals(this.errorList, errors.errorList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Errors {\n");

		sb.append("    errorList: ").append(toIndentedString(errorList)).append("\n");
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
