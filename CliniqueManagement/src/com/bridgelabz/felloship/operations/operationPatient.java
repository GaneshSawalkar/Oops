package com.bridgelabz.felloship.operations;

import java.io.IOException;
import java.util.List;
import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.model.Patients;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class operationPatient {
	static List<Patients> list;

	public operationPatient() throws JsonParseException, JsonMappingException, IOException {

		list = Control.readPatientFile();
	}

	public static List<Patients> AddPatient(List<Patients> lists)
			throws JsonParseException, JsonMappingException, IOException {

		Patients newpatients = new Patients();
		System.out.print("enter the name of patient: ");
		newpatients.setPatientName(Operations.isStringInput(Operations.scanner.next()));
		System.out.println("enter the id");
		newpatients.setPatientId(Operations.isNumeric(Operations.scanner.next()));
		System.out.println("enter contact number : ");
		newpatients.setContactNumber(Operations.isNumeric(Operations.scanner.next()));
		System.out.println("enter age of patient: ");
		newpatients.setAge(Operations.scanner.nextInt());

		lists.add(newpatients);
		return lists;
	}

	public static void searchpatient() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1-id\n2-name\n3-contact");
		int ch = Operations.scanner.nextInt();
		switch (ch) {
		case 1:
			System.out.println("enter Patient id: ");
			String inputid = Operations.scanner.next();
			searchPatient(inputid);
			break;
		case 2:
			System.out.println("enter Patient name: ");
			String inputname = Operations.scanner.next();
			searchPatient(inputname);
			break;
		case 3:
			System.out.println("enter Patient contact: ");
			String inputcontact = Operations.scanner.next();
			searchPatient(inputcontact);
			break;
		default:
			break;
		}
	}

	private static void searchPatient(String input) throws JsonParseException, JsonMappingException, IOException {
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

	private static void Show(Patients patients) {
		System.out.println("Patient Name: " + patients.getPatientName() + "\nPatientId: " + patients.getAge()
				+ "\nPatient Contact: " + patients.getContactNumber());
		System.out.println("********************************");

	}

	public static void ShowAllPatients() throws JsonParseException, JsonMappingException, IOException {
		List<Patients> list = Control.readPatientFile();
		System.out.println("********************************");
		for (Patients patients : list) {
			Show(patients);
		}
	}

	public static boolean ischeck(String input) throws JsonParseException, JsonMappingException, IOException {
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
