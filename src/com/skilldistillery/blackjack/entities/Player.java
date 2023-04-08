package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private BlackjackHand hand;
	
	public Player() {
		setHand();
	}
	
	public void viewCards() {
		for (Card card : ((BlackjackHand) hand).getHand()) {
			System.out.print(card.toString() + ", ");	
		}
		System.out.println("\nPlayer's hand value: " + ((BlackjackHand) hand).getHandValue());
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand() {
		hand = new BlackjackHand();
	}

	
	
	
}
