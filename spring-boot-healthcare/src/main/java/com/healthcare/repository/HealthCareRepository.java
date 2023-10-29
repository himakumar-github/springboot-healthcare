package com.healthcare.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.healthcare.entity.HealthCareEntity;

@Repository
public interface HealthCareRepository extends JpaRepository<HealthCareEntity, Integer> {
	
	Optional<HealthCareEntity> findByPatientName(String patientName);

	@Modifying
	@Query(value = "update health_care_entity set doctor_name=?2 where doctor_id =?1",nativeQuery = true)
	public void updatedoctorId(Integer doctorId,String doctorName);
	
}
