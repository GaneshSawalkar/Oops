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

	public static void searchpatient() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("1-id\n2-name\n3-contact");
		int ch = Operations.scanner.nextInt();
		switch (ch) {
		case 1:
			searchPatientbyid();
			break;
		case 2:
			searchPatientbyname();
			break;
		case 3:
			searchPatientbycontact();
			break;
		default:
			break;
		}
	}

	private static void searchPatientbyid() throws JsonParseException, JsonMappingException, IOException {
		List<Patients> list = Control.readPatientFile();
		System.out.println("enter input: ");
		String input = Operations.scanner.next();
		boolean find = false;
		for (Patients patients : list) {
			if (patients.getPatientId().equals(input)) {
				find = true;
				Showdata(patients);
			}
		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	private static void searchPatientbyname() throws JsonParseException, JsonMappingException, IOException {
		List<Patients> list = Control.readPatientFile();
		System.out.println("enter input: ");
		String input = Operations.scanner.next();
		boolean find = false;
		for (Patients patients : list) {
			if (patients.getPatientName().equals(input)) {
				find = true;
				Showdata(patients);
			}
		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	private static void searchPatientbycontact() throws JsonParseException, JsonMappingException, IOException {
		List<Patients> list = Control.readPatientFile();
		System.out.println("enter input: ");
		String input = Operations.scanner.next();
		boolean find = false;
		for (Patients patients : list) {
			if (patients.getContactNumber().equals(input)) {
				find = true;
				Showdata(patients);
			}
		}
		if (!find) {
			System.out.println("this doctor not in this clinique");
		}

	}

	private static void Showdata(Patients patients) {
		System.out.println(patients.getPatientName() + " " + patients.getAge() + " " + patients.getContactNumber());
		;
	}
}
