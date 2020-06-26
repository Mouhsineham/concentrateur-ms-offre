
package com.sorec.concentrateur.offre.process;
import javax.validation.constraints.NotNull;

import com.sorec.concentrateur.offre.service.dto.BoundedContextDto;
import com.sorec.concentrateur.offre.service.dto.CourseDto;
import com.sorec.concentrateur.offre.service.dto.PartantDto;
import com.sorec.concentrateur.offre.service.dto.ProduitInCourseDto;



public interface BoundedContextProcess {
	
	    BoundedContextDto get(@NotNull Integer id);

	

}