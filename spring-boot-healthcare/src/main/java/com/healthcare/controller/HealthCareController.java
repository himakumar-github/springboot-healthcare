package com.healthcare.controller;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.healthcare.entity.HealthCareEntity;
import com.healthcare.request.HealthCareRequest;
import com.healthcare.service.ExceptionHealth;
import com.healthcare.service.HealthCareService;
import com.healthcare.update.HealthCareUpdate;

@RestController
@RequestMapping("/healthcare")
public class HealthCareController {

	Logger log=LoggerFactory.getLogger(HealthCareController.class);
	
	@Autowired 
	HealthCareService service;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String getHealthcareInfo(@RequestBody HealthCareRequest request){
		log.info("Controller layer "+request);
		String result=service.getHealthcareInfo(request);
		return result;
	}
	@GetMapping("/{patientName}")
	public Optional<HealthCareEntity> findBypatientName(@PathVariable String patientName) throws ExceptionHealth{
		Optional<HealthCareEntity>request= service.findBypatientName(patientName);
		log.info("Controller layer "+patientName);
		return request;
	}
	@PutMapping("/update/{doctorId}")
	public String updatedoctorId(@PathVariable Integer doctorId,@RequestBody HealthCareUpdate update){
		 log.info("controller layer is "+doctorId);
		 return service.updatedoctorId(doctorId,update);
	}
	@DeleteMapping("/delete/{patientId}")
	public String deleteBypatientId(@PathVariable Integer patientId){
		return service.deleteBypatientId(patientId);
	}
}
