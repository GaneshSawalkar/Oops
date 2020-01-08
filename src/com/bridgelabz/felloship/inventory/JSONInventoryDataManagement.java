package com.bridgelabz.felloship.inventory;

import java.io.IOException;
import com.bridgelabz.felloship.operations.*;
import com.bridgelabz.felloship.productmenu.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JSONInventoryDataManagement {

	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void menu() throws JsonParseException, JsonMappingException, IOException {
		InventoryManager.pricemenu();
		System.out.println("******************Operations***************");

		int key;
		do {
			System.out.println("1: Add Inventory\n" + "2: Remove Inventory\n" + "3: Update Inventory\n"
					+ "4: Search Inventory\n5: Show all Inventory\n" + "6: Exit");
			key = operations.scanner.nextInt();
			switch (key) {
			case 1:
				InventoryManager.pricemenu();
				operations.add();
				InventoryManager.pricemenu();
				break;
			case 2:
				InventoryManager.pricemenu();
				operations.del();
				InventoryManager.pricemenu();
				break;
			case 3:
				InventoryManager.pricemenu();
				operations.update();
				InventoryManager.pricemenu();
				break;
			case 4:
				operations.display();
				break;
			case 5:
				InventoryManager.pricemenu();
				break;
			case 6:
				return;
			default:
				break;
			}
		} while (key != 6);
	}

}
