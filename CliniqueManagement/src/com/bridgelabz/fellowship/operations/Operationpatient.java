package com.bridgelabz.fellowship.operations;

import java.util.List;

import com.bridgelabz.fellowship.control.Control;
import com.bridgelabz.fellowship.model.Patients;

public class Operationpatient {
	static List<Patients> list;

	public Operationpatient() {

		list = Control.readPatientFile(); // read all patient files
	}

	public static List<Patients> addPatient(List<Patients> lists) {

		Patients Newpatients = new Patients();
		System.out.print("enter the name of patient: ");
		Newpatients.setPatientName(Operations.isStringInput());// set patient name
		System.out.println("enter the id");
		Newpatients.setPatientId(Operations.isNumericString(Operations.scanner.next())); // set patient id
		System.out.println("enter contact number : ");
		Newpatients.setContactNumber(Operations.isValidphone()); // set patient contact
																	// number
		System.out.println("enter age of patient: ");
		Newpatients.setAge(Operations.isValidInteger()); // set patient age

		lists.add(Newpatients); // add new patient in list
		return lists; // return newly added list
	}

	public static void searchPatient() {
		System.out.println("1-id\n2-name\n3-contact");
		int ch = Operations.scanner.nextInt();
		switch (ch) {
		case 1:
			System.out.println("enter Patient id: ");
			String inputid = Operations.isNumericString(Operations.scanner.next());
			searchPatient(inputid);// search patient by user id
			break;
		case 2:
			System.out.println("enter Patient name: ");
			String inputname = Operations.isStringInput();
			searchPatient(inputname);// search patient by user name
			break;
		case 3:
			System.out.println("enter Patient contact: ");
			String inputcontact = Operations.isValidphone();
			searchPatient(inputcontact); // search patient by user contact
			break;
		default:
			break;
		}
	}

	// search patient by user input
	public static boolean searchPatient(String input) {
		List<Patients> list = Control.readPatientFile();
		boolean find = false;
		System.out.println("********************************");

		for (Patients patients : list) {
			if (patients.getContactNumber().equals(input) || patients.getPatientName().equals(input)
					|| patients.getPatientId().equals(input)) {
				System.out.println(patients.toString());
				find = true;
			}
		}
		if (!find) {
			System.out.println("not found..!");
			return false;
		}
		return true;

	}

	// show all patient list
	public static void showAllPatients() {
		List<Patients> list = Control.readPatientFile();
		System.out.println("********************************");
		for (Patients patients : list) {
			System.out.println(patients.toString());
			System.out.println("********************************");
		}
	}

}
