package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.*;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.run();
	}
	
	public void run() {
		Player dealer = new Dealer();
		Player player = new Player();
		
		((Dealer) dealer).dealCards(player);	

		((Dealer) dealer).viewKnownCards();
		System.out.print("Player's cards: ");
		player.viewCards();
		// A Dealer will deal cards
		boolean adequateDeck = true;
		do {
			
		} while (adequateDeck);
		// determine a winner for this round (loop the app b/w rounds)
		
	}
	
	public Player determineWinner() {
		Player theWinner = null;
		return theWinner;
	}

}
