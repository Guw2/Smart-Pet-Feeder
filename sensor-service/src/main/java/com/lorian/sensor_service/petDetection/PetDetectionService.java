package com.lorian.sensor_service.petDetection;

import java.util.List;

import org.springframework.amqp.AmqpException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionGetDTO;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionPostDTO;
import com.lorian.sensor_service.producer.SensorProducer;

@Service
public class PetDetectionService {

	private final PetDetectionRepository repo;
	private final SensorProducer producer;
	
	// Constructor Injection
	public PetDetectionService(PetDetectionRepository repo, SensorProducer producer) {
		this.repo = repo;
		this.producer = producer;
	}

	// Get all detections from database
	public List<PetDetectionGetDTO> getAllDetections(){
		// Return a findAll() already mapped so 'PetDetection' get converted to 'PetDetectionGetDTO'
		return repo.findAll().stream().map(x -> PetDetectionMapper.petDetectionToGetDto(x)).toList();
	}
	
	// Insert a new detection and calls the producer
	public PetDetectionGetDTO insertDetection(PetDetectionPostDTO dto) {
		try {
			// Calls producer
			producer.activateSensor(dto);
			// Convert 'PetDetectionPostDTO' to 'PetDetection'
			PetDetection petDetection = PetDetectionMapper.postDtoToPetDetection(dto);
			// Return a PetDetectionGetDTO from persisting the entity in database and converting 'PetDetection' to a getDTO
			return PetDetectionMapper.petDetectionToGetDto(repo.save(petDetection));
		} catch (Exception e) {
			// Throws an exception on error
			throw new RuntimeException(e);
		} 
	}
	
}
