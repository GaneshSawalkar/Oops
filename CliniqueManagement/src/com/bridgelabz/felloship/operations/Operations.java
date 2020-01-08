package com.bridgelabz.felloship.operations;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Appointment;
import com.bridgelabz.felloship.model.Doctor;
import com.bridgelabz.felloship.model.Patients;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Operations {
	static Scanner scanner = new Scanner(System.in);
	static int totalappointments = 1;
	static Date date = new Date();
	static SimpleDateFormat format = new SimpleDateFormat("MMMM-dd-yyyy");

	public static void CliniqueManagement() throws JsonParseException, JsonMappingException, IOException {
		int choice;
		do {
			System.out.println("*******************Clinique*********************");
			System.out.println(
					"Select option: \n1-AddDoctor\n2-AddPatient\n3-SearchDoctor\n4-SearchPtient\n5-Setppointment\n6-Showppointments");
			System.out.print("\nYour Choice is: ");
			choice = scanner.nextInt();

			Cliniquemenu(choice);
		} while (choice != 7);
	}

	public static void Cliniquemenu(int choice) throws JsonParseException, JsonMappingException, IOException {
		switch (choice) {
		case 1:
			List<Doctor> list = Control.readDoctortFile();
			List<Doctor> addlist = operationDoctor.AddDoctor(list);
			System.out.println("Doctor Added Suucessfully....");
			Control.writeDoctorFile(addlist);
			operationDoctor.ShowDoctors();
			break;
		case 2:
			operationPatient.ShowAllPatients();
			List<Patients> lists = Control.readPatientFile();
			List<Patients> addlists = operationPatient.AddPatient(lists);
			System.out.println("Patient Added Suucessfully....");
			Control.writePatientFile(addlists);
			operationPatient.ShowAllPatients();
			break;
		case 3:
			operationDoctor.SearchDoctorBy();
			break;
		case 4:
			operationPatient.searchpatient();
			break;
		case 5:
			getAppointment();
			break;
		case 6:
			searchappointment();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("deprecation")
	public static void searchappointment() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Doctors are: ");
		operationDoctor.ShowDoctors();

		System.out.print("enter appointment Date(Day): ");
		int searchbyday = Operations.scanner.nextInt();

		List<Appointment> applog = Control.readAppointment();
		date.setDate(searchbyday);
		System.out.println("Appointment of " + format.format(date));
		System.out.println("enter doctor name: ");
		String doctorname = Operations.scanner.next();
		int temp = 0;
		System.out.println("************************************************");
		for (Appointment appointment : applog) {

			if (appointment.getDoctorname().equalsIgnoreCase(doctorname)) {
				if (appointment.getDate().getDay() == date.getDay()
						&& appointment.getDate().getMonth() == date.getMonth()) {
					temp++;
					System.out.println("Doctor name: " + appointment.getDoctorname() + "\nPtient Name: "
							+ appointment.getPatientname() + "\nDate: " + appointment.getDate());
					System.out.println("************************************************");

				}
			}
		}

		if (temp == 0)

		{
			System.out.println("No appointment today's...\n");
		}

	}

	@SuppressWarnings("deprecation")
	public static void getAppointment() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("show available doctors in clinique: ");
		operationDoctor.ShowDoctors();

		Date date = new Date();
		List<Appointment> list;
		System.out.println("enter doctor name");
		String doctorname = isStringInput(Operations.scanner.next());

		int totalappointments;
		do {
			list = Control.readAppointment();
			totalappointments = 1;
			for (Appointment appointment : list) {
				if (appointment.getDoctorname().equals(doctorname)) {
					if (appointment.getDate().getDay() == date.getDay()
							&& appointment.getDate().getMonth() == date.getMonth()) {
						totalappointments++;
					}
				}
			}
			if (totalappointments == 6) {
				System.out.println(format.format(date) + " --> Appoint ment Slot full..");
				date.setDate(date.getDate() + 1);
			}
		} while (totalappointments == 6);

		System.out.println("*********************************************");
		System.out.println("\n" + format.format(date) + " <-- Appointment Available for date");
		System.out.println("*********************************************");

		System.out.println("do you want to get tomorrow : Yes/No ");
		String get = isStringInput(Operations.scanner.next());

		if (get.equalsIgnoreCase("yes")) {

			Confirmappointment(doctorname, date, totalappointments, list);
		}
		if (get.equalsIgnoreCase("no")) {
			System.out.println("Have a nice day.....!\n");
		}

		CliniqueManagement();
	}

	// check patient confirmation and entry
	public static void Confirmappointment(String doctorname, Date date, int totalappointments, List<Appointment> list)
			throws JsonGenerationException, JsonMappingException, IOException {
		Appointment appointment = new Appointment();
		System.out.println("patient name");
		String patientname = isStringInput(Operations.scanner.next());

		boolean patientfind = operationPatient.ischeck(patientname);

		// not register patient
		if (!patientfind) {
			System.out.println("Its new patient: Please enter details ");
			appointment.setPatientname(patientname);
			System.out.println("Doctor name: " + doctorname);
			appointment.setDoctorname(doctorname);
			appointment.setDate(date);
			appointment.setAppointment(totalappointments);
			list.add(appointment);
			Control.writeAppointment(list);
			System.out.println("Appointment Saved..!\n");
			Cliniquemenu(2);
		} else {
			// existing patients
			System.out.println("already exist");
			appointment.setPatientname(patientname);
			System.out.println(patientname);
			System.out.println("Doctor name: " + doctorname);
			appointment.setDoctorname(doctorname);
			appointment.setDate(date);
			appointment.setAppointment(totalappointments);
			list.add(appointment);
			Control.writeAppointment(list);
		}
	}

	public static String isStringInput(String StringInputData) {
		if (StringInputData.matches("^[a-zA-Z]*$")) {
			return StringInputData;
		} else {
			System.out.println("Not valid Input.....!\ninput again: ");

			isStringInput(Operations.scanner.next());
		}
		return StringInputData;
	}

	@SuppressWarnings("unused")
	public static String isNumeric(String StringInputNumber) {
		try {
			int isvalid = Integer.parseInt(StringInputNumber);
		} catch (NumberFormatException nfe) {
			isNumeric(StringInputNumber);
		}
		return StringInputNumber;
	}

}
