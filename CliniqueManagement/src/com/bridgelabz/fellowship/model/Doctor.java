package com.bridgelabz.fellowship.model;

public class Doctor {
	String doctorname;
	String doctorId;
	String specialization;
	String available;
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Id: " + getDoctorId() + "\nName: " + getDoctorname() + "\nSpecilization"
				+ getSpecialization() + "\nTiming: " + getAvailable();
	}

}
