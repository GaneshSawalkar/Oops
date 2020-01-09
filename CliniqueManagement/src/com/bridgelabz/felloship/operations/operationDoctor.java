package com.bridgelabz.felloship.operations;

import java.util.List;

import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Doctor;

public class operationDoctor {
	static List<Doctor> list;

	public operationDoctor() {
		list = Control.readDoctortFile(); // read doctor file
	}

	// new doctor entry
	public static List<Doctor> AddDoctor(List<Doctor> lists) {
		operationDoctor.ShowDoctors();
		Doctor newDoctorentry = new Doctor();
		System.out.println("new doctor name: "); // set doctor name
		newDoctorentry.setDoctorname(Operations.isStringInput(Operations.scanner.next()));
		System.out.println("new doctor id: "); // set doctor id
		newDoctorentry.setDoctorId(Operations.isNumeric(Operations.scanner.next()));
		System.out.println("enter new doctor specialization: "); // set doctor specialization
		newDoctorentry.setSpecialization(Operations.isStringInput(Operations.scanner.next()));
		System.out.println("enter new doctor timing: Am/Pm"); // set doctor in time
		newDoctorentry.setAvailable(Operations.scanner.next());

		lists.add(newDoctorentry); // add in list
		return lists; // return updated list

	}

	public static void SearchDoctorBy() {
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

	public static void SearchDoctor() {
		List<Doctor> lists = Control.readDoctortFile(); // Received all doctors list
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) { // show doctor info by user input
			if (doctor.getDoctorId().equals(input) || doctor.getAvailable().equals(input)
					|| doctor.getDoctorname().equals(input) || doctor.getSpecialization().equals(input)) {
				find = true;
				show(doctor);
			}

		}
		if (!find) { // false if doctor not in list
			System.out.println("this doctor not in this clinique");
		}

	}

	// show doctors details
	public static void show(Doctor doctor) {
		System.out.println("Id: " + doctor.getDoctorId() + "\nName: " + doctor.getDoctorname() + "\nSpecilization"
				+ doctor.getSpecialization() + "\nTiming: " + doctor.getAvailable());

	}

	// show all docrtors
	public static void ShowDoctors() {
		List<Doctor> list = Control.readDoctortFile();
		System.out.println("********************************");

		for (Doctor doctor : list) {
			show(doctor);
			System.out.println("********************************");

		}
	}

}
