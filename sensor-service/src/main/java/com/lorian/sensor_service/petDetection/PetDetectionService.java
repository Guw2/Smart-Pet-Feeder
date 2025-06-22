package com.lorian.sensor_service.petDetection;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lorian.sensor_service.petDetection.dtos.PetDetectionGetDTO;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionPostDTO;

@Service
public class PetDetectionService {

	private final PetDetectionRepository repo;
	
	public PetDetectionService(PetDetectionRepository repo) {
		this.repo = repo;
	}
	
	public List<PetDetectionGetDTO> getAllDetections(){
		return repo.findAll().stream().map(x -> PetDetectionMapper.petDetectionToGetDto(x)).toList();
	}
	
	public PetDetectionGetDTO insertDetection(PetDetectionPostDTO dto) {
		PetDetection petDetection = PetDetectionMapper.postDtoToPetDetection(dto);
		return PetDetectionMapper.petDetectionToGetDto(repo.save(petDetection));
	}
	
}
