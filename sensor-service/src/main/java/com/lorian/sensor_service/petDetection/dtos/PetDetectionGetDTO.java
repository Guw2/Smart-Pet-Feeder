package com.lorian.sensor_service.petDetection.dtos;

import java.time.Instant;

public record PetDetectionGetDTO(Long id, Long petId, String sensorLocation, Instant detectedAt) {

}
