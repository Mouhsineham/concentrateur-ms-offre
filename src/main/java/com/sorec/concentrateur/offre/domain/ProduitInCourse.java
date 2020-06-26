package com.sorec.concentrateur.offre.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.Data;


/**
 * CourseEntity
 */
@Valid
@Data
@Entity
@Table(name = "produitInCourse")
public class ProduitInCourse implements Serializable{
  /**
	 * 
	 */
  private static final long serialVersionUID = -1167529376857295915L;
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idProduitIncourse;
  
  private Long idProduit;
  
  private Long idCourse;
  
  private String statusProduit;


}

