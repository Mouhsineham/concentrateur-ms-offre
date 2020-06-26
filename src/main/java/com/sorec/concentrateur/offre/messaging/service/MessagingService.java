package com.sorec.concentrateur.offre.messaging.service;

import com.sorec.concentrateur.offre.messaging.dto.BoundedContextEventDTO;

/**
 * Messaging notification service used to send message to other micro-services through a queue
 */
public interface MessagingService {

    void notify(BoundedContextEventDTO event);

}
