package com.bridgelabz.felloship.inventory;

import com.bridgelabz.felloship.operations.*;
import com.bridgelabz.felloship.productmenu.*;

public class JSONInventoryDataManagement {

	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// inventory show
	public static void menu() {
		InventoryManager.pricemenu();
		System.out.println("******************Operations***************");

		int key;
		do {
			System.out.println("1: Add Inventory\n" + "2: Remove Inventory\n" + "3: Update Inventory\n"
					+ "4: Search Inventory\n5: Show all Inventory\n" + "6: Exit");
			key = operations.scanner.nextInt();
			switch (key) {
			case 1:
				InventoryManager.pricemenu(); // show inventory
				operations.add(); // add new inventory
				InventoryManager.pricemenu(); // show updated inventory
				break;
			case 2:
				InventoryManager.pricemenu(); // show inventory
				operations.del(); // remove inventory
				InventoryManager.pricemenu(); // show updated inventory
				break;
			case 3:
				InventoryManager.pricemenu(); // show inventory
				operations.update(); // update inventory information
				InventoryManager.pricemenu();// show updated inventory
				break;
			case 4:
				operations.search(); // search inventry
				break;
			case 5:
				InventoryManager.pricemenu(); // show all inventory with price
				break;
			case 6:
				return;
			default:
				break;
			}
		} while (key != 6);
	}

}
