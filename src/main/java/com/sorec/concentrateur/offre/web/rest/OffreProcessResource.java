package com.sorec.concentrateur.offre.web.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    
    @GetMapping(value = "partant/{id:[0-9]+}")
    public ResponseEntity<PartantDto> getPartant(@NotNull @PathVariable("id") Integer id) {
    	return ResponseEntity.ok(offreProcess.getPartant(id));
    }
    
    //gestion de course
    @GetMapping("/courses")
    public  ResponseEntity<Object> getCourses() {
    	return new ResponseEntity<Object>(offreProcess.getCourses(), HttpStatus.OK);
    	
    }
    
    @PostMapping("/courses/course")
    public ResponseEntity<CourseDto> addCourse(@NotNull @RequestBody CourseDto coursedto) {
    	CourseDto courseDto = offreProcess.addCourse(coursedto);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }
    
    @PutMapping("/courses/{id:[0-9]+}")
    public ResponseEntity<CourseDto> updateCourse(@NotNull @RequestBody CourseDto course,@NotNull @PathVariable("id") Integer id) {   	
    	course.setIdCourse(id);
    	CourseDto coursee = offreProcess.addCourse(course);
        return new ResponseEntity<>(coursee, HttpStatus.OK);
    }
    
    @GetMapping("/courses/{id:[0-9]+}")
    public ResponseEntity<Object> getCourse(@NotNull @PathVariable("id") Integer id) {
    	
    	CourseDto course = offreProcess.getCourse(id);
    	
        return new ResponseEntity<>(course, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/{id}")
    public  void  deleteOrderById(@PathVariable("id") Integer id){
    	offreProcess.deleteCourse(id);
    }
    
    
    
     
}
























