package com.bridgelabz.felloship.deskofcards;

import java.util.Scanner;

import com.bridgelabz.felloship.operation.operations;

public class deckofcards {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("enter numbers of players");
		operations.players = sc.nextInt();
		System.out.println("Amount of cards to distribute " + operations.players + " players");
		operations.playcards = sc.nextInt();
		operations.playerscards();
		
		//show players cards
		 operations.showPlayersCard();
		//System.out.println(operations.check);
	}

}