package com.sorec.concentrateur.offre.service.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ListIdCoursesDto
 */
@ApiModel(value = "ReferenceDataTypeDto", description = "A data transfer object to expose the reference data type entity details")
@Valid
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListIdCoursesDto   {
  @ApiModelProperty(value = "listIdCourses")
  @Valid
  private List<IdCourseDto> listIdCourses = null;

  public ListIdCoursesDto listIdCourses(List<IdCourseDto> listIdCourses) {
    this.listIdCourses = listIdCourses;
    return this;
  }

  public ListIdCoursesDto addListIdCoursesItem(IdCourseDto listIdCoursesItem) {
    if (this.listIdCourses == null) {
      this.listIdCourses = new ArrayList<IdCourseDto>();
    }
    this.listIdCourses.add(listIdCoursesItem);
    return this;
  }

  /**
   * Get listIdCourses
   * @return listIdCourses
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<IdCourseDto> getListIdCourses() {
    return listIdCourses;
  }

  public void setListIdCourses(List<IdCourseDto> listIdCourses) {
    this.listIdCourses = listIdCourses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListIdCoursesDto listIdCoursesDto = (ListIdCoursesDto) o;
    return Objects.equals(this.listIdCourses, listIdCoursesDto.listIdCourses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listIdCourses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListIdCoursesDto {\n");
    
    sb.append("    listIdCourses: ").append(toIndentedString(listIdCourses)).append("\n");
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

