package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.Doctor;
import com.pms.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public String displayWelcomeMessage() {
		return "Welcome to Doctor Management System";
	}

	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public List<Doctor> findDoctorByName(String name) {
		return doctorRepository.findByDoctorName(name);
	}

	public List<Doctor> findDoctorBySpecialization(String specialization) {
		return doctorRepository.findBySpecialization(specialization);
	}

	public List<Doctor> findDoctorByExperienceRange(int minYears, int maxYears) {
		return doctorRepository.findByYearsOfExperienceBetween(minYears, maxYears);
	}

	public boolean deleteDoctorById(int doctorId) {
		System.out.println("Checking if doctor exists with ID: " + doctorId);
		boolean exists = doctorRepository.existsById(doctorId);
		System.out.println("Doctor exists: " + exists);

		if (exists) {
			doctorRepository.deleteById(doctorId);
			System.out.println("Doctor deleted successfully.");
			return true;
		}
		System.out.println("Doctor not found.");
		return false;
	}


	public Doctor updateDoctorName(int doctorId, String doctorName) {
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

		if (doctor != null) {
			doctor.setDoctorName(doctorName);
			return doctorRepository.save(doctor);
		} else {
			return null;
		}
	}
}
