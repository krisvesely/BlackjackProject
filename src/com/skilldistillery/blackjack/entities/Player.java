package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private BlackjackHand bHand;

	public Player() {
		setBlackjackHand();
	}

	public void viewCards() {
		for (Card card : (bHand.getHand())) {
			System.out.print(card.toString() + ", ");
		}
		System.out.println("\nTotal hand value: " + bHand.getHandValue());
	}

	public BlackjackHand getBlackjackHand() {
		return bHand;
	}

	public void setBlackjackHand() {
		bHand = new BlackjackHand();
	}
}
