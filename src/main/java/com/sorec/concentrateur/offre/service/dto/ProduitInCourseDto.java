package com.sorec.concentrateur.offre.service.dto;
import java.util.Objects; 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import com.sorec.concentrateur.offre.domain.ProduitInCourse;



/**
 * ProduitInCourseDto
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitInCourseDto   {
	
  private Integer idProduitIncourse;
	
  private Long idProduit;

  private Long codeProduit;
  
  private Long idCourse;
  
  private String statusProduit;

  public ProduitInCourseDto idProduitIncourse(Integer idProduitIncourse) {
    this.idProduitIncourse = idProduitIncourse;
    return this;
  }
 
  

  
  public static ProduitInCourseDto from(ProduitInCourse model) {
	  ProduitInCourseDtoBuilder builder = ProduitInCourseDto.builder()
              .idProduitIncourse(model.getIdProduitIncourse())
              .idProduit(model.getIdProduit())
              .idCourse(model.getIdCourse())
              .statusProduit(model.getStatusProduit());
      return builder.build();
  }

  public static ProduitInCourse to(ProduitInCourse from) {
	  ProduitInCourse entity = new ProduitInCourse();
  	//....
      return entity;
  }

  public static void copy(ProduitInCourseDto from, ProduitInCourse to) {
      to.setIdProduitIncourse(from.getIdProduitIncourse());
      // ...
  } 
  
}



  