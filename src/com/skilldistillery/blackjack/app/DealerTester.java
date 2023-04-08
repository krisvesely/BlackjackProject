package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.*;

public class DealerTester {

	public static void main(String[] args) {
		DealerTester dealer = new DealerTester();
		dealer.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		Deck dealersDeck = new Deck();
//		int numCardsInDeck = dealersDeck.checkDeckSize();
//		dealersDeck.shuffle();
		
		List<Card> hand = new ArrayList<>();
		int reqCardQty = 0;
		int cardsSum = 0;

		System.out.println(dealersDeck.checkDeckSize() + " cards in the Dealer's deck.\n");

		boolean validEntry = false;
		do {
			System.out.println("How many cards do you want? ");
			try {
				reqCardQty = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid entry. Please enter a whole number.");
			}

			if (reqCardQty <= dealersDeck.checkDeckSize()) {
				validEntry = true;
			} else {
				System.out.println("Invalid entry. There are only 52 cards in a deck.");
			}
		} while (!validEntry);

		for (int dealtCardQty = 0; dealtCardQty < reqCardQty; dealtCardQty++) {
			Card playersCard = dealersDeck.dealCard();
			hand.add(playersCard);
			System.out.println(playersCard);
			cardsSum += playersCard.getValue();
		}
		System.out.println("Total value of all cards: " + cardsSum);
		System.out.println("\n" + dealersDeck.checkDeckSize() + " cards remaining in the Dealer's deck.");
		sc.close();
	}
}
