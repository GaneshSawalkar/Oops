package com.bridgelabz.fellowship.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.fellowship.model.Stockuser;
import com.bridgelabz.fellowship.model.Stocks;
import com.bridgelabz.fellowship.model.Transactionlog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Stockcontrol {
	static ObjectMapper mapper = new ObjectMapper();
	List<Stockuser> user = new ArrayList<Stockuser>();

	/**
	 * @return transaction logs
	 */
	public static List<Transactionlog> readLog() {
		String userpath = "src/com/bridgelabz/fellowship/datafiles/log.json";
		List<Transactionlog> users = null;
		try {
			// transaction log read
			users = mapper.readValue(new File(userpath), new TypeReference<List<Transactionlog>>() {
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
	public static void writeLog(List<Transactionlog> logentry) {
		String userpath = "src/com/bridgelabz/fellowship/datafiles/log.json";
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
	public static List<Stockuser> readUsers() {
		String userpath = "src/com/bridgelabz/fellowship/datafiles/users.json";
		List<Stockuser> users = null;
		try {
			// read users all-users from file

			users = mapper.readValue(new File(userpath), new TypeReference<List<Stockuser>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * @param newentrylist new user entry list for write.
	 */
	public static void writeUsers(List<Stockuser> newentrylist) {
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
		String spat = "src/com/bridgelabz/fellowship/datafiles/stockinventory.json";
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
		String spath = "src/com/bridgelabz/felloship/datafiles/stockinventory.json";
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(spath), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
