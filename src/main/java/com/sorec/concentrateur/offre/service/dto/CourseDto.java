package com.sorec.concentrateur.offre.service.dto;

 

import com.sorec.concentrateur.offre.domain.Course;


import io.swagger.annotations.ApiModelProperty;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.*;

 


/**
 * CourseDto
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto   {


  @ApiModelProperty(value = "idReunion")
  private Integer idReunion;
 

  @ApiModelProperty(value = "idCourse")
  private Integer idCourse;
  

  @ApiModelProperty(value = "codeReunion")
  private String codeReunion ;
  

  @ApiModelProperty(value = "codeCourse")
  private String codeCourse;

  @ApiModelProperty(value = "nomHypodrome")
  private String nomHypodrome;
  

  @ApiModelProperty(value = "typeCourse")
  private String typeCourse ;
  
 
  @ApiModelProperty(value = "nbrePartants")
  private BigDecimal nbrePartants ;
  
  private Date dateCourse;

  private Date heureCourse;

  private String statusCourse;
  
  private Set<PartantDto> partants;
  
  
 
  @ApiModelProperty(value = "listeProduits")
  private ProduitInCourseDto listeProduitsInCourse;

  public CourseDto idReunion(Integer idReunion) {
    this.idReunion = idReunion;
    return this;
  }
  
  
  public static CourseDto from(Course model) {
	  CourseDtoBuilder builder = CourseDto.builder()
              .idCourse(model.getIdCourse())
              .codeCourse(model.getCodeCourse())
              .dateCourse(model.getDateCourse())
              .heureCourse(model.getHeureCourse()) 
              .codeCourse(model.getCodeCourse());
	  
              
      return builder.build();
  }

  public static Course to(CourseDto from) {
	  Course entity = new Course();
	  entity.setIdCourse(from.idCourse);
	  entity.setCodeCourse(from.codeCourse);
	  entity.setDateCourse(from.dateCourse);
	  entity.setHeureCourse(from.heureCourse);
	  from.partants.forEach(partant -> {
		  entity.getPartants().add(PartantDto.to(partant));
	  });
	  entity.setReunion(null);
	  entity.setStatusCourse(from.statusCourse);
	 
	 
	
      return entity;
  }

  public static void copy(CourseDto from, Course to) {
      to.setIdCourse(from.getIdCourse());
      // ...
  }
  
  
  public static List<CourseDto> mapCoursesResponse(List<Course> courses) {
      if ( courses == null ) {
          return null;
      }

      List<CourseDto> list = new ArrayList<CourseDto>( courses.size() );
      for ( Course course : courses ) {
          list.add( from( course ) );
      }
      return list;
      
  }

}


