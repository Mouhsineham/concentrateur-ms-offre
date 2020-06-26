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
 * CoursesDto
 */
@ApiModel(value = "ReferenceDataTypeDto", description = "A data transfer object to expose the reference data type entity details")
@Valid
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDto   {
  @ApiModelProperty(value = "listeCourse")
  @Valid
  private List<CourseDto> listeCourse = null;

  public CoursesDto listeCourse(List<CourseDto> listeCourse) {
    this.listeCourse = listeCourse;
    return this;
  }

  public CoursesDto addListeCourseItem(CourseDto listeCourseItem) {
    if (this.listeCourse == null) {
      this.listeCourse = new ArrayList<CourseDto>();
    }
    this.listeCourse.add(listeCourseItem);
    return this;
  }

  /**
   * Get listeCourse
   * @return listeCourse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CourseDto> getListeCourse() {
    return listeCourse;
  }

  public void setListeCourse(List<CourseDto> listeCourse) {
    this.listeCourse = listeCourse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoursesDto coursesDto = (CoursesDto) o;
    return Objects.equals(this.listeCourse, coursesDto.listeCourse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listeCourse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoursesDto {\n");
    
    sb.append("    listeCourse: ").append(toIndentedString(listeCourse)).append("\n");
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

