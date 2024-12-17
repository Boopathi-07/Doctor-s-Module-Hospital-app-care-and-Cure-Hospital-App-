package com.pms.controller;

import org.springframework.web.bind.annotation.*;
import com.pms.service.DoctorService;
import com.pms.model.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/")
	public String home() {
		return "Welcome to the Doctor Management Application!";
	}

	@GetMapping("/welcome")
	public String displayWelcomeMessage() {
		String msg = doctorService.displayWelcomeMessage();
		return msg;
	}

	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<>(doctorService.addDoctor(doctor), HttpStatus.OK); // 200
	}

	// Delete Doctor by ID
	@DeleteMapping("/deleteDoctor")
	public ResponseEntity<String> deleteDoctor(@RequestBody Map<String, Integer> requestBody) {
		int doctorId = requestBody.get("doctorId");
		System.out.println(doctorId);

		boolean isDeleted = doctorService.deleteDoctorById(doctorId);

		if (isDeleted) {
			return new ResponseEntity<>("Doctor with ID " + doctorId + " deleted successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Doctor with ID " + doctorId + " not found.", HttpStatus.NOT_FOUND);
		}
	}

//	@PutMapping("/updateDoctorName/{doctorId}/{doctorName}")
//	public ResponseEntity<Doctor> updateDoctorName(@PathVariable int doctorId, @PathVariable String doctorName) {
//		Doctor updatedDoctor = doctorService.updateDoctorName(doctorId, doctorName);
//
//		if (updatedDoctor == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
//		}
//		return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
//	}

	@GetMapping("/viewDoctors")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}

	@GetMapping("/viewDoctorByName/{doctorName}")
	public ResponseEntity<List<Doctor>> findDoctorByName(@PathVariable String doctorName) {
		List<Doctor> doctors = doctorService.findDoctorByName(doctorName);
		if (doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}

	@GetMapping("/viewDoctorBySpecialization/{specialization}")
	public ResponseEntity<List<Doctor>> findDoctorBySpecialization(@PathVariable String specialization) {
		List<Doctor> doctors = doctorService.findDoctorBySpecialization(specialization);
		if (doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}

	@GetMapping("/viewDoctorByExperience/{minYears}/{maxYears}")
	public ResponseEntity<List<Doctor>> findDoctorByExperienceRange(@PathVariable int minYears, @PathVariable int maxYears) {
		List<Doctor> doctors = doctorService.findDoctorByExperienceRange(minYears, maxYears);
		if (doctors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}
}