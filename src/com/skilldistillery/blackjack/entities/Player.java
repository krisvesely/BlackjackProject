package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private BlackjackHand bHand;

	public Player() {
		setBlackjackHand();
	}

	public void viewCards() {
		for (int cardIndex =0; cardIndex < bHand.getHand().size(); cardIndex++) {
			if ((cardIndex + 1) < bHand.getHand().size()) {
			System.out.print(getBlackjackHand().getCard(cardIndex).toString() + ", ");
			}
			else {
			System.out.print(getBlackjackHand().getCard(cardIndex).toString());	
			}
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
