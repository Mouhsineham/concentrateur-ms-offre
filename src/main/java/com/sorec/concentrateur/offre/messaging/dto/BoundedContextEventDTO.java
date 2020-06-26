package com.sorec.concentrateur.offre.messaging.dto;

import java.util.Map;

import com.sorec.concentrateur.framework.eventsourcing.EventDTO;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * BoundedContext Event DTO class used to exchange boundedcontext field values between micro-services through a queue.
 *
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
