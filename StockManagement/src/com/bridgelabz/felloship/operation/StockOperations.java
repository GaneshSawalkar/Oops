package com.bridgelabz.felloship.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.felloship.control.*;
import com.bridgelabz.felloship.model.stockmodel;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StockOperations {

	public static String spath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/stockinventory.json";
	static List<stockmodel> list = new ArrayList<stockmodel>();
	static Scanner scanner = new Scanner(System.in);

	public static void stockmenu() throws JsonParseException, JsonMappingException, IOException {
		int ch;
		do {
			System.out.println("*****************Menu******************");
			System.out.println(
					"1-Add Company share Stock\n" + "2-Delete Company Stock\n" + "3-Update Company share Stock\n"
							+ "4-Display Company share Stock\n" + "5-Search Company share Stock\n" + "6-Exit");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				Displaystock();
				AddStock();
				System.out.println("Added: ");
				Displaystock();
				break;
			case 2:
				deleteStock();
				Displaystock();
				break;
			case 3:
				updatestock();
				Displaystock();
				break;
			case 4:
				Displaystock();
				break;
			case 5:
				SearchStock();
				break;
			case 6:
				System.out.println("Thank you.....!");
				return;

			default:
				System.out.println("invalid select..");
				stockmenu();
				break;
			}
		} while (ch != 6);

	}

	private static void getstock(stockmodel stockmodel) {
		System.out.println(stockmodel.companysymbol + "|" + stockmodel.companyname + "|"
				+ stockmodel.companyavailableshare + "|" + stockmodel.shareprice);
		System.out.println();
	}

	private static void SearchStock() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("enter comapny symbol");
		String inputsymbol = scanner.next();
		boolean find = false;
		list = StockControl.readStock(spath);
		for (stockmodel stockmodel : list) {
			if (stockmodel.companysymbol.equals(inputsymbol)) {
				find = true;
				getstock(stockmodel);
			}
		}
		if (!find) {
			System.out.println("not in stock");
		}
	}

	public static void AddStock() throws JsonGenerationException, JsonMappingException, IOException {
		List<stockmodel> newlist = new ArrayList<stockmodel>();
		for (stockmodel stockmodel : list) {
			newlist.add(stockmodel);
		}
		stockmodel stockmodel = new stockmodel();
		System.out.println("new entry");
		System.out.println("symbol");
		stockmodel.setCompanysimbol(scanner.next());
		System.out.println("name");
		stockmodel.setCompanyname(scanner.next());
		System.out.println("stock");
		stockmodel.setCompanyavailableshare(scanner.nextInt());
		System.out.println("price");
		stockmodel.setShareprice(scanner.nextInt());
		newlist.add(stockmodel);
		StockControl.writeStock(newlist);
	}

	public static void updatestock() throws JsonParseException, JsonMappingException, IOException {
		Displaystock();

		System.out.println("enter symbol");
		String inputsymbol = scanner.next();
		boolean find = false;
		for (stockmodel stockmodel : list) {

			if (stockmodel.companysymbol.equals(inputsymbol)) {
				find = true;
				System.out.println("enter choice");
				int ch = scanner.nextInt();
				switch (ch) {
				case 1:
					System.out.println("update stock");
					stockmodel.setCompanyavailableshare(scanner.nextInt());
					break;
				case 2:
					System.out.println("updatre price");
					stockmodel.setShareprice(scanner.nextInt());
					break;
				default:
					break;
				}
			}
		}
		if (find) {
			System.out.println("not in stock ");

		} else {
			System.out.println("Deleted: ");
		}
	}

	private static void deleteStock() throws JsonParseException, JsonMappingException, IOException {
		Displaystock();

		System.out.println("enter comapny symbol");
		String inputsymbol = scanner.next();
		list = StockControl.readStock(spath);
		boolean find = false;
		for (stockmodel stockmodel : list) {
			if (stockmodel.companysymbol.equals(inputsymbol)) {
				find = true;
				list.remove(stockmodel);
				break;
			}
		}
		if (!find) {
			System.out.println("not in stock");
		} else {
			System.out.println("Deleted: ");

		}
		StockControl.writeStock(list);

	}

	public static void Displaystock() throws JsonParseException, JsonMappingException, IOException {
		list = StockControl.readStock(spath);
		for (stockmodel stockmodel : list) {

			System.out.println("company " + stockmodel.companysymbol + " " + stockmodel.companyname + " having shares: "
					+ stockmodel.companyavailableshare + " at price "
					+ stockmodel.shareprice * stockmodel.companyavailableshare);
			System.out.println();
		}
	}
}