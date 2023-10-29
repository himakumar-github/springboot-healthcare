package com.healthcare.service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthcare.entity.HealthCareEntity;
import com.healthcare.repository.HealthCareRepository;
import com.healthcare.request.HealthCareRequest;
import com.healthcare.update.HealthCareUpdate;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class HealthCareServiceImplements implements HealthCareService {
	
	Logger log=LoggerFactory.getLogger(HealthCareService.class);
	
	@Autowired
	HealthCareRepository repository;

	@Override
	public String getHealthcareInfo(HealthCareRequest request){
		HealthCareEntity entity = new HealthCareEntity();
		entity.setDoctorId(request.getDoctorId());
		entity.setDoctorName(request.getDoctorName());
		entity.setHospitalId(request.getHospitalId());
		entity.setHospitalName(request.getHospitalName());
		entity.setPatientId(request.getPatientId() );
		entity.setPatientName(request.getPatientName());
		repository.save(entity);
		log.info("service layer"+entity);
		return "Health Care Details are updated successfully.";
	}
	@Override
	public Optional<HealthCareEntity> findBypatientName(String patientName) throws ExceptionHealth {
		Optional<HealthCareEntity>  details= repository.findByPatientName(patientName);
		if(details.isEmpty()) {
			throw new ExceptionHealth("there is no data found by the name : "+patientName);
		}
		HealthCareEntity result= details.get();
		HealthCareRequest request=new HealthCareRequest();
		request.setDoctorId(result.getDoctorId());
		request.setDoctorName(result.getDoctorName());
		request.setHospitalId(result.getHospitalId());
		request.setHospitalName(result.getHospitalName());
		request.setPatientId(result.getPatientId());
		request.setPatientName(result.getPatientName());
		log.info("service layer "+patientName);
		return details;
		}
	@Override
	public String updatedoctorId(Integer doctorId, HealthCareUpdate update){
		repository.updatedoctorId(doctorId,update.getDoctorName());
		log.info("service layer is "+doctorId);
		return "doctor details updated successfully";
	}
	@Override
	public String deleteBypatientId(Integer patientId){
		repository.deleteById(patientId);
		return "patient-id deleted successfully.";
	}
}
