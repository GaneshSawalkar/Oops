package com.bridgelabz.fellowship.operation;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.fellowship.control.*;
import com.bridgelabz.fellowship.model.Stocks;
import com.bridgelabz.fellowship.model.Transactionlog;

public class Stockoperations {
	// default stock path
	public static String spath = "src/com/bridgelabz/fellowship/stockinventory.json";
	static List<Stocks> list = new ArrayList<Stocks>();

	public static void StockMenu() {
		int ch;
		do {
			System.out.println("*****************Menu******************");
			System.out.println("1-Add Company share Stock\n" + "2-Delete Company Stock\n"
					+ "3-Update Company share Stock\n" + "4-Display Company share Stock\n"
					+ "5-Search Company share Stock\n" + "6-all trnsaction logs\n" + "7-Exit");
			System.out.print("select :");
			ch = Inputvalidation.isValidInteger();
			switch (ch) {
			case 1:
				displayStock(); // old show all stocks
				addStock(); // add stock
				System.out.println("Added: ");
				displayStock(); // updated show all stock
				break;
			case 2:
				deleteStock(); // delete stock
				displayStock(); // show updated stock
				break;
			case 3:
				updateStock(); // update stock info
				displayStock(); // show update stock info
				break;
			case 4:
				displayStock(); // show all stocks
				break;
			case 5:
				searchStock(); // search stock
				break;
			case 6:
				allTransactionLog(); // show all shares transaction
				break;
			case 7:
				System.out.println("Thank you.....!"); // exit stock menu
				return;
			default:
				System.out.println("invalid select.."); // Invalid input
				StockMenu();
				break;
			}
		} while (ch != 7); // break if input is 6.

	}

	private static void allTransactionLog() {
		List<Transactionlog> list = Stockcontrol.readLog();
		for (Transactionlog transactionLog : list) {
			System.out.println(transactionLog.toString());
			System.out.println("---------------------------------------------\n");
		}
	}

	private static void searchStock() {
		System.out.println("enter comapny symbol");
		String inputsymbol = Inputvalidation.scanner.next();
		boolean find = false;
		list = Stockcontrol.readStock(spath);
		for (Stocks stockmodel : list) {// search stock by company symbol
			if (stockmodel.companysymbol.equals(inputsymbol)) {
				find = true;
				// show stock
				System.out.println(stockmodel.toString());
				System.out.println();
			}
		}
		if (!find) {
			System.out.println("not in stock");
		}
	}

	public static void addStock() {
		List<Stocks> newlist = new ArrayList<Stocks>();
		for (Stocks stockmodel : list) {
			newlist.add(stockmodel);
		}
		Stocks stockmodel = new Stocks();
		System.out.println("new entry");
		System.out.println("company symbol");
		stockmodel.setCompanysimbol(Inputvalidation.scanner.next());
		System.out.println("company name");
		stockmodel.setCompanyname(Inputvalidation.isString());
		System.out.println("company shares");
		stockmodel.setCompanyavailableshare(Inputvalidation.isValidInteger());
		System.out.println("company price");
		stockmodel.setShareprice(Inputvalidation.isValidInteger());
		newlist.add(stockmodel);// add stock in list
		Stockcontrol.writeStock(newlist); // write new updated stock list
	}

	public static void updateStock() {
		displayStock();
		System.out.println("enter symbol");
		String inputsymbol = Inputvalidation.scanner.next();
		boolean find = false;
		for (Stocks stockmodel : list) {

			if (stockmodel.companysymbol.equals(inputsymbol)) { // search by input-symbol
				find = true;
				System.out.println("enter choice");
				int ch = Inputvalidation.isValidInteger();
				switch (ch) {
				case 1:
					System.out.println("update shares");
					stockmodel.setCompanyavailableshare(Inputvalidation.isValidInteger()); // set new available shares
					break;
				case 2:
					System.out.println("updatre price");
					stockmodel.setShareprice(Inputvalidation.isValidInteger()); // assign new share price
					break;
				default:
					break;
				}
			}
		}
		if (find) { // stock not found
			System.out.println("not in stock ");

		} else {
			System.out.println("Deleted: ");
		}
	}

	private static void deleteStock() {
		System.out.println("enter comapny symbol");
		String inputsymbol = Inputvalidation.scanner.next();
		list = Stockcontrol.readStock(spath); // read all stocks
		boolean find = false;
		for (Stocks stockmodel : list) {
			if (stockmodel.companysymbol.equals(inputsymbol)) {// check stock-symbol= user input symbol
				find = true;
				System.out.print(stockmodel.toString());
				list.remove(stockmodel); // delete stock

				break;
			}
		}
		if (!find) { // Stock not found
			System.out.println("not in stock");
		} else {
			System.out.println(" Deleted: \n");

		}
		Stockcontrol.writeStock(list); // update and write file
	}

	public static void displayStock() {
		list = Stockcontrol.readStock(spath); // read stock details from file
		for (Stocks stockmodel : list) { // show each details of stocks
			System.out.println(stockmodel.toString());
			System.out.println();
		}
	}
}