package com.demo.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Arrays
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T09:43:56.688Z")

public class Arrays  implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = -2948434562870113748L;

@JsonProperty("Array1")
  private Integer[] array1 = null;

  @JsonProperty("Array2")
  private Integer[] array2 = null;

  @JsonProperty("Array3")
  private Integer[] array3 = null;

  public Arrays array1(Integer[] array1) {
    this.array1 = array1;
    return this;
  }

   /**
   * Get array1
   * @return array1
  **/
  @ApiModelProperty(value = "")


  public Integer[] getArray1() {
    return array1;
  }

  public void setArray1(Integer[] array1) {
    this.array1 = array1;
  }

  public Arrays array2(Integer[] array2) {
    this.array2 = array2;
    return this;
  }

   /**
   * Get array2
   * @return array2
  **/
  @ApiModelProperty(value = "")


  public Integer[] getArray2() {
    return array2;
  }

  public void setArray2(Integer[] array2) {
    this.array2 = array2;
  }

  public Arrays array3(Integer[] array3) {
    this.array3 = array3;
    return this;
  }

   /**
   * Get array3
   * @return array3
  **/
  @ApiModelProperty(value = "")


  public Integer[] getArray3() {
    return array3;
  }

  public void setArray3(Integer[] array3) {
    this.array3 = array3;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Arrays arrays = (Arrays) o;
    return Objects.equals(this.array1, arrays.array1) &&
        Objects.equals(this.array2, arrays.array2) &&
        Objects.equals(this.array3, arrays.array3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(array1, array2, array3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Arrays {\n");
    
    sb.append("    array1: ").append(toIndentedString(array1)).append("\n");
    sb.append("    array2: ").append(toIndentedString(array2)).append("\n");
    sb.append("    array3: ").append(toIndentedString(array3)).append("\n");
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

