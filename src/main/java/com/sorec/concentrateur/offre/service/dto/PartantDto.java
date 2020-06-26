package com.sorec.concentrateur.offre.service.dto;



import javax.validation.Valid;

import com.sorec.concentrateur.offre.domain.Partant;
 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * PartantDto
 */
@ApiModel(value = "ReferenceDataTypeDto", description = "A data transfer object to expose the reference data type entity details")
@Valid
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartantDto   {
	


  private boolean estPartantCheval;	
  
  @ApiModelProperty(value = "idPartant")
  private Integer idPartant;

  @ApiModelProperty(value = "numPartant")
  private String numPartant;

  @ApiModelProperty(value = "nomPartant")
  private String nomPartant;

  @ApiModelProperty(value = "ecurie")
  private Boolean ecurie;

  @ApiModelProperty(value = "ecurieFg")
  private Integer ecurieFg;

  public PartantDto idPartant(Integer idPartant) {
    this.idPartant = idPartant;
    return this;
  }
 

  public static PartantDto from(Partant model) {
	  PartantDtoBuilder builder = PartantDto.builder()
              .idPartant(model.getIdPartant())
              .nomPartant(model.getNomPartant())
              .ecurie(model.isEcurie())
              .ecurieFg(model.getEcurieFg());
      return builder.build();
  }

  public static Partant to(Partant from) {
	  Partant entity = new Partant();
  	//....
      return entity;
  }

  public static void copy(PartantDto from, Partant to) {
      to.setIdPartant(from.getIdPartant());
      // ...
  }
 







}

