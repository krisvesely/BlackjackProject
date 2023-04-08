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
		System.out.println("Welcome to the Blackjack App!");
		System.out.println("The Dealer will now deal two cards to you and two to themself.\n"
				+ "Both of your cards will be dealt face up, but only the Dealer's second "
				+ "card will be dealt face up.\n"
				+ "Throughout play, Aces will have a fixed value of 11 (high).");
		
		Player theDealer = new Dealer();
		Player user = new Player();
		
		boolean isPlaying = true;
		do {
			initialDeal(theDealer, user);
			if (user.getBlackjackHand().isBlackjack()) {
				System.out.println("Congratulations! You won the first round!");
			}
			else if(user.getBlackjackHand().isBlackjack())
			determineWinner(theDealer, user);
			anotherRoundIqry(isPlaying, sc);
			
			
			
		} while (isPlaying);
		sc.close();
	}
	
	public void initialDeal(Player theDealer, Player user) {
		System.out.println("The Dealer will now ");
		((Dealer) theDealer).dealInitialCards(user);	
		((Dealer) theDealer).viewKnownCards();
		System.out.print("Player's cards: ");
		user.viewCards();
	}
	
	public Player determineWinner(Player theDealer, Player user) {
		Player theWinner = null;
		return theWinner;
	}
	
	public boolean anotherRoundIqry(boolean isPlaying, Scanner sc) {
		return isPlaying;
	}

}
