package com.bridgelabz.felloship.main;

import java.io.IOException;

import com.bridgelabz.felloship.operations.Operations;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CliniqueManagement {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Operations.CliniqueManagement();
	}
}
