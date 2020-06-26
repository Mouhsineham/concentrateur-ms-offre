package com.sorec.concentrateur.offre.web.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sorec.concentrateur.framework.dto.ErrorMessage;
import com.sorec.concentrateur.offre.domain.BoundedContext;
import com.sorec.concentrateur.offre.process.BoundedContextProcess;
import com.sorec.concentrateur.offre.service.dto.BoundedContextDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Api(tags = "API Resource: BoundedContext")
@ApiModel(value = "BoundedContexts Controller", description = "REST Controller for managing users")
@RequestMapping(value = "/api/v1/boundedContext", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class BoundedContextProcessResource  {

    /**
     * OffreProcess process dependency.
     */

    private BoundedContextProcess boundedContextProcess;

   

    public BoundedContextProcessResource(@Autowired BoundedContextProcess boundedContextProcess) {
        this.boundedContextProcess = boundedContextProcess;
    }

    /**
     * Gets a boundedcontext by his identifier.
     *
     * @param id BoundedContext ID
     * @return Retrieved boundedcontext
     */
    @ApiOperation(value = "Get a boundedcontext by his ID", notes = "Retrieves a boundedcontext by his identifier.", response = BoundedContext.class, responseContainer = "ResponseEntity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "BoundedContext retrieved successfully"),
            @ApiResponse(code = 401, message = "Authorization information is missing or invalid", response = ErrorMessage.class),
            @ApiResponse(code = 403, message = "Access token does not have the required scope", response = ErrorMessage.class),
            @ApiResponse(code = 400, message = "Invalid input or Business Exception", response = ErrorMessage.class)})
    @GetMapping(value = "{id:[0-9]+}")
    public ResponseEntity<BoundedContextDto> get(@ApiParam(value = "The cheval identifier to retrieve", required = true) @NotNull @PathVariable("id") Integer id) {
    	return ResponseEntity.ok(boundedContextProcess.get(id));
    }

}