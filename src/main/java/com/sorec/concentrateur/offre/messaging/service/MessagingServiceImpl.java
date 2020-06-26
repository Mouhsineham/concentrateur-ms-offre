package com.sorec.concentrateur.offre.messaging.service;
/*
 * package com.sorec.concentrateur.boundedcontext.messaging.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.messaging.MessageChannel; import
 * org.springframework.messaging.MessageHeaders; import
 * org.springframework.messaging.support.MessageBuilder; import
 * org.springframework.stereotype.Service; import
 * org.springframework.util.MimeTypeUtils;
 * 
 * import
 * com.sorec.concentrateur.boundedcontext.messaging.BoundedContextProduceChannel;
 * import
 * com.sorec.concentrateur.boundedcontext.messaging.dto.BoundedContextEventDTO;
 * 
 *//**
	 * Service used for sending events through messaging queue.
	 *
	 *//*
		 * 
		 * @Service public class MessagingServiceImpl implements MessagingService {
		 * 
		 * 
		 * private MessageChannel boundedContextChannel;
		 * 
		 * public MessagingServiceImpl(@Autowired final BoundedContextProduceChannel
		 * userChannel) { this.boundedContextChannel =
		 * userChannel.outboundBoundedContextChannel(); }
		 * 
		 * @Override public void notify(BoundedContextEventDTO event) {
		 * boundedContextChannel.send(MessageBuilder.withPayload(event).setHeader(
		 * MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build()); }
		 * 
		 * }
		 */