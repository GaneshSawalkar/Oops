package com.bridgelabz.felloship.model;

import java.util.Date;

public class Appointment {
	String patientname;
	String doctorname;
	int appointment;
	Date date;

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public int getAppointment() {
		return appointment;
	}

	public void setAppointment(int appointment) {
		this.appointment = appointment;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
}
