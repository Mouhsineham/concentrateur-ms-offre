package com.sofrecom.sofid.boundedcontext.process;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofrecom.sofid.boundedcontext.messaging.service.MessagingService;
import com.sofrecom.sofid.boundedcontext.service.BoundedContextService;
import com.sofrecom.sofid.boundedcontext.service.dto.BoundedContextDto;
import com.sofrecom.sofid.framework.i18n.CustomMessageSource;

import lombok.extern.slf4j.Slf4j;

/**
 */

@Slf4j
@Service
@Transactional
public class BoundedContextProcessImpl implements BoundedContextProcess {

    private static final String DEFAULT_COLUMN_DELIMITER = "; ";

  

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    BoundedContextService boundedContextService;

    @Autowired
    CustomMessageSource customMessageSource;

    @Autowired
    MessagingService messagingService;

	@Override
	public BoundedContextDto get(@NotNull Integer id) {
		return BoundedContextDto.from(boundedContextService.get(id));
	}
   }
