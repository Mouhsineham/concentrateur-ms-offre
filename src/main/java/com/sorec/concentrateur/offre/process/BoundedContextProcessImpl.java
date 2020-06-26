package com.sorec.concentrateur.offre.process;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorec.concentrateur.framework.i18n.CustomMessageSource;
import com.sorec.concentrateur.offre.service.BoundedContextService;

import com.sorec.concentrateur.offre.service.dto.BoundedContextDto;


import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
public class BoundedContextProcessImpl implements BoundedContextProcess {

    private static final String DEFAULT_COLUMN_DELIMITER = "; ";

  

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    BoundedContextService boundedContextService;

    @Autowired
    CustomMessageSource customMessageSource;
    
  


	@Override
	public BoundedContextDto get(@NotNull Integer id) {
		return BoundedContextDto.from(boundedContextService.get(id));
	}
   }
