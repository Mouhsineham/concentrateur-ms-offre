package com.sorec.concentrateur.offre.service.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sorec.concentrateur.offre.domain.BoundedContext;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ReferenceDataTypeDto", description = "A data transfer object to expose the reference data type entity details")
@Valid
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoundedContextDto {

    @ApiModelProperty(value = "BoundedContext ID")
    private Integer id;

    @ApiModelProperty(value = "BoundedContext username", required = true)
    @NotNull
    private String username;

    @ApiModelProperty(value = "BoundedContext password")
    private String password;


    public static BoundedContextDto from(BoundedContext model) {
    	BoundedContextDtoBuilder builder = BoundedContextDto.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword());
        return builder.build();
    }

    public static BoundedContext to(BoundedContext from) {
    	BoundedContext entity = new BoundedContext();
    	//....
        return entity;
    }

    public static void copy(BoundedContextDto from, BoundedContext to) {
        to.setId(from.getId());
        // ...
    }
}
