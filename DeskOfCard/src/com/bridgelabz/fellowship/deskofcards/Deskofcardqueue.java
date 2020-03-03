package com.bridgelabz.fellowship.deskofcards;

import java.util.Scanner;

import com.bridgelabz.fellowship.operation.Deskofcardqueueoperation;

public class Deskofcardqueue {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter numbers of players");
		Deskofcardqueueoperation.players = sc.nextInt(); // numbers of players
		System.out.println("Amount of cards to distribute " + Deskofcardqueueoperation.players + " players");
		Deskofcardqueueoperation.playcards = sc.nextInt(); // numbers of each players cards
		Deskofcardqueueoperation.PlayersCards();

	}
}
