package com.sorec.concentrateur.offre.service.dto;

import java.util.Objects;

import com.sorec.concentrateur.offre.domain.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import javax.validation.Valid;


/**
 * CourseDto
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto   {

  @Builder.Default
  @ApiModelProperty(value = "idReunion")
  private Integer idReunion = null;
 
  @Builder.Default
  @ApiModelProperty(value = "idCourse")
  private Integer idCourse = null;
  
  @Builder.Default
  @ApiModelProperty(value = "codeReunion")
  private String codeReunion = null;
  
  @Builder.Default
  @ApiModelProperty(value = "codeCourse")
  private String codeCourse = null;
  
  @Builder.Default
  @ApiModelProperty(value = "nomHypodrome")
  private String nomHypodrome = null;
  
  @Builder.Default
  @ApiModelProperty(value = "typeCourse")
  private String typeCourse = null;
  
  @Builder.Default
  @ApiModelProperty(value = "nbrePartants")
  private BigDecimal nbrePartants = null;
  
  
  @Builder.Default
  @ApiModelProperty(value = "listeProduits")
  private ProduitInCourseDto listeProduitsInCourse = null;

  public CourseDto idReunion(Integer idReunion) {
    this.idReunion = idReunion;
    return this;
  }
  
  
  public static CourseDto from(Course model) {
	  CourseDtoBuilder builder = CourseDto.builder()
              .idCourse(model.getIdCourse())
              .codeCourse(model.getCodeCourse());
              
      return builder.build();
  }

  public static Course to(Course from) {
	  Course entity = new Course();
  	//....
      return entity;
  }

  public static void copy(CourseDto from, Course to) {
      to.setIdCourse(from.getIdCourse());
      // ...
  }

}


