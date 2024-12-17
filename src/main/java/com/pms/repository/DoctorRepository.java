package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	List<Doctor> findByDoctorName(String name);
	List<Doctor> findBySpecialization(String specialization);
	List<Doctor> findByYearsOfExperienceBetween(int minYears, int maxYears);
}
