package com.bridgelabz.felloship.operations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Appointment;
import com.bridgelabz.felloship.model.Doctor;
import com.bridgelabz.felloship.model.Patients;

public class Operations {
	static Scanner scanner = new Scanner(System.in);
	static int totalappointments = 1;
	static Date date = new Date();
	static SimpleDateFormat format = new SimpleDateFormat("MMMM-dd-yyyy");
	static String phonenumber;

	public static void CliniqueManagement() {
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

	public static void Cliniquemenu(int choice) {
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
			operationDoctor.SearchDoctorBy(); // search doctor
			break;
		case 4:
			operationPatient.searchpatient(); // search patient
			break;
		case 5:
			getAppointment(); // get appointment of doctors
			break;
		case 6:
			searchappointment(); // search appointment of date
			break;
		default:
			break;
		}
	}

	// search appointment using user input as date
	@SuppressWarnings("deprecation")
	public static void searchappointment() {
		System.out.println("Doctors are: ");
		operationDoctor.ShowDoctors();

		System.out.print("enter appointment Date(Day): ");
		int searchbyday = Operations.scanner.nextInt();

		List<Appointment> applog = Control.readAppointment(); // read all appointments
		date.setDate(searchbyday); // set user define date
		System.out.println("Appointment of " + format.format(date));
		System.out.println("enter doctor name: ");
		String doctorname = Operations.scanner.next();
		int temp = 0;
		System.out.println("************************************************");
		for (Appointment appointment : applog) {

			if (appointment.getDoctorname().equalsIgnoreCase(doctorname)) { // search by user define date
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

	// get appointment
	@SuppressWarnings("deprecation")
	public static void getAppointment() {
		System.out.println("show available doctors in clinique: ");
		operationDoctor.ShowDoctors(); // show all available doctors in clinic
		Date date = new Date(); // set current date
		List<Appointment> list;
		System.out.println("enter doctor name");
		String doctorname = isStringInput();

		int totalappointments;
		do {
			list = Control.readAppointment(); // read appointment list
			totalappointments = 1;
			for (Appointment appointment : list) {
				if (appointment.getDoctorname().equals(doctorname)) { // check total appointment on date
					if (appointment.getDate().getDay() == date.getDay()
							&& appointment.getDate().getMonth() == date.getMonth()) {
						totalappointments++;
					}
				}
			}
			// appointment is greater than 5
			if (totalappointments == 6) {
				System.out.println(format.format(date) + " --> Appoint ment Slot full..");
				date.setDate(date.getDate() + 1); // then increased date by 1
			}
		} while (totalappointments == 6);

		System.out.println("*********************************************");
		System.out.println("\n" + format.format(date) + " <-- Appointment Available for date");
		System.out.println("*********************************************");

		System.out.println("do you want to get tomorrow : Yes/No ");
		String get = isStringInput();

		if (get.equalsIgnoreCase("yes")) {

			Confirmappointment(doctorname, date, totalappointments, list);
		}
		if (get.equalsIgnoreCase("no")) {
			System.out.println("Have a nice day.....!\n");
		}

		CliniqueManagement();
	}

	// check patient confirmation and entry
	public static void Confirmappointment(String doctorname, Date date, int totalappointments, List<Appointment> list) {
		Appointment appointment = new Appointment();
		System.out.println("patient name");
		String patientname = isStringInput();

		// not register patient
		if (!operationPatient.searchPatient(patientname)) {// existing patiens.

			System.out.println("Its new patient: Please enter details ");
			// set appointment details of patient
			appointment.setPatientname(patientname);
			System.out.println("Doctor name: " + doctorname);
			appointment.setDoctorname(doctorname);
			appointment.setDate(date);
			appointment.setAppointment(totalappointments);
			list.add(appointment);
			Control.writeAppointment(list);
			System.out.println("Appointment Saved..!\n");
			Cliniquemenu(2);
		} else { // existing patients Add in patient list

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

	public static int isvalidInteger() {
		int i = 0;
		boolean ok = true;
		while (ok) {
			try {

				i = scanner.nextInt();
				ok = false;
			} catch (InputMismatchException e) {
				System.out.println("Not integer value.");
				System.out.print("select again: ");
				scanner.next();
			}
		}

		return i;
	}

	public static String isNumericString(String integer) {
		try {
			int check = Integer.parseInt(integer);
		} catch (NumberFormatException e) {
			System.out.println("invalid format enter again:");
			integer = isNumericString(scanner.next());
		}
		return integer;
	}

	// check its string input or not
	public static String isStringInput() {
		String input;
		boolean flag = false;
		do {
			input = scanner.next();
			if (input.matches("^[a-zA-Z]*$")) {
				flag = true;
			} else {
				System.out.print("Wrong input..! type again :");
			}
		} while (!flag);
		return input;
	}

	public static String isvalidphone() {
		phonenumber = scanner.next();
		Pattern pattern = Pattern.compile("[7-9][0-9]{9}");
		Matcher matcher = pattern.matcher(phonenumber);
		if (matcher.find()) {
			return phonenumber;
		} else {
			System.out.println("number must be 10 digit & start with 7-9");
			isvalidphone();
		}
		return phonenumber;

	}

}
