package com.bridgelabz.felloship.operation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class inputvalidation {
	public static Scanner scanner = new Scanner(System.in);

	public static int isvalidInteger() {
		int i = 0;
		boolean ok = true;
		while (ok) {
			try {

				i = scanner.nextInt();
				ok = false;
			} catch (InputMismatchException e) {
				System.out.println("Not integer value.");
				System.out.print("select again: ");
				scanner.next();
			}
		}

		return i;
	}

	public static String isStringInt(String integer) {
		try {
			int check = Integer.parseInt(integer);
		} catch (NumberFormatException e) {
			System.out.println("invalid format enter again:");
			integer = isStringInt(scanner.next());
		}
		return integer;
	}

	public static String isString() {
		String input;
		boolean flag = false;
		do {
			input = scanner.next();
			if (input.matches("^[a-zA-Z]*$")) {
				flag = true;
			} else {
				System.out.print("Wrong input..! type again :");
			}
		} while (!flag);
		return input;
	}
}
