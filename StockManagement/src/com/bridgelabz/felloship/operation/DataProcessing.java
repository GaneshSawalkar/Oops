package com.bridgelabz.felloship.operation;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.felloship.control.StockControl;
import com.bridgelabz.felloship.model.StockUser;
import com.bridgelabz.felloship.model.Stocks;
import com.bridgelabz.felloship.model.TransactionLog;
import com.bridgelabz.felloship.operation.StockOperations;

public class DataProcessing {
	// Initialized for take input from user
	static Scanner sc = new Scanner(System.in);

	public static void usermenu() {
		int key;
		do {
			System.out.println("**********************Menu*************************");
			System.out.println("1-Add user\n" + "2-remove user\n" + "3-Transaction\n" + "4-check share stock mareket");
			System.out.print("select choice:-> ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				addusers(); // Add new user entry
				break;
			case 2:
				displayAllusers(); // show users
				removeuser(); // Remove User
				break;
			case 3:
				transactions(); // Users transaction (buy and sales).
				break;
			case 4:
				StockOperations.Displaystock(); // show all stock report
				break;
			default:
				break;
			}
		} while (key != 5); // exit loop when input key is 5.
	}

	public static void displayAllusers() {
		// Retrieve all users list from file.
		List<StockUser> list = StockControl.readusers();
		System.out.println("***********************************");
		for (StockUser stockUser : list) {
			System.out.println("Username: " + stockUser.getUsername() + "\nTotal shares: " + stockUser.getShare());
			System.out.println("***********************************");
		}
	}

	// users transactions buy and sales shares.
	public static void transactions() {
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
				buy(); // get buys shares
				break;
			case 2:
				sell(); // sale shares
				break;
			case 3:
				printreport(); // print log report of transaction.
				break;
			case 4:
				StockOperations.Displaystock(); // display all stock report.
				break;
			default:
				System.out.println("invaalid choice"); // input is invalid or out of range
				break;
			}
		} while (key != 5); // exit if input is 5.
	}

	// add new users entry
	private static void addusers() {
		// Retrieve all users list from file.
		List<StockUser> newuser = StockControl.readusers();

		StockUser newentry = new StockUser(); // new class initialized

		System.out.print("enter user name: "); // take new user name
		newentry.setUsername(sc.next());
		System.out.println();
		newentry.setShare(0); // default new user having 0 shares.

		newuser.add(newentry); // add new user in list.

		StockControl.writeusers(newuser); // write new added file.
	}

	// remove existing users.
	private static void removeuser() {
		// read all users.
		List<StockUser> user = StockControl.readusers();

		System.out.print("\nenter user name: \n"); // user name for search
		String inputusername = sc.next();

		boolean find = false; // for check user in list or not
		for (StockUser stockUser : user) {
			if (stockUser.getUsername().equalsIgnoreCase(inputusername)) {
				find = true;
				if (stockUser.getShare() == 0) {
					user.remove(stockUser); // user found with having 0 shares then delete that users
					System.out.println("removed successfully....");
				} else {
					System.out.println("sale all shares then remove");
				}
			}
		}
		if (!find) { // check user is not in list
			System.out.println("not in the list\n");
		}

		StockControl.writeusers(user); // write new updated list.
	}

	// buy the shares from the stock.
	private static void buy() {
		StockOperations.Displaystock(); // show all stock info.
		System.out.println("user name"); // input for search
		String username = sc.next();
		List<StockUser> user = StockControl.readusers(); // get all users from file
		for (StockUser stockUser : user) { // search all user from list.

			if (stockUser.getUsername().equalsIgnoreCase(username)) { // if user found
				System.out.println("enter company symbol"); // company symbols
				String inputsymbol = sc.next();
				DataProcessing.displayAllusers(); // show all users having shares.
				String spath = StockOperations.spath;
				List<Stocks> list = StockControl.readStock(spath); // read all stock info
				for (Stocks stockmodel : list) {
					// search company name using symbol.
					if (stockmodel.companysymbol.equals(inputsymbol)) { // check company using user input symbol
						System.out.println("welcome to " + stockmodel.companyname); // company name
						System.out.println("availabe Share is: " + stockmodel.companyavailableshare); // available
																										// shares
						System.out.println("price per share is: " + stockmodel.shareprice); // share price per share
						System.out.println("no. of share you want?");// user input for buys number of shares.
						int getshare = sc.nextInt();
						// display no. of shares want * actual share price
						System.out.println("your buy" + getshare + " share at " + getshare * stockmodel.shareprice);

						stockmodel.setCompanyavailableshare(stockmodel.companyavailableshare - getshare);// update
																											// stock(remains-buy
																											// shares.
						System.out.println();
						stockUser.setShare(getshare + stockUser.getShare()); // add shares in user file
						Transaction(stockUser, stockmodel, "buy", getshare); // write log entry of transaction
					}
				}
				// update existing users shares and transaction
				StockControl.writeusers(user);
				StockControl.writeStock(list);
			}
		}
	}

	/**
	 * @param stockUser
	 * @param stockmodel
	 * @param status
	 * @param amount
	 */
	// Transaction having sale or buys shares option
	public static void Transaction(StockUser stockUser, Stocks stockmodel, String status, int amount) {
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); // current date
		List<TransactionLog> log = StockControl.readlog(); // read transaction log entry
		// set transaction log entry
		TransactionLog transLog = new TransactionLog();
		transLog.setUsername(stockUser.getUsername()); // set user name
		transLog.setCompanysymbol(stockmodel.getCompanysymbol()); // company symbol
		transLog.setCompanyname(stockmodel.getCompanyname()); // company name
		transLog.setCompanyshares(amount); // shares amount
		transLog.setShareprice(stockUser.getShare() * stockmodel.getShareprice()); // shares price per share
		transLog.setDate(date); // set current date
		switch (status) {
		case "sale":
			transLog.setTransction("sale"); // sale shares
			break;
		case "buy":
			transLog.setTransction("buy"); // buy shares.
			break;
		default:
			break;
		}
		// add log in list and write list
		log.add(transLog);
		StockControl.writelog(log);
	}

	// display transaction log of user
	public static void printreport() {
		System.out.println("\n*******************User Log**********************");
		System.out.println("1-all transaction of users");
		boolean find = false;
		System.out.print("enter the name : "); // transaction of users in list
		String username = sc.next();
		System.out.println();
		List<TransactionLog> log = StockControl.readlog(); // read all transaction from file
		for (TransactionLog transactionLog : log) {
			if (transactionLog.getUsername().equalsIgnoreCase(username)) {
				// display report if find user
				find = true; // transaction found and show
				System.out.println(transactionLog.getUsername() + " " + transactionLog.getCompanyname() + " "
						+ transactionLog.getDate().toString() + " " + transactionLog.getTransction());
			}
		}
		if (!find) { // transaction not found
			System.out.println("no log found....");
		}
	}

	// sales the existing share to company.
	private static void sell() {
		StockOperations.Displaystock(); // all stock display
		System.out.println("username");
		String username = sc.next();
		List<StockUser> user = StockControl.readusers();
		for (StockUser stockUser : user) { // if user found then
			if (stockUser.getUsername().equals(username)) {
				System.out.println("enter company symbol"); // enter company symbol
				String inputsymbol = sc.next();
				String spath = StockOperations.spath;
				List<Stocks> list = StockControl.readStock(spath); // get all stock info
				for (Stocks stockmodel : list) {
					if (stockmodel.companysymbol.equals(inputsymbol)) { // check stock info and input-symbol
						System.out.println("enter share amount");
						int shares = sc.nextInt();
						System.out.println("your shares is : " + shares + "\nper share price: " + stockmodel.shareprice
								+ "\ntotal price is: " + shares * stockmodel.shareprice); // show shares and available
																							// price
						System.out.println("sale successfully.....");
						stockmodel.setCompanyavailableshare(stockmodel.companyavailableshare + shares);

						stockUser.setShare(stockUser.getShare() - shares); // substract and update user data

						Transaction(stockUser, stockmodel, "sale", shares);// set log entry
					}
				}
				// write new user data and stock list
				StockControl.writeusers(user);
				StockControl.writeStock(list);
			}
		}
	}
}
