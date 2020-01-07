package com.bridgelabz.felloship.operations;

import java.io.IOException;
import java.util.List;

import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Doctor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class operationDoctor {
	static List<Doctor> list;

	public operationDoctor() throws JsonParseException, JsonMappingException, IOException {
		list = Control.readDoctortFile();
	}

	public static void SearchBy() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1-Id\n2-Name\n3-specilization\n4-availabel\n");
		int choice = Operations.scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("enter the doctor Id");
			SearchById();
			break;
		case 2:
			System.out.println("enter the doctor Name");
			SearchByName();
			break;
		case 3:
			System.out.println("enter the doctor specilization");
			SearchBySpecial();
			break;
		case 4:
			System.out.println("enter the doctor Time");
			SearchBytime();
			break;
		default:

			break;
		}
	}

	public static void SearchBytime() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> lists = Control.readDoctortFile();
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) {
			if (doctor.getAvailable().equals(input)) {
				find = true;
				showlist(doctor);
			}

		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	public static void SearchBySpecial() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> lists = Control.readDoctortFile();
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) {
			if (doctor.getSpecialization().equals(input)) {
				find = true;
				showlist(doctor);
			}

		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	public static void SearchByName() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> lists = Control.readDoctortFile();
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) {
			if (doctor.getDoctorname().equals(input)) {
				find = true;
				showlist(doctor);
			}

		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	public static void SearchById() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> lists = Control.readDoctortFile();
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) {
			if (doctor.getDoctorId().equals(input)) {
				find = true;
				showlist(doctor);
			}

		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}
	
	
	
	

	public static void showlist(Doctor doctor) {
		System.out.println(doctor.getDoctorname() + " " + doctor.getSpecialization() + " " + doctor.getAvailable());

	}

	public static void ShowDoctors() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> list = Control.readDoctortFile();
		for (Doctor doctor : list) {
			System.out.println(doctor.getDoctorId() + " " + doctor.getDoctorname() + " " + doctor.getSpecialization()
					+ " " + doctor.getAvailable());
		}
	}

	

}
