package com.sorec.concentrateur.offre.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import lombok.Data;


/**
 * The persistent class for the reunion database table.
 * 
 */

@Valid
@Data
@Entity
@Table(name = "reunion")
public class Reunion implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7350882905402206521L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idReunion;

	private String codeReunion;

	@Temporal(TemporalType.DATE)
	private Date dateReunion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date heureDemarrageReunion;

	private Long idHypodromeDeroulement;

	private Long idHypodromeOrganisateur;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="reunion")
	private Set<Course> courses;


	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setReunion(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setReunion(null);

		return cours;
	}

}