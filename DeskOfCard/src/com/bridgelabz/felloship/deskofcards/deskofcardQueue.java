package com.bridgelabz.felloship.deskofcards;

import java.util.Scanner;

import com.bridgelabz.felloship.operation.DeskofCardQueueOperation;

public class deskofcardQueue {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter numbers of players");
		DeskofCardQueueOperation.players = sc.nextInt();
		System.out.println("Amount of cards to distribute " + DeskofCardQueueOperation.players + " players");
		DeskofCardQueueOperation.playcards = sc.nextInt();
		
		DeskofCardQueueOperation.playerscards();

		
	}
}
