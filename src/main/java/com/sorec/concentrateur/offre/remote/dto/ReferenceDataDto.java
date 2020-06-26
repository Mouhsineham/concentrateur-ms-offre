package com.sorec.concentrateur.offre.remote.dto;

import javax.validation.constraints.NotNull;

import com.sorec.concentrateur.framework.i18n.service.dto.I18nTextDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReferenceDataDto {

    private Integer id;

    @NotNull
    private I18nTextDto i18nText;
}
