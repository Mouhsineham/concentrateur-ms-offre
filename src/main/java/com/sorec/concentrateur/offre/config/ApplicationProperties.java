package com.sorec.concentrateur.offre.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * Properties specific to Offre.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */
@Data
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

  
}
