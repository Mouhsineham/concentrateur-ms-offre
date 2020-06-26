package com.sorec.concentrateur.offre.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import lombok.Data;


/**
 * The persistent class for the Partant database table.
 * 
 */

@Valid
@Data
@Entity
@Table(name = "partant")
public class Partant implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7847942416305038685L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPartant;;

	@Temporal(TemporalType.DATE)
	private Date datePartantCheval;

	private boolean estPartantCheval;

	private String nomPartant;

	private Integer numPartant;
	
	private boolean ecurie;

	private Integer ecurieFg;

	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCOURSE")
	private Course course;

}