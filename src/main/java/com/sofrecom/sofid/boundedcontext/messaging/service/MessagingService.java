package com.sofrecom.sofid.boundedcontext.messaging.service;

import com.sofrecom.sofid.boundedcontext.messaging.dto.BoundedContextEventDTO;

/**
 * Messaging notification service used to send message to other micro-services through a queue
 * @author sofid@sofrecom.com
 */
public interface MessagingService {

    void notify(BoundedContextEventDTO event);

}
