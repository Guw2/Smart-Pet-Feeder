package com.lorian.sensor_service.petDetection;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.lorian.sensor_service.petDetection.dtos.PetDetectionGetDTO;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionPostDTO;

@Component
public class PetDetectionMapper {

	public static PetDetection postDtoToPetDetection(PetDetectionPostDTO dto) {
		PetDetection petDetection = new PetDetection();
		
		petDetection.setPetId(dto.petId());
		petDetection.setSensorLocation(dto.sensorLocation());
		petDetection.setDetectedAt(Instant.now());
		
		return petDetection;
	}
	
	public static PetDetectionGetDTO petDetectionToGetDto(PetDetection detection) {
		PetDetectionGetDTO petDetectionGetDTO = new PetDetectionGetDTO
				(
						detection.getId(),
						detection.getPetId(),
						detection.getSensorLocation(),
						detection.getDetectedAt()
				);
		
		return petDetectionGetDTO;
	}
	
}
