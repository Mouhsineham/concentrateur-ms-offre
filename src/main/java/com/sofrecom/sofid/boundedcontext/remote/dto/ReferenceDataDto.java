package com.sofrecom.sofid.boundedcontext.remote.dto;

import com.sofrecom.sofid.framework.i18n.service.dto.I18nTextDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReferenceDataDto {

    private Integer id;

    @NotNull
    private I18nTextDto i18nText;
}
