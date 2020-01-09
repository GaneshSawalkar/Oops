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
		newpatients.setPatientName(Operations.isStringInput(Operations.scanner.next()));// set patient name
		System.out.println("enter the id");
		newpatients.setPatientId(Operations.isNumeric(Operations.scanner.next())); // set patient id
		System.out.println("enter contact number : ");
		newpatients.setContactNumber(Operations.isNumeric(Operations.scanner.next())); // set patient contact number
		System.out.println("enter age of patient: ");
		newpatients.setAge(Operations.scanner.nextInt()); // set patient age

		lists.add(newpatients); // add new patient in list
		return lists; // return newly added list
	}

	public static void searchpatient() {
		System.out.println("1-id\n2-name\n3-contact");
		int ch = Operations.scanner.nextInt();
		switch (ch) {
		case 1:
			System.out.println("enter Patient id: ");
			String inputid = Operations.scanner.next();
			searchPatient(inputid);// search patient by user id
			break;
		case 2:
			System.out.println("enter Patient name: ");
			String inputname = Operations.scanner.next();
			searchPatient(inputname);// search patient by user name
			break;
		case 3:
			System.out.println("enter Patient contact: ");
			String inputcontact = Operations.scanner.next();
			searchPatient(inputcontact); // search patient by user contact
			break;
		default:
			break;
		}
	}

	// search patient by user input
	private static void searchPatient(String input) {
		List<Patients> list = Control.readPatientFile();
		if (!ischeck(input)) {
			System.out.println("this doctor not in this clinique");
		} else {
			System.out.println("********************************");

			for (Patients patients : list) {
				if (patients.getContactNumber().equals(input) || patients.getPatientName().equals(input)
						|| patients.getPatientId().equals(input)) {
					Show(patients);
				}
			}
		}
	}

	// details patient details
	private static void Show(Patients patients) {
		System.out.println("Patient Name: " + patients.getPatientName() + "\nPatientId: " + patients.getAge()
				+ "\nPatient Contact: " + patients.getContactNumber());
		System.out.println("********************************");

	}

	// show all patient list
	public static void ShowAllPatients() {
		List<Patients> list = Control.readPatientFile();
		System.out.println("********************************");
		for (Patients patients : list) {
			Show(patients);
		}
	}

	// check patient in list or not
	public static boolean ischeck(String input) {
		List<Patients> patientlist = Control.readPatientFile();

		for (Patients patients : patientlist) {
			if (patients.getContactNumber().equals(input) || patients.getPatientName().equals(input)
					|| patients.getPatientId().equals(input)) {
				return true;
			}
		}
		return false;
	}

}
