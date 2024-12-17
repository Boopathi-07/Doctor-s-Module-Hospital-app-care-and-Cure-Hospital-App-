package com.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Doctor {
	@Id
	private int doctorId;

	private double consultationFees;
	private LocalDate dateOfJoining;
//	@Column(name = "DOCTOR_ID")

	private boolean isSurgeon;
	private boolean status;
	private int yearsOfExperience;
	private String contactNumber;
	private String doctorName;
	private String emailId;
	private String gender;
	private String location;
	private String qualification;
	private String specialization;
//	private List<Appointment> appointmentList;


//	@OneToMany
//	private List<Appointment> appointmentList;

//	private boolean status;

	// Getters and setters
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getConsultationFees() {
		return consultationFees;
	}

	public void setConsultationFees(double consultationFees) {
		this.consultationFees = consultationFees;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isSurgeon() {
		return isSurgeon;
	}

	public void setSurgeon(boolean isSurgeon) {
		this.isSurgeon = isSurgeon;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

//	public List<Appointment> getAppointmentList() {
//		return appointmentList;
//	}
//
//	public void setAppointmentList(List<Appointment> appointmentList) {
//		this.appointmentList = appointmentList;
//	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
