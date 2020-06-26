package com.sorec.concentrateur.offre.service;


import static com.sorec.concentrateur.offre.exception.CourseException.Error.COURSE_NOT_FOUND;
import static com.sorec.concentrateur.offre.exception.PartantException.Error.PARTANT_NOT_FOUND;
import static com.sorec.concentrateur.offre.exception.ProduitInCourseException.Error.PRODUIT_NOT_FOUND;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorec.concentrateur.offre.domain.Course;
import com.sorec.concentrateur.offre.domain.Partant;
import com.sorec.concentrateur.offre.domain.ProduitInCourse;
import com.sorec.concentrateur.offre.exception.CourseException;
import com.sorec.concentrateur.offre.exception.PartantException;
import com.sorec.concentrateur.offre.exception.ProduitInCourseException;
import com.sorec.concentrateur.offre.repository.CourseRepository;
import com.sorec.concentrateur.offre.repository.PartantRepository;
import com.sorec.concentrateur.offre.repository.ProduitInCourseRepository;


@Service
@Transactional
public class OffreServiceImpl implements OffreService{
	
	
    @Autowired
    PartantRepository partantRepository;
    
    @Autowired
    ProduitInCourseRepository produitRepository;
    
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Partant getPartant(@NotNull Integer id) {
        Optional<Partant> partant = partantRepository.findById(id);
        if (!partant.isPresent()) {
            throw new PartantException(PARTANT_NOT_FOUND);
        }
        return partant.get();
    }


	@Override
	public Course getCourse(@NotNull Integer id) {
		 Optional<Course> course = courseRepository.findById(id);
		 if(!course.isPresent()) {
			 throw new CourseException(COURSE_NOT_FOUND);
		 }
		return course.get();
	}

	@Override
	public ProduitInCourse getProduitInCourse(@NotNull Integer id) {
		Optional<ProduitInCourse> produit = produitRepository.findById(id);
		if(!produit.isPresent()) {
			throw new ProduitInCourseException(PRODUIT_NOT_FOUND);
		}
		return produit.get();
	}


	@Override
	public List<Course> getCourses() {
		
		List<Course> courses  = courseRepository.findAll();
		if(courses.isEmpty()) {
			throw new ProduitInCourseException(PRODUIT_NOT_FOUND);
		}
		return courses;
	}








}
