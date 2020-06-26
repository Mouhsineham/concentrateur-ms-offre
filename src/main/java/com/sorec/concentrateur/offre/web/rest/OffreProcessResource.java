package com.sorec.concentrateur.offre.web.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorec.concentrateur.offre.process.OffreProcess;
import com.sorec.concentrateur.offre.service.dto.PartantDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


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

    @GetMapping(value = "{id:[0-9]+}")
    public ResponseEntity<PartantDto> get(@NotNull @PathVariable("id") Integer id) {
    	return ResponseEntity.ok(offreProcess.getPartant(id));
    }
    
  

}






















