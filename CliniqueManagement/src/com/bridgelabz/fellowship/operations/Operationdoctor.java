package com.bridgelabz.fellowship.operations;

import java.util.List;

import com.bridgelabz.fellowship.control.Control;
import com.bridgelabz.fellowship.model.Doctor;

public class Operationdoctor {
	static List<Doctor> list;

	public Operationdoctor() {
		list = Control.readDoctortFile(); // read doctor file
	}

	// new doctor entry
	public static List<Doctor> addDoctor(List<Doctor> lists) {
		Operationdoctor.showDoctors();
		Doctor NewDoctorentry = new Doctor();
		System.out.println("new doctor name: "); // set doctor name
		NewDoctorentry.setDoctorname(Operations.isStringInput());
		System.out.println("new doctor id: "); // set doctor id
		NewDoctorentry.setDoctorId(Operations.isNumericString(Operations.scanner.next()));
		System.out.println("enter new doctor specialization: "); // set doctor specialization
		NewDoctorentry.setSpecialization(Operations.isStringInput());
		System.out.println("enter new doctor timing: Am/Pm"); // set doctor in time
		NewDoctorentry.setAvailable(Operations.scanner.next());

		lists.add(NewDoctorentry); // add in list
		return lists; // return updated list

	}

	public static void SearchDoctorBy() {
		System.out.println("1-Id\n2-Name\n3-specilization\n4-availabel\n");
		int choice = Operations.isValidInteger();
		switch (choice) {
		case 1:
			System.out.println("enter the doctor Id");
			searchDoctor();
			break;
		case 2:
			System.out.println("enter the doctor Name");
			searchDoctor();
			break;
		case 3:
			System.out.println("enter the doctor specilization");
			searchDoctor();
			break;
		case 4:
			System.out.println("enter the doctor Time");
			searchDoctor();
			break;
		default:

			break;
		}
	}

	public static void searchDoctor() {
		List<Doctor> lists = Control.readDoctortFile(); // Received all doctors list
		String input = Operations.scanner.next();
		boolean find = false;
		for (Doctor doctor : lists) { // show doctor info by user input
			if (doctor.getDoctorId().equals(input) || doctor.getAvailable().equals(input)
					|| doctor.getDoctorname().equals(input) || doctor.getSpecialization().equals(input)) {
				find = true;
				System.out.println(doctor.toString());
			}

		}
		if (!find) { // false if doctor not in list
			System.out.println("this doctor not in this clinique");
		}

	}

	// show all docrtors
	public static void showDoctors() {
		List<Doctor> list = Control.readDoctortFile();
		System.out.println("********************************");

		for (Doctor doctor : list) {
			System.out.println(doctor.toString());
			System.out.println("********************************");

		}
	}

}
