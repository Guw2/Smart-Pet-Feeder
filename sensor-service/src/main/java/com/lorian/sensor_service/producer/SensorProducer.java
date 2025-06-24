package com.lorian.sensor_service.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionPostDTO;

@Component
public class SensorProducer {

	private final AmqpTemplate amqpTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public SensorProducer(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
	
	public void activateSensor(PetDetectionPostDTO dto) throws JsonProcessingException, AmqpException {
		amqpTemplate.convertAndSend(
					"pet-events-exchange",
					"pet-feeder-routing-key",
					objectMapper.writeValueAsString(dto)
				);
	}
	
}
