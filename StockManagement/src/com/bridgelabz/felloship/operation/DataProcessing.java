package com.bridgelabz.felloship.operation;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.felloship.control.StockControl;
import com.bridgelabz.felloship.model.StockUser;
import com.bridgelabz.felloship.model.TransactionLog;
import com.bridgelabz.felloship.model.stockmodel;
import com.bridgelabz.felloship.operation.StockOperations;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DataProcessing {
	// Initialized for take input from user
	static Scanner sc = new Scanner(System.in);

	public static void usermenu() throws JsonParseException, JsonMappingException, IOException {
		int key;

		do {
			System.out.println("**********************Menu*************************");
			System.out.println("1-Add user\n" + "2-remove user\n" + "3-Transaction\n" + "4-check share stock mareket");
			System.out.print("select choice:-> ");
			key = sc.nextInt();

			switch (key) {
			case 1:
				// Add new user entry
				addusers();

				break;
			case 2:
				// Remove User
				displayAllusers();
				removeuser();
				break;

			case 3:
				// Users transaction (buy and sales).
				transactions();
				break;
			case 4:
				// show all stock report
				StockOperations.Displaystock();
				break;

			default:
				break;
			}
		} while (key != 5);
	}

	public static void displayAllusers() throws JsonParseException, JsonMappingException, IOException {
		List<StockUser> list = StockControl.readusers();
		System.out.println("***********************************");
		for (StockUser stockUser : list) {
			System.out.println("Username: " + stockUser.getUsername() + "\nTotal shares: " + stockUser.getShare());
		System.out.println("***********************************");
		}
	}

	// users transactions buy and sales shares.
	public static void transactions() throws JsonParseException, JsonMappingException, IOException {
		int key;

		do {
			System.out.println();
			System.out.println("**************Transaction**************");
			System.out.println("1-Buy Shares\n" + "2-Sale Shares\n" + "3-user Log\n" + "4-Stock Menu");
			System.out.print("enter choice: ");
			key = sc.nextInt();
			// select choice for operation
			switch (key) {

			case 1:
				// get buys shares
				buy();
				break;

			case 2:
				// sale shares
				sell();
				break;

			case 3:
				// print log report of transaction.
				printreport();
				break;

			case 4:
				// display all stock report.
				StockOperations.Displaystock();
				break;

			default:
				System.out.println("invaalid choice");
				break;
			}
		} while (key != 5);

	}

	// add new users entry
	private static void addusers() throws JsonParseException, JsonMappingException, IOException {

		List<StockUser> newuser = StockControl.readusers();
		// new class initialized
		StockUser newentry = new StockUser();
		// take new user name and default share value as 0.
		System.out.print("enter user name: ");
		newentry.setUsername(sc.next());
		System.out.println();
		newentry.setShare(0);
		// add in list.
		newuser.add(newentry);
		// write list with object mapper
		StockControl.writeusers(newuser);

	}

	// remove existing users.
	private static void removeuser() throws JsonParseException, JsonMappingException, IOException {
//read data

		List<StockUser> user = StockControl.readusers();

		System.out.println();
		System.out.print("enput user name: ");
		String inputusername = sc.next();
		System.out.println();

		boolean find = false;

		for (StockUser stockUser : user) {

			if (stockUser.getUsername().equalsIgnoreCase(inputusername)) {

				find = true;

				if (stockUser.getShare() == 0) {
					// user found then delete that users
					user.remove(stockUser);
					System.out.println("removed successfully....");
				} else {
					System.out.println("sale all shares then remove");
				}

			}
		}

		// check user is in list or not
		if (!find) {
			System.out.println("not in the list");
			System.out.println();
		}
		// write new list.
		StockControl.writeusers(user);
	}

	// buy the shares from the stock market.
	private static void buy() throws JsonParseException, JsonMappingException, IOException {

		StockOperations.Displaystock();
		System.out.println("user name");
		String username = sc.next();

		List<StockUser> user = StockControl.readusers();

		for (StockUser stockUser : user) {
			// search user from list.
			if (stockUser.getUsername().equalsIgnoreCase(username)) {
				System.out.println("enter company symbol");
				String inputsymbol = sc.next();
				DataProcessing.displayAllusers();
				String spath = StockOperations.spath;

				List<stockmodel> list = StockControl.readStock(spath);

				for (stockmodel stockmodel : list) {
					// search company name using symbol.
					if (stockmodel.companysymbol.equals(inputsymbol)) {

						System.out.println("welcome to " + stockmodel.companyname);
						System.out.println("availabe Share is: " + stockmodel.companyavailableshare);
						System.out.println("price per share is: " + stockmodel.shareprice);

						System.out.println("no. of share you want?");
						int getshare = sc.nextInt();
						// display no. of shares want * actual share price
						System.out.println("your buy" + getshare + " share at " + getshare * stockmodel.shareprice);
						// update stock.
						stockmodel.setCompanyavailableshare(stockmodel.companyavailableshare - getshare);
						System.out.println();

						stockUser.setShare(getshare + stockUser.getShare());
						// write log entry of transaction
						Transaction(stockUser, stockmodel, "buy", getshare);
					}
				}
				// update existing records
				StockControl.writeusers(user);
				StockControl.writeStock(list);

			} 
		}

	}

	//
	public static void Transaction(StockUser stockUser, stockmodel stockmodel, String status, int amount)
			throws JsonParseException, JsonMappingException, IOException {
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		List<TransactionLog> log = StockControl.readlog();
		// set transaction log entry
		TransactionLog transLog = new TransactionLog();

		transLog.setUsername(stockUser.getUsername());
		transLog.setCompanysymbol(stockmodel.getCompanysymbol());
		transLog.setCompanyname(stockmodel.getCompanyname());

		transLog.setCompanyshares(amount);
		transLog.setShareprice(stockUser.getShare() * stockmodel.getShareprice());
		transLog.setDate(date);

		switch (status) {
		case "sale":
			transLog.setTransction("sale");
			break;
		case "buy":
			transLog.setTransction("buy");
			break;
		default:
			break;
		}
		// add log in list
		log.add(transLog);
		// write list.
		StockControl.writelog(log);

	}

	// display transaction log of user
	public static void printreport() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("\n*******************User Log**********************");
		System.out.println("1-all transaction of users");
		boolean find = false;

		System.out.print("enter the name : ");
		String username = sc.next();
		System.out.println();

		List<TransactionLog> log = StockControl.readlog();

		for (TransactionLog transactionLog : log) {
			if (transactionLog.getUsername().equalsIgnoreCase(username)) {
				// display report if find user

				find = true;

				System.out.println(transactionLog.getUsername() + " " + transactionLog.getCompanyname() + " "
						+ transactionLog.getDate().toString() + " " + transactionLog.getTransction());
			}
		}
		if (!find) {
			System.out.println("no log found....");
		}
	}

	// sales the existing share to company.
	private static void sell() throws JsonParseException, JsonMappingException, IOException {
		StockOperations.Displaystock();
		System.out.println("username");
		String username = sc.next();

		List<StockUser> user = StockControl.readusers();

		for (StockUser stockUser : user) {
			if (stockUser.getUsername().equals(username)) {
				System.out.println("enter company symbol");
				String inputsymbol = sc.next();
				String spath = StockOperations.spath;

				List<stockmodel> list = StockControl.readStock(spath);

				for (stockmodel stockmodel : list) {
					if (stockmodel.companysymbol.equals(inputsymbol)) {
						System.out.println("enter share amount");
						int shares = sc.nextInt();

						System.out.println("your shares is : " + shares + "\nper share price: " + stockmodel.shareprice
								+ "\ntotal price is: " + shares * stockmodel.shareprice);
						System.out.println("sale successfully.....");

						stockmodel.setCompanyavailableshare(stockmodel.companyavailableshare + shares);
						// substract and update user data
						stockUser.setShare(stockUser.getShare() - shares);
						// set log entry
						Transaction(stockUser, stockmodel, "sale", shares);
					}
				}
				// new user data write
				StockControl.writeusers(user);
				// write new stock market list
				StockControl.writeStock(list);

			}
		}

	}

}
