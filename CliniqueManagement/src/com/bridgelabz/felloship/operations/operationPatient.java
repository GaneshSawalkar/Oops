package com.bridgelabz.felloship.operations;

import java.util.List;
import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Patients;

public class operationPatient {
	static List<Patients> list;

	public operationPatient() {

		list = Control.readPatientFile(); // read all patient files
	}

	public static List<Patients> AddPatient(List<Patients> lists) {

		Patients newpatients = new Patients();
		System.out.print("enter the name of patient: ");
		newpatients.setPatientName(Operations.isStringInput());// set patient name
		System.out.println("enter the id");
		newpatients.setPatientId(Operations.isNumericString(Operations.scanner.next())); // set patient id
		System.out.println("enter contact number : ");
		newpatients.setContactNumber(Operations.isvalidphone()); // set patient contact
																	// number
		System.out.println("enter age of patient: ");
		newpatients.setAge(Operations.isvalidInteger()); // set patient age

		lists.add(newpatients); // add new patient in list
		return lists; // return newly added list
	}

	public static void searchpatient() {
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
			String inputcontact = Operations.isvalidphone();
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
	public static void ShowAllPatients() {
		List<Patients> list = Control.readPatientFile();
		System.out.println("********************************");
		for (Patients patients : list) {
			System.out.println(patients.toString());
			System.out.println("********************************");
		}
	}

}
