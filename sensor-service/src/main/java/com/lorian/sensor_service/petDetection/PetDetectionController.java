package com.lorian.sensor_service.petDetection;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorian.sensor_service.petDetection.dtos.PetDetectionGetDTO;
import com.lorian.sensor_service.petDetection.dtos.PetDetectionPostDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/detections")
@Tag(name = "Pet Detection Controller", description = "PetDetection-Related Operations")
public class PetDetectionController {

	private final PetDetectionService service;

	// Constructor Injection
	public PetDetectionController(PetDetectionService service) {
		this.service = service;
	}
	
	@Operation(responses = @ApiResponse(responseCode = "200", description = "Get all detections"))
	@GetMapping
	public ResponseEntity<List<PetDetectionGetDTO>> getAll(){
		return new ResponseEntity<List<PetDetectionGetDTO>>(service.getAllDetections(), HttpStatus.OK);
	}
	
	@Operation(responses = @ApiResponse(responseCode = "201", description = "Insert a new detection"))
	@PostMapping
	public ResponseEntity<PetDetectionGetDTO> insert(@RequestBody PetDetectionPostDTO dto){
		return new ResponseEntity<PetDetectionGetDTO>(service.insertDetection(dto), HttpStatus.CREATED);
	}
}
