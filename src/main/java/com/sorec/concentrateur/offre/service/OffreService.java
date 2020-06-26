package com.sorec.concentrateur.offre.service;


import javax.validation.constraints.NotNull;
import com.sorec.concentrateur.offre.domain.Course;
import com.sorec.concentrateur.offre.domain.Partant;
import com.sorec.concentrateur.offre.domain.ProduitInCourse;



public interface OffreService {


    Partant getPartant(@NotNull Integer id);
    Course  getCourse(@NotNull Integer id);
    ProduitInCourse getProduitInCourse(@NotNull Integer id);


    
}
