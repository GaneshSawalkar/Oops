package com.bridgelabz.felloship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.felloship.model.stockmodel;
import com.bridgelabz.felloship.operation.StockOperations;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockControl {
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {

	}

	public static List<stockmodel> readStock(String spath) {
		List<stockmodel> list = null;
		try {
			list = mapper.readValue(new File(spath), new TypeReference<List<stockmodel>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void writeStock(List<stockmodel> list) {
		String spath = StockOperations.spath;
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
