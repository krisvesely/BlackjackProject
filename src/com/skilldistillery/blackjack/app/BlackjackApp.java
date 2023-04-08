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
		System.out.println("* * * * * * * * * * * * * * * * *    Welcome to the Blackjack App!   * * * * * * * * * * * * * * * * *");
		System.out.println("* *    At the start of each round, the Dealer will deal two cards each, to you and to themself.    * *");
		System.out.println("* Both of your cards will be dealt face up, but only the Dealer's second card will be dealt face up. *");
		System.out.println("* * * * * * * *   Throughout play, Ace cards will have a fixed value of 11 (high).   * * * * * * * * *");
				
		Player theDealer = new Dealer();
		Player user = new Player();

		boolean isPlaying = true;
		do {
			initialDeal(theDealer, user);
			if (user.getBlackjackHand().isBlackjack()) {
				System.out.println("\n* * * Blackjack! Congratulations - you won this round!");
			} else if (user.getBlackjackHand().isBlackjack()) {
				System.out.println("\n* * * Busted! Your hand exceeds 21. Round over.");
			} else {
				boolean ifStay = hitOrStay(theDealer, user, sc);
				if (ifStay) {
				dealersTurn(theDealer);
				}
				if (theDealer.getBlackjackHand().getHandValue() < 21 && user.getBlackjackHand().getHandValue() < 21) {
					determineWinner(theDealer, user);
				}
			}
			isPlaying = anotherRoundIqry(theDealer, user, isPlaying, sc);
			theDealer.getBlackjackHand().clear();
			user.getBlackjackHand().clear();
		} while (isPlaying);

		System.out.println("\nGoodbye.");

		sc.close();
	}

	public void initialDeal(Player theDealer, Player user) {
		System.out.println("\nThe Dealer will now deal the first two cards to each Player.");
		((Dealer) theDealer).dealInitialCards(user);
		System.out.print("\n> Your hand: ");
		user.viewCards();
		((Dealer) theDealer).viewKnownCards();

	}

	public boolean hitOrStay(Player theDealer, Player user, Scanner sc) {
		boolean stillInPlay = true;
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
					System.out.println("\nDealing ...");
					Card newUserCard = ((Dealer) theDealer).getDeck().dealCard();
					user.getBlackjackHand().addCard(newUserCard);
					System.out.print("> Your hand: ");
					user.viewCards();
					validResponse = true;
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
				System.out.println("\n* * * Blackjack! You won this round!");
				stillInPlay = false;
				keepLooping = false;
			}
			else if (user.getBlackjackHand().isBust()) {
				System.out.println("\n* * * Oh no, you busted your hand! The Dealer wins this round.");
				stillInPlay = false;
				keepLooping = false;
			}
		} while (keepLooping);
	return stillInPlay;
	}

	public void dealersTurn(Player theDealer) {
		System.out.println("\nHere's the Dealer's complete hand as dealt:");
		System.out.print("> Dealer's hand: ");
		theDealer.viewCards();
		boolean underSeventeen = true;
		do {
			if (theDealer.getBlackjackHand().getHandValue() >= 17) {
				underSeventeen = false;
			} else {
				System.out.println(
						"\nSince the Dealer's hand value is less than 17, " + "the Dealer will draw another card.");
				Card newDealerCard = ((Dealer) theDealer).getDeck().dealCard();
				theDealer.getBlackjackHand().addCard(newDealerCard);
				System.out.print("> Dealer's hand: ");
				theDealer.viewCards();
				if (theDealer.getBlackjackHand().getHandValue() > 21) {
					System.out.println("* * * The Dealer busted their hand. You win this round!");
					underSeventeen = false;
				}
				else if (theDealer.getBlackjackHand().getHandValue() == 21) {
					System.out.println("\n* * * The Dealer has Blackjack! You lost this round.");
					underSeventeen = false;
				}
			}
		} while (underSeventeen);
	}

	public void determineWinner(Player theDealer, Player user) {
		System.out.println("\nLet's compare hands ...");
		int dealerHandValue = theDealer.getBlackjackHand().getHandValue();
		int userHandValue = user.getBlackjackHand().getHandValue();
		if (userHandValue > dealerHandValue) {
			System.out.println("* * * Congratulations! You won this round!");
		} else if (dealerHandValue > userHandValue) {
			System.out.println("* * * The Dealer wins this round. Better luck next time!");
		} else {
			System.out.println("* * * It's a tie. Round over.");
		}
	}

	public boolean anotherRoundIqry(Player theDealer, Player user, boolean isPlaying, Scanner sc) {
		if (((Dealer) theDealer).getDeck().checkDeckSize() > 6) {
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
