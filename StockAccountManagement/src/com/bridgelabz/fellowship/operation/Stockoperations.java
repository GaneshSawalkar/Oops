package com.bridgelabz.fellowship.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.fellowship.control.*;
import com.bridgelabz.fellowship.model.Stockmodel;

public class Stockoperations {
	public static String spath = "src/com/bridgelabz/felloship/files/stockinventory.json";
	static List<Stockmodel> list;
	static Scanner scanner = new Scanner(System.in);

	public static void stockMenu() {
		int ch;
		do {
			System.out.println("*****************Menu******************");
			System.out.println(
					"1-Add Company share Stock\n" + "2-Delete Company Stock\n" + "3-Update Company share Stock\n"
							+ "4-Display Company share Stock\n" + "5-Search Company share Stock\n" + "6-Exit");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				displayStock();
				// AddStock();
				System.out.println("Added: ");
				displayStock();

				break;
			case 2:
				displayStock();
				deleteStock();
				System.out.println("Deleted: ");
				displayStock();
				break;
			case 3:
				updateStock();
				System.out.println("Updated: ");
				displayStock();
				break;
			case 4:

				displayStock();
				break;
			case 5:
				searchStock();
				break;
			case 6:
				System.out.println("Thank you.....!");
				return;

			default:
				System.out.println("invalid select..");
				stockMenu();
				break;
			}
		} while (ch != 6);
	}

	private static void searchStock() {
		System.out.println("enter comapny symbol");
		String inputsymbol = scanner.next();
		list = Stockcontrol.readStock(spath);
		for (Stockmodel stockmodel : list) {
			if (stockmodel.companysimbol.equals(inputsymbol)) {
				getStock(stockmodel);
			}
		}

	}

	private static void getStock(Stockmodel stockmodel) {
		System.out.println(stockmodel.companysimbol + "|" + stockmodel.companyname + "|"
				+ stockmodel.companyavailableshare + "|" + stockmodel.shareprice);
		System.out.println();
	}

	@SuppressWarnings("unused")
	private static void addStock() {
		List<Stockmodel> newlist = new ArrayList<Stockmodel>();
		list = Stockcontrol.readStock(spath);
		for (Stockmodel stockmodel : list) {
			newlist.add(stockmodel);
		}
		Stockmodel stockmodel = new Stockmodel();
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
		Stockcontrol.writeStock(newlist);
	}

	private static void updateStock() {
		list = Stockcontrol.readStock(spath);
		System.out.println("enter symbol");
		String inputsymbol = scanner.next();
		for (Stockmodel stockmodel : list) {

			if (stockmodel.companysimbol.equals(inputsymbol)) {
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
			Stockcontrol.writeStock(list);
		}
	}

	private static void deleteStock() {
		displayStock();

		System.out.println("enter comapny symbol");
		String inputsymbol = scanner.next();
		list = Stockcontrol.readStock(spath);
		for (Stockmodel stockmodel : list) {
			if (stockmodel.companysimbol.equals(inputsymbol)) {
				list.remove(stockmodel);
				break;
			}
		}
		Stockcontrol.writeStock(list);

	}

	private static void displayStock() {
		list = Stockcontrol.readStock(spath);
		System.out.println("*******Stock Market********");
		for (Stockmodel stockmodel : list) {
			System.out.println(
					stockmodel.companysimbol + "  " + stockmodel.companyname + "  " + stockmodel.companyavailableshare
							+ "  " + stockmodel.shareprice * stockmodel.companyavailableshare);
			System.out.println();
		}
	}
}