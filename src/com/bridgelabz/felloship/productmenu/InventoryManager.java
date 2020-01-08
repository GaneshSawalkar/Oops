package com.bridgelabz.felloship.productmenu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.felloship.inventory.Product;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryManager {
	public static String spath = "/home/admin1/Desktop/ganeshproject/InventoryManagment/src/com/bridgelabz/felloship/inventoryfile/inventory.json";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		pricemenu();
	}

	public static void pricemenu() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("*************Inventory Menu****************");
		List<Product> list = mapper.readValue(new File(spath), new TypeReference<List<Product>>() {
		});
		for (Product product : list) {
			System.out.print(product.type+":");
			System.out.println(product.name + " = " + (product.price * product.weight) / product.weight + " / Kg");
		}
		System.out.println();
	}
}