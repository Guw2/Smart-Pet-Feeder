package com.lorian.sensor_service.petDetection;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PetDetection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long petId;
	
	@Column
	private String sensorLocation;
	
	@Column
	private Date detectedAt;

	public PetDetection() {}

	public PetDetection(Long id, Long petId, String sensorLocation, Date detectedAt) {
		this.id = id;
		this.petId = petId;
		this.sensorLocation = sensorLocation;
		this.detectedAt = detectedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getSensorLocation() {
		return sensorLocation;
	}

	public void setSensorLocation(String sensorLocation) {
		this.sensorLocation = sensorLocation;
	}

	public Date getDetectedAt() {
		return detectedAt;
	}

	public void setDetectedAt(Date detectedAt) {
		this.detectedAt = detectedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(detectedAt, id, petId, sensorLocation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetDetection other = (PetDetection) obj;
		return Objects.equals(detectedAt, other.detectedAt) && Objects.equals(id, other.id)
				&& Objects.equals(petId, other.petId) && Objects.equals(sensorLocation, other.sensorLocation);
	}

	@Override
	public String toString() {
		return "PetDetection [id=" + id + ", petId=" + petId + ", sensorLocation=" + sensorLocation + ", detectedAt="
				+ detectedAt + "]";
	}
	
}
