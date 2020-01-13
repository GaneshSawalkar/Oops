package com.bridgelabz.felloship.model;

public class Patients {
	String patientName;
	String patientId;
	String contactNumber;
	int age;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient Name: " + getPatientName() + "\nPatient Id: " + getPatientId() + "\nPatient Age: " + getAge()
				+ "\nPatient Contact: " + getContactNumber();
	}
}
