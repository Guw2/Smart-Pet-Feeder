package com.lorian.sensor_service.petDetection;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.lorian.sensor_service.petDetection.dtos.PetDetectionGetDTO;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionPostDTO;

@Component
public class PetDetectionMapper {

	// Converts postDTO to entity
	public static PetDetection postDtoToPetDetection(PetDetectionPostDTO dto) {
		// Stores a new PetDetection
		PetDetection petDetection = new PetDetection();
		
		// Transfers all the info inside DTO to PetDetection
		petDetection.setPetId(dto.petId());
		petDetection.setSensorLocation(dto.sensorLocation());
		petDetection.setDetectedAt(Instant.now());
		
		// Returns it
		return petDetection;
	}
	
	// Converts entity to getDTO
	public static PetDetectionGetDTO petDetectionToGetDto(PetDetection detection) {
		// Creates a new PetDetectionGetDTO with all the info passed as a parameter
		PetDetectionGetDTO petDetectionGetDTO = new PetDetectionGetDTO
				(
						detection.getId(),
						detection.getPetId(),
						detection.getSensorLocation(),
						detection.getDetectedAt()
				);
		
		// Returns it
		return petDetectionGetDTO;
	}
	
}
