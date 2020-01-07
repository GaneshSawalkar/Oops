package com.bridgelabz.felloship.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.felloship.model.stockmodel;
import com.bridgelabz.felloship.operation.StockOperations;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class StockControl {
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {

	}

	public static List<stockmodel> readStock(String spath)
			throws JsonParseException, JsonMappingException, IOException {
		List<stockmodel> list = mapper.readValue(new File(spath), new TypeReference<List<stockmodel>>() {
		});
		return list;
	}

	public static void writeStock(List<stockmodel> list)
			throws JsonGenerationException, JsonMappingException, IOException {
		String spath = StockOperations.spath;
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), list);
	}
}
