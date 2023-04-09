package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.*;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		welcomeMsg();

		Player theDealer = new Dealer();
		Player user = new Player();

		boolean isPlaying = true;
		do {
			((Dealer) theDealer).getDeck().shuffle();
			initialDeal(theDealer, user);
			if (user.getBlackjackHand().isBlackjack()) {
				System.out.println("\n* * * Blackjack! Let's hope the Dealer's hand is less than 21.");
				revealDealerHand(theDealer);
			} else if (user.getBlackjackHand().isBust()) {
				System.out.println("\n* * * Busted! Let's find out if the Dealer had better luck.");
				revealDealerHand(theDealer);
			} else {
				hitOrStay(theDealer, user, sc);
				dealersTurn(theDealer);
			}

			determineWinner(theDealer, user);
			isPlaying = anotherRoundIqry(theDealer, user, isPlaying, sc);
			theDealer.getBlackjackHand().clear();
			user.getBlackjackHand().clear();
		} while (isPlaying);

		System.out.println("\nGoodbye.");

		sc.close();
	}

	public void welcomeMsg() {
		System.out.println(
				"* * * * * * * * * * * * * * * * *    Welcome to the Blackjack App!   * * * * * * * * * * * * * * * * *");
		System.out.println(
				"* * * *  The objective is to obtain a hand value higher than the Dealer's, without busting 21. * * * *");
		System.out.println(
				"* *    At the start of each round, the Dealer will deal two cards each, to you and to themself.    * *");
		System.out.println(
				"* Both of your cards will be dealt face up, but only the Dealer's second card will be dealt face up. *");
		System.out.println(
				"* * * * * * * *   Throughout play, Ace cards will have a fixed value of 11 (high).   * * * * * * * * *");
	}

	public void initialDeal(Player theDealer, Player user) {
		((Dealer) theDealer).dealInitialCards(user, "first");
		viewHand(user);
		System.out.println("> The first card dealt to the Dealer's hand is face down.");
		((Dealer) theDealer).dealInitialCards(user, "second");
		viewHand(user);
		((Dealer) theDealer).viewKnownCard();

	}

	public void viewHand(Player playerToViewHand) {
		if (playerToViewHand instanceof Dealer) {
			System.out.print("> Dealer's hand: ");
		} else {
			System.out.print("> Your hand: ");
		}
		playerToViewHand.viewCards();
	}

	public void revealDealerHand(Player theDealer) {
		System.out.println("\nHere's the Dealer's complete hand as dealt:");
		viewHand(theDealer);
	}

	public void hitOrStay(Player theDealer, Player user, Scanner sc) {
		boolean keepLooping = true;
		do {
			System.out.println("\nDo you want to ...\n" + "1. Hit (receive another card from the deck) or, \n"
					+ "2. Stay (surrender turn to the Dealer)");
			boolean validResponse = false;
			do {
				System.out.print("Please enter '1' to Hit or '2' to Stay: ");
				String userResponse = sc.next();
				switch (userResponse) {
				case "1":
				case "'1'":
					if (((Dealer) theDealer).getDeck().checkDeckSize() > 0) {
						System.out.println("\nDealing ...");
						((Dealer) theDealer).dealACard(user);
						viewHand(user);
						validResponse = true;
					} else {
						System.out.println("The deck is empty. You must Stay.");
						validResponse = true;
						keepLooping = false;
					}
					break;
				case "2":
				case "'2'":
					keepLooping = false;
					validResponse = true;
					break;
				default:
					System.out.println("\nInvalid response.");
				}
				sc.nextLine();
			} while (!validResponse);
			if (user.getBlackjackHand().isBlackjack()) {
				System.out.println("\n* * * Blackjack! Although the Dealer is still in the game.");
				keepLooping = false;
			} else if (user.getBlackjackHand().isBust()) {
				System.out.println("\n* * * Oh no, your hand is bust! It's the Dealer's turn now.");

				keepLooping = false;
			}
		} while (keepLooping);
	}

	public void dealersTurn(Player theDealer) {
		revealDealerHand(theDealer);
		boolean underSeventeen = true;
		do {
			if (theDealer.getBlackjackHand().getHandValue() >= 17) {
				underSeventeen = false;
			} else {
				System.out.println(
						"\nSince the Dealer's hand value is less than 17, " + "the Dealer will draw another card.");
				((Dealer) theDealer).dealACard(theDealer);
				viewHand(theDealer);
				if (theDealer.getBlackjackHand().getHandValue() > 21) {
					System.out.println("* * * The Dealer busted their hand.");
					underSeventeen = false;
				} else if (theDealer.getBlackjackHand().getHandValue() == 21) {
					System.out.println("\n* * * The Dealer has Blackjack!");
					underSeventeen = false;
				}
			}
		} while (underSeventeen);
	}

	public void determineWinner(Player theDealer, Player user) {
		System.out.println("\nLet's compare hands ...");
		int dealerHandValue = theDealer.getBlackjackHand().getHandValue();
		int userHandValue = user.getBlackjackHand().getHandValue();
		if ((userHandValue <= 21) && (dealerHandValue <= 21)) {
			if (userHandValue > dealerHandValue) {
				System.out.println("* * * Congratulations! You won this round with " + userHandValue
						+ " points compared to the Dealer's " + dealerHandValue + " points!");
			} else if (dealerHandValue > userHandValue) {
				System.out.println("* * * The Dealer wins this round with " + dealerHandValue + " points, besting your "
						+ userHandValue + " points. Better luck next time!");
			} else {
				if (userHandValue == 21) {
					System.out.println("Both you and the Dealer tied with 21!");
				} else {
					System.out.println("* * * It's a tie with " + userHandValue + ". Round over.");
				}
			}
		} else {
			if ((userHandValue < dealerHandValue) && (userHandValue <= 21)) {
				System.out.println("You won since only the Dealer bust!");
			} else if ((dealerHandValue < userHandValue) && (dealerHandValue <= 21)) {
				System.out.println("You lost this round as the only Player to bust.");
			} else {
				System.out.println("You and the Dealer are both bust! This round is a tie.");
			}
		}
	}

	public boolean anotherRoundIqry(Player theDealer, Player user, boolean isPlaying, Scanner sc) {
		if (((Dealer) theDealer).getDeck().checkDeckSize() > 12) {
			boolean validResponse = false;
			do {
				System.out.print("Do you want to play another round? Y/N: ");
				String userResponse = sc.next();
				switch (userResponse) {
				case "Y":
				case "'Y'":
				case "y":
				case "'y'":

					validResponse = true;
					break;
				case "N":
				case "'N'":
				case "n":
				case "'n'":
					isPlaying = false;
					validResponse = true;
					break;
				default:
					System.out.println(
							"Invalid response. Please enter 'Y' to play another round, " + "or 'N' to end the game.");
				}
				sc.nextLine();
			} while (!validResponse);
		} else {
			System.out.println("\nThere aren't enough cards in the deck to continue the game.");
			isPlaying = false;
		}
		return isPlaying;
	}

}
