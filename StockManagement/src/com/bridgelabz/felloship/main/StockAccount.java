package com.bridgelabz.felloship.main;

import java.io.IOException;

import com.bridgelabz.felloship.operation.DataProcessing;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StockAccount {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		DataProcessing.usermenu();
	}
}
