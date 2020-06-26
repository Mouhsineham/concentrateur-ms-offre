package com.sorec.concentrateur.offre.process;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorec.concentrateur.framework.i18n.CustomMessageSource;
import com.sorec.concentrateur.offre.domain.Course;
import com.sorec.concentrateur.offre.service.BoundedContextService;
import com.sorec.concentrateur.offre.service.OffreService;
import com.sorec.concentrateur.offre.service.dto.BoundedContextDto;
import com.sorec.concentrateur.offre.service.dto.CourseDto;
import com.sorec.concentrateur.offre.service.dto.PartantDto;
import com.sorec.concentrateur.offre.service.dto.ProduitInCourseDto;

import lombok.extern.slf4j.Slf4j;

/**
 */

@Slf4j
@Transactional
@Service
public class OffreProcessImpl implements OffreProcess {

    private static final String DEFAULT_COLUMN_DELIMITER = "; ";

  

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    BoundedContextService boundedContextService;

    @Autowired
    CustomMessageSource customMessageSource;
    
    @Autowired
    OffreService offreService;

	@Override
	public BoundedContextDto get(@NotNull Integer id) {
		return BoundedContextDto.from(boundedContextService.get(id));
	}


	@Override
	public PartantDto getPartant(@NotNull Integer id) {
		// TODO Auto-generated method stub
		return PartantDto.from(offreService.getPartant(id));
	}

	@Override
	public CourseDto getCourse(@NotNull Integer id) {
		// TODO Auto-generated method stub
		return CourseDto.from(offreService.getCourse(id));
	}

	@Override
	public  ProduitInCourseDto getProduitInCourse(@NotNull Integer id) {
	 	return ProduitInCourseDto.from(offreService.getProduitInCourse(id));
	}


	@Override
	public List<CourseDto> getCourses() {
		// TODO Auto-generated method stub
		return CourseDto.mapCoursesResponse(offreService.getCourses());
	}
	
	
	
   }
