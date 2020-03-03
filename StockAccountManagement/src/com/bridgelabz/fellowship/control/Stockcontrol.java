package com.bridgelabz.fellowship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.fellowship.model.Stockmodel;
import com.bridgelabz.fellowship.operation.Stockoperations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Stockcontrol {
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {

	}

	public static List<Stockmodel> readStock(String spath) {
		List<Stockmodel> list = null;
		try {
			list = mapper.readValue(new File(spath), new TypeReference<List<Stockmodel>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void writeStock(List<Stockmodel> list) {
		String spath = Stockoperations.spath;
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
