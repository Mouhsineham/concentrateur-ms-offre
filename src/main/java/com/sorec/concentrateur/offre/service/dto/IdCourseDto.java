package com.sorec.concentrateur.offre.service.dto;

import java.util.Objects;
 
 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
 
import javax.validation.Valid;
 

/**
 * IdCourseDto
 */
@ApiModel(value = "ReferenceDataTypeDto", description = "A data transfer object to expose the reference data type entity details")
@Valid
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdCourseDto   {
  @ApiModelProperty(value = "IdCourse")
  private BigDecimal idCourse = null;

  public IdCourseDto idCourse(BigDecimal idCourse) {
    this.idCourse = idCourse;
    return this;
  }

  /**
   * Get idCourse
   * @return idCourse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getIdCourse() {
    return idCourse;
  }

  public void setIdCourse(BigDecimal idCourse) {
    this.idCourse = idCourse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdCourseDto idCourseDto = (IdCourseDto) o;
    return Objects.equals(this.idCourse, idCourseDto.idCourse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCourse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdCourseDto {\n");
    
    sb.append("    idCourse: ").append(toIndentedString(idCourse)).append("\n");
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

