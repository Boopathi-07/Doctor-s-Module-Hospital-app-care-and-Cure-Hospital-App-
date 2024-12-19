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
	public boolean markDoctorAsInactive(int doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

		if (doctor != null) {
			doctor.setStatus(false); // Set status to false
			doctorRepository.save(doctor); // Save the updated doctor
			return true;
		}
		return false;
	}
	public Doctor updateDoctor(int doctorId, Doctor updatedDoctor) {
		Doctor existingDoctor = doctorRepository.findById(doctorId).orElse(null);

		if (existingDoctor != null) {
			// Update fields only if they are provided in the request
			if (updatedDoctor.getDoctorName() != null) {
				existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
			}
			if (updatedDoctor.getSpecialization() != null) {
				existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
			}
			if (updatedDoctor.getQualification() != null) {
				existingDoctor.setQualification(updatedDoctor.getQualification());
			}
			if (updatedDoctor.getContactNumber() != null) {
				existingDoctor.setContactNumber(updatedDoctor.getContactNumber());
			}
			if (updatedDoctor.getEmailId() != null) {
				existingDoctor.setEmailId(updatedDoctor.getEmailId());
			}
			if (updatedDoctor.getGender() != null) {
				existingDoctor.setGender(updatedDoctor.getGender());
			}
			if (updatedDoctor.getLocation() != null) {
				existingDoctor.setLocation(updatedDoctor.getLocation());
			}
			if (updatedDoctor.getConsultationFees() != 0) {
				existingDoctor.setConsultationFees(updatedDoctor.getConsultationFees());
			}
			if (updatedDoctor.getYearsOfExperience() != 0) {
				existingDoctor.setYearsOfExperience(updatedDoctor.getYearsOfExperience());
			}
			if (updatedDoctor.getDateOfJoining() != null) {
				existingDoctor.setDateOfJoining(updatedDoctor.getDateOfJoining());
			}
			existingDoctor.setStatus(updatedDoctor.isStatus());
			existingDoctor.setSurgeon(updatedDoctor.isSurgeon());

			return doctorRepository.save(existingDoctor); // Save the updated doctor record
		}
		return null; // Return null if doctor not found
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
