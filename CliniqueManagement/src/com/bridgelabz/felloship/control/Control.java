package com.bridgelabz.felloship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.felloship.model.Appointment;
import com.bridgelabz.felloship.model.Doctor;
import com.bridgelabz.felloship.model.Patients;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Control {
	static String Patientspath = "/home/admin1/Desktop/JavaProject/CliniqueManagement/src/com/bridgelabz/felloship/datafiles/PatientData.json";
	static String Doctorspath = "/home/admin1/Desktop/JavaProject/CliniqueManagement/src/com/bridgelabz/felloship/datafiles/DoctorData.json";
	static String appointmentpath = "/home/admin1/Desktop/JavaProject/CliniqueManagement/src/com/bridgelabz/felloship/datafiles/AppointmentLog.json";
	static ObjectMapper mapper = new ObjectMapper();
	static File file;

	public static List<Patients> readPatientFile() {
		file = new File(Patientspath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<Patients> patientList = null;
		try {
			patientList = mapper.readValue(new File(Patientspath), new TypeReference<List<Patients>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public static void writePatientFile(List<Patients> list) {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(Patientspath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Appointment> readAppointment() {
		file = new File(Patientspath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<Appointment> appList = null;
		try {
			appList = mapper.readValue(new File(appointmentpath), new TypeReference<List<Appointment>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appList;
	}

	public static void writeAppointment(List<Appointment> list) {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(appointmentpath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Doctor> readDoctortFile() {
		file = new File(Patientspath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<Doctor> DoctorList = null;
		try {
			DoctorList = mapper.readValue(new File(Doctorspath), new TypeReference<List<Doctor>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DoctorList;
	}

	public static void writeDoctorFile(List<Doctor> list) {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(Doctorspath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
