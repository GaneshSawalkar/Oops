package com.bridgelabz.felloship.operation;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class operations {
	// different types of cards
	static String suit[] = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10 ", "jack", "Queen", "King", "Ace" };
	// take input from users no. of players and distribute cards
	public static int players = 0;
	public static int playcards = 0;
	// total card are 52
	final static int totalcards = 52;
	// initialized desk with 52 cards
	static String carddesk[] = new String[52];
	// store alloted players cards in 2d array
	static String allotcards[][] = new String[playcards][players];
	public static List<Integer> check = new ArrayList<Integer>();

	// get all possibility's of total cards using rank and suit.
	public static void generateCardCombination() {
		int cnt = 0;
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				{
					carddesk[cnt] = suit[i] + " " + rank[j];
					cnt++;
				}
			}
		}
	}

	public static void playerscards() {
		allotcards = new String[playcards][players];
		if (totalcards >= (playcards * players)) {
			generateCardCombination();
			for (int i = 0; i < playcards; i++) {
				int j = 0;
				shuffleCards(i, j);
			}
		} else {
			System.out.println("desk having 52 cards only....");
		}

	}

//shuffle cards if repeated else allot
	public static void shuffleCards(int i, int j) {
		while (j < players) {
			int x = getRandomCard();
			allotcards[i][j] = carddesk[x];
			check.add(x);
			j++;
		}

	}

	// distribute cards to players
	public static int getRandomCard() {
		int randomInt;
		do {
			SecureRandom rand = new SecureRandom();
			randomInt = rand.nextInt(52);
		} while (check.contains(randomInt));
		return randomInt;
	}

	// display cards..
	public static void showPlayersCard() {
		for (int i = 0; i < playcards; i++) {
			for (int j = 0; j < players; j++) {
				if (allotcards[i][j] != null)
					System.out.print(allotcards[i][j] + "  | ");
			}
			System.out.println();
		}
	}

}