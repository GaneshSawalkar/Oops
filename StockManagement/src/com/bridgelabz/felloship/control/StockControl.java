package com.bridgelabz.felloship.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.felloship.model.StockUser;
import com.bridgelabz.felloship.model.Stocks;
import com.bridgelabz.felloship.model.TransactionLog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockControl {
	static ObjectMapper mapper = new ObjectMapper();
	List<StockUser> user = new ArrayList<StockUser>();

	/**
	 * @return transaction logs
	 */
	public static List<TransactionLog> readlog() {
		String userpath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/datafiles/log.json";
		List<TransactionLog> users = null;
		try {
			// transaction log read
			users = mapper.readValue(new File(userpath), new TypeReference<List<TransactionLog>>() {
			});

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;

	}

	/**
	 * @param logentry list user log list for write.
	 */
	public static void writelog(List<TransactionLog> logentry) {
		String userpath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/datafiles/log.json";
		try {
			// transactions log write
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(userpath), logentry);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return all-users list to user
	 */
	public static List<StockUser> readusers() {
		String userpath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/datafiles/users.json";
		List<StockUser> users = null;
		try {
			// read users all-users from file

			users = mapper.readValue(new File(userpath), new TypeReference<List<StockUser>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * @param newentrylist new user entry list for write.
	 */
	public static void writeusers(List<StockUser> newentrylist) {
		String userpath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/datafiles/users.json";
		try {
			// writes new users in files
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(userpath), newentrylist);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param spath stock file path
	 * @return all stock information
	 */
	public static List<Stocks> readStock(String spath) {
		String spat = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/datafiles/stockinventory.json";
		List<Stocks> list = null;
		try {
			// red stock info
			list = mapper.readValue(new File(spat), new TypeReference<List<Stocks>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @param list user define list for write.
	 */
	// write stock info
	public static void writeStock(List<Stocks> list) {
		String spath = "/home/admin1/Desktop/JavaProject/StockManagement/src/com/bridgelabz/felloship/datafiles/stockinventory.json";
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
