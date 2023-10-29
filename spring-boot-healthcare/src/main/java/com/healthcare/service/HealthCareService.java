package com.healthcare.service;
import java.util.Optional;
import com.healthcare.entity.HealthCareEntity;
import com.healthcare.request.HealthCareRequest;
import com.healthcare.update.HealthCareUpdate;

public interface HealthCareService {

	String getHealthcareInfo(HealthCareRequest request);
	
	Optional<HealthCareEntity> findBypatientName(String patientName ) throws ExceptionHealth;
	
	String updatedoctorId(Integer doctorId,HealthCareUpdate update);

	String deleteBypatientId(Integer patientId);
}
