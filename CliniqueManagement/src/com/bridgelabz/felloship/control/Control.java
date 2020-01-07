package com.bridgelabz.felloship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.felloship.model.Appointment;
import com.bridgelabz.felloship.model.Doctor;
import com.bridgelabz.felloship.model.Patients;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Control {
	static String Patientspath = "/home/admin1/Desktop/JavaProject/CliniqueManagement/src/com/bridgelabz/felloship/datafiles/PatientData.json";
	static String Doctorspath = "/home/admin1/Desktop/JavaProject/CliniqueManagement/src/com/bridgelabz/felloship/datafiles/DoctorData.json";
	static String appointmentpath="/home/admin1/Desktop/JavaProject/CliniqueManagement/src/com/bridgelabz/felloship/datafiles/AppointmentLog.json";
	static ObjectMapper mapper = new ObjectMapper();
	static File file;

	public static List<Patients> readPatientFile() throws JsonParseException, JsonMappingException, IOException {
		file = new File(Patientspath);
		if (!file.exists()) {
			file.createNewFile();
		}
		List<Patients> patientList = mapper.readValue(new File(Patientspath), new TypeReference<List<Patients>>() {
		});
		return patientList;
	}

	public static void writePatientFile(List<Patients> list)
			throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(Patientspath), list);
	}
	public static List<Appointment> readAppointment() throws JsonParseException, JsonMappingException, IOException {
		file = new File(Patientspath);
		if (!file.exists()) {
			file.createNewFile();
		}
		List<Appointment> appList = mapper.readValue(new File(appointmentpath), new TypeReference<List<Appointment>>() {
		});
		return appList;
	}

	public static void writeAppointment(List<Appointment> list)
			throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(appointmentpath), list);
	}


	public static List<Doctor> readDoctortFile() throws JsonParseException, JsonMappingException, IOException {
		file = new File(Patientspath);
		if (!file.exists()) {
			file.createNewFile();
		}
		List<Doctor> DoctorList = mapper.readValue(new File(Doctorspath), new TypeReference<List<Doctor>>() {
		});
		return DoctorList;
	}

	public static void writeDoctorFile(List<Doctor> list)
			throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(Doctorspath), list);
	}
}
