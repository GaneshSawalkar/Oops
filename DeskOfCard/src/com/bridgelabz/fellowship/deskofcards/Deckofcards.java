package com.bridgelabz.fellowship.deskofcards;

import java.util.Scanner;

import com.bridgelabz.fellowship.operation.Operations;

public class Deckofcards {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("enter numbers of players");
		Operations.players = sc.nextInt(); // numbers of players
		System.out.println("Amount of cards to distribute " + Operations.players + " players");
		Operations.playcards = sc.nextInt(); // numbers of cards for each player

		Operations.PlayersCards();
		Operations.ShowPlayersCard();

	}

}