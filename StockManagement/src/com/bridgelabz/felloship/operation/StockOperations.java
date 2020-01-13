package com.bridgelabz.felloship.operation;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.felloship.control.*;
import com.bridgelabz.felloship.model.Stocks;
import com.bridgelabz.felloship.model.TransactionLog;

public class StockOperations {
	// default stock path
	public static String spath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/stockinventory.json";
	static List<Stocks> list = new ArrayList<Stocks>();

	public static void StockMenu() {
		int ch;
		do {
			System.out.println("*****************Menu******************");
			System.out.println("1-Add Company share Stock\n" + "2-Delete Company Stock\n"
					+ "3-Update Company share Stock\n" + "4-Display Company share Stock\n"
					+ "5-Search Company share Stock\n" + "6-all trnsaction logs\n" + "7-Exit");
			System.out.print("select :");
			ch = inputvalidation.isvalidInteger();
			switch (ch) {
			case 1:
				Displaystock(); // old show all stocks
				AddStock(); // add stock
				System.out.println("Added: ");
				Displaystock(); // updated show all stock
				break;
			case 2:
				deleteStock(); // delete stock
				Displaystock(); // show updated stock
				break;
			case 3:
				updatestock(); // update stock info
				Displaystock(); // show update stock info
				break;
			case 4:
				Displaystock(); // show all stocks
				break;
			case 5:
				SearchStock(); // search stock
				break;
			case 6:
				alltransactionlog(); //show all shares transaction 
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

	private static void alltransactionlog() {
		List<TransactionLog> list = StockControl.readlog();
		for (TransactionLog transactionLog : list) {
			System.out.println(transactionLog.toString());
			System.out.println("---------------------------------------------\n");
		}
	}

	private static void SearchStock() {
		System.out.println("enter comapny symbol");
		String inputsymbol = inputvalidation.scanner.next();
		boolean find = false;
		list = StockControl.readStock(spath);
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

	public static void AddStock() {
		List<Stocks> newlist = new ArrayList<Stocks>();
		for (Stocks stockmodel : list) {
			newlist.add(stockmodel);
		}
		Stocks stockmodel = new Stocks();
		System.out.println("new entry");
		System.out.println("company symbol");
		stockmodel.setCompanysimbol(inputvalidation.scanner.next());
		System.out.println("company name");
		stockmodel.setCompanyname(inputvalidation.isString());
		System.out.println("company shares");
		stockmodel.setCompanyavailableshare(inputvalidation.isvalidInteger());
		System.out.println("company price");
		stockmodel.setShareprice(inputvalidation.isvalidInteger());
		newlist.add(stockmodel);// add stock in list
		StockControl.writeStock(newlist); // write new updated stock list
	}

	public static void updatestock() {
		Displaystock();
		System.out.println("enter symbol");
		String inputsymbol = inputvalidation.scanner.next();
		boolean find = false;
		for (Stocks stockmodel : list) {

			if (stockmodel.companysymbol.equals(inputsymbol)) { // search by input-symbol
				find = true;
				System.out.println("enter choice");
				int ch = inputvalidation.isvalidInteger();
				switch (ch) {
				case 1:
					System.out.println("update shares");
					stockmodel.setCompanyavailableshare(inputvalidation.isvalidInteger()); // set new available shares
					break;
				case 2:
					System.out.println("updatre price");
					stockmodel.setShareprice(inputvalidation.isvalidInteger()); // assign new share price
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
		Displaystock();// show stocks
		System.out.println("enter comapny symbol");
		String inputsymbol = inputvalidation.scanner.next();
		list = StockControl.readStock(spath); // read all stocks
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
		StockControl.writeStock(list); // update and write file
	}

	public static void Displaystock() {
		list = StockControl.readStock(spath); // read stock details from file
		for (Stocks stockmodel : list) { // show each details of stocks
			System.out.println(stockmodel.toString());
			System.out.println();
		}
	}
}