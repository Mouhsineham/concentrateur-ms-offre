package com.sorec.concentrateur.offre.web.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorec.concentrateur.offre.process.OffreProcess;
import com.sorec.concentrateur.offre.service.dto.CourseDto;
import com.sorec.concentrateur.offre.service.dto.PartantDto;


@RequestMapping(value = "/api/v1/offre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class OffreProcessResource  {
    /**
     * OffreProcess process dependency.
     */
    private OffreProcess offreProcess;


   

    public OffreProcessResource(@Autowired OffreProcess offreProcess) {
        this.offreProcess = offreProcess;
    }

    
    @GetMapping(value = "courses/{id:[0-9]+}")
    public ResponseEntity<PartantDto> getPartant(@NotNull @PathVariable("id") Integer id) {
    	return ResponseEntity.ok(offreProcess.getPartant(id));
    }
    
    //get Courses
    @GetMapping("/courses")
    public  ResponseEntity<Object> getCourses() {
    	return new ResponseEntity<Object>(offreProcess.getCourses(), HttpStatus.OK);
    	
    }
    
    
   
    
  

}






















