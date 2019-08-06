package com.sofrecom.sofid.boundedcontext.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.sofrecom.sofid.boundedcontext.messaging.BoundedContextProduceChannel;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding( BoundedContextProduceChannel.class)
public class MessagingConfiguration {
	
}
