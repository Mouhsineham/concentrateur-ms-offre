package com.sorec.concentrateur.offre.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import lombok.Data;


/**
 * The persistent class for the course database table.
 * 
 */

@Valid
@Data
@Entity
@Table(name="course")
public class Course implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3317330294372608797L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCourse;

	private String codeCourse;

	@Temporal(TemporalType.DATE)
	private Date dateCourse;

	@Temporal(TemporalType.TIMESTAMP)
	private Date heureCourse;

	private String statusCourse;

	//bi-directional many-to-one association to Chevaux
	@OneToMany(mappedBy="course")
	private Set<Partant> partants;

	//bi-directional many-to-one association to Reunion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDREUNION")
	private Reunion reunion;

	public Partant addChevaux(Partant chevaux) {
		getPartants().add(chevaux);
		chevaux.setCourse(this);

		return chevaux;
	}

	public Partant removeChevaux(Partant chevaux) {
		getPartants().remove(chevaux);
		chevaux.setCourse(null);

		return chevaux;
	}

}