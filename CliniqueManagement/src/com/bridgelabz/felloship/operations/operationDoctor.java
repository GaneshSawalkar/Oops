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

	public static List<Doctor> AddDoctor(List<Doctor> lists)
			throws JsonParseException, JsonMappingException, IOException {
		operationDoctor.ShowDoctors();
		Doctor newDoctorentry = new Doctor();
		System.out.println("new doctor name: ");
		newDoctorentry.setDoctorname(Operations.isStringInput(Operations.scanner.next()));
		System.out.println("new doctor id: ");
		newDoctorentry.setDoctorId(Operations.isNumeric(Operations.scanner.next()));
		System.out.println("enter new doctor Specialities: ");
		newDoctorentry.setSpecialization(Operations.isStringInput(Operations.scanner.next()));
		System.out.println("enter new doctor timing: Am/Pm");
		newDoctorentry.setAvailable(Operations.scanner.next());

		lists.add(newDoctorentry);
		return lists;

	}

	public static void SearchDoctorBy() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1-Id\n2-Name\n3-specilization\n4-availabel\n");
		int choice = Operations.scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("enter the doctor Id");
			SearchDoctor();
			break;
		case 2:
			System.out.println("enter the doctor Name");
			SearchDoctor();
			break;
		case 3:
			System.out.println("enter the doctor specilization");
			SearchDoctor();
			break;
		case 4:
			System.out.println("enter the doctor Time");
			SearchDoctor();
			break;
		default:

			break;
		}
	}

	public static void SearchDoctor() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> lists = Control.readDoctortFile();
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) {
			if (doctor.getDoctorId().equals(input) || doctor.getAvailable().equals(input)
					|| doctor.getDoctorname().equals(input) || doctor.getSpecialization().equals(input)) {
				find = true;
				show(doctor);
			}

		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	public static void show(Doctor doctor) {
		System.out.println("Id: " + doctor.getDoctorId() + "\nName: " + doctor.getDoctorname() + "\nSpecilization"
				+ doctor.getSpecialization() + "\nTiming: " + doctor.getAvailable());

	}

	public static void ShowDoctors() throws JsonParseException, JsonMappingException, IOException {
		List<Doctor> list = Control.readDoctortFile();
		System.out.println("********************************");

		for (Doctor doctor : list) {
			show(doctor);
			System.out.println("********************************");

		}
	}

}
