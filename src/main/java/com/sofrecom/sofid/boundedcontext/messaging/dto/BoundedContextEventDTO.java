package com.sofrecom.sofid.boundedcontext.messaging.dto;

import java.util.Map;

import com.sofrecom.sofid.framework.eventsourcing.EventDTO;
import com.sofrecom.sofid.boundedcontext.domain.BoundedContext;

import io.swagger.annotations.ApiModel;
import lombok.*;

/**
 * BoundedContext Event DTO class used to exchange boundedcontext field values between micro-services through a queue.
 *
 * @author Sofrecom
 * @version 1.0
 */
@ApiModel(description = "BoundedContextEventDTO")
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundedContextEventDTO extends EventDTO {
	/**
	 * id: identifiant
	 */
	private Integer id;
	/**
	 * atributes: map des atributes
	 */
	private Map<String, Object> attributes;

}
