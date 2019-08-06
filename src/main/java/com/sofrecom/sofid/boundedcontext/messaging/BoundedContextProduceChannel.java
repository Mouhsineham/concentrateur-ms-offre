package com.sofrecom.sofid.boundedcontext.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BoundedContextProduceChannel {

	@Output("boundedContextChannel-out")
	MessageChannel outboundBoundedContextChannel();
}
