package com.bridgelabz.felloship.operations;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Appointment;
import com.bridgelabz.felloship.model.Doctor;
import com.bridgelabz.felloship.model.Patients;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Operations {
	static Scanner scanner = new Scanner(System.in);

	public static void CliniqueManagement() throws JsonParseException, JsonMappingException, IOException {
		int choice;
		do {
			System.out.println(
					"Select option: \n1-AddDoctor\n2-AddPatient\n3-SearchDoctor\n4-SearchPtient\n5-Setppointment\n6-Showppointments");
			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				AddDoctor();
				break;
			case 2:
				AddPatient();
				break;
			case 3:
				operationDoctor.SearchBy();
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
		} while (choice != 7);
	}

	public static void searchappointment() throws JsonParseException, JsonMappingException, IOException {
		List<Appointment> applog = Control.readAppointment();

		System.out.println("enter doctor name: ");
		String doctorname = Operations.scanner.next();
		for (Appointment appointment : applog) {
			if (appointment.getDoctorname().equalsIgnoreCase(doctorname)) {
				System.out.println(
						appointment.getDoctorname() + " " + appointment.getPatientname() + " " + appointment.getDate());
			}
		}

	}

	public static void getAppointment() throws JsonParseException, JsonMappingException, IOException {
		List<Appointment> list = Control.readAppointment();
		Calendar calendar = Calendar.getInstance();
		int totalappointments = 1;
		System.out.println("enter doctor name");
		String doctorname = Operations.scanner.next();

		for (Appointment appointment : list) {

			if (appointment.getDoctorname().equals(doctorname)) {
				totalappointments++;
			}
		}

		if (totalappointments < 6) {
			Appointment appointment = new Appointment();
			System.out.println("patient name");
			appointment.setPatientname(Operations.scanner.next());
			System.out.println("Doctor name: " + doctorname);
			appointment.setDoctorname(doctorname);

			appointment.setDate(calendar.getTime());
			appointment.setAppointment(totalappointments);
			list.add(appointment);
			Control.writeAppointment(list);
		} else {
			System.out.println("appointments are full today");
			System.out.println("do you want to get tomorrow : Yes/No ");
			String get = Operations.scanner.next();
			if (get.equalsIgnoreCase("yes")) {

				calendar.add(Calendar.DAY_OF_YEAR, 1);

				Appointment appointment = new Appointment();
				System.out.println("patient name");
				appointment.setPatientname(Operations.scanner.next());
				System.out.println("Doctor name: " + doctorname);
				appointment.setDoctorname(doctorname);

				appointment.setDate(calendar.getTime());
				appointment.setAppointment(totalappointments);
				list.add(appointment);
				Control.writeAppointment(list);
			}
			if (get.equalsIgnoreCase("no")) {
				System.out.println("Have a nice day.....!");
			}

			CliniqueManagement();
		}
	}

	public static void AddDoctor() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> list = Control.readDoctortFile();
		Doctor newDoctorentry = new Doctor();

		System.out.println("new doctor name: ");
		newDoctorentry.setDoctorname(Operations.scanner.next());
		System.out.println("new doctor id: ");
		newDoctorentry.setDoctorId(Operations.scanner.next());
		System.out.println("enter new doctor Specialities: ");
		newDoctorentry.setSpecialization(Operations.scanner.next());
		System.out.println("enter new doctor timing: Am/Pm");
		newDoctorentry.setAvailable(Operations.scanner.next());

		list.add(newDoctorentry);
		Control.writeDoctorFile(list);
	}

	public static void AddPatient() throws JsonParseException, JsonMappingException, IOException {
		List<Patients> lists = Control.readPatientFile();
		Patients newpatients = new Patients();
		System.out.print("enter the name of patient: ");
		newpatients.setPatientName(Operations.scanner.nextLine());
		System.out.println("enter the id");
		newpatients.setPatientId(Operations.scanner.next());
		System.out.println("enter contact number : ");
		newpatients.setContactNumber(Operations.scanner.next());
		System.out.println("enter age of patient: ");
		newpatients.setAge(Operations.scanner.nextInt());

		lists.add(newpatients);
		Control.writePatientFile(lists);
	}

}
