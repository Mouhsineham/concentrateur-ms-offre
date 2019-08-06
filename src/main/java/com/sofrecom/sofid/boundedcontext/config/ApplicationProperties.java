package com.sofrecom.sofid.boundedcontext.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to BoundedContext.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link com.sofrecom.sofid.boundedcontext.config.SofidProperties} for a good example.
 */
@Data
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

  
}
