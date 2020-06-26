
package com.sorec.concentrateur.offre.process;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.sorec.concentrateur.offre.service.dto.BoundedContextDto;
import com.sorec.concentrateur.offre.service.dto.CourseDto;
import com.sorec.concentrateur.offre.service.dto.PartantDto;
import com.sorec.concentrateur.offre.service.dto.ProduitInCourseDto;



public interface OffreProcess {
	
	    BoundedContextDto get(@NotNull Integer id);
	    PartantDto getPartant(@NotNull Integer id);
	    CourseDto  getCourse(@NotNull Integer id);
	    ProduitInCourseDto getProduitInCourse(@NotNull Integer id);
	       
	    List<CourseDto>  getCourses();
	

}