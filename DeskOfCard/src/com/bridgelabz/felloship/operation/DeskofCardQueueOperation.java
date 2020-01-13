package com.bridgelabz.felloship.operation;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.felloship.linkedlist.Queue;

public class DeskofCardQueueOperation {
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

	static Queue<String> player = new Queue<String>();

	static Object[] ob;

	static int[] input;

	public static void initPlayersDesk() {
		ob = new Object[players];
		input = new int[playcards];
		for (int i = 0; i < ob.length; i++) {
			ob[i] = new Queue<String>();
		}
	}

	// get all possibility's of total cards using rank and suit.
	public static void generateCardCombination() {
		String suit[] = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10 ", "jack", "Queen", "King", "Ace" };

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

		initPlayersDesk();

		generateCardCombination();

		for (int i = 0; i < players; i++) {
			@SuppressWarnings("unchecked")
			Queue<String> list = (Queue<String>) ob[i];
			for (int j = 0; j < playcards; j++) {
				int card = generteRandomCards();
				input[j] = card;
			}
			sort(); // get sorted random cards number
			for (int card : input) {
				list.enqueue(carddesk[card]);
			}

		}
		showPlayersCard(); // show sorted cards

	}

	public static int generteRandomCards() {
		int card;
		do {
			SecureRandom rand = new SecureRandom();
			card = rand.nextInt(52); //get random numbers between 0-51
		} while (check.contains(card)); //if random number is in list then again generate
		return card;
	}

	public static void sort() { // sort card array of player
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
	}

	//show all cards
	public static void showPlayersCard() {
		for (int i = 0; i < ob.length; i++) {
			System.out.println("\nplayer " + (i + 1));
			@SuppressWarnings("unchecked")
			Queue<String> list = (Queue<String>) ob[i];
			list.show();

		}
	}
}
