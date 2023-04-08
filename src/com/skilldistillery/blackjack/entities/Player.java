package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private BlackjackHand hand;
	
	public Player() {
		setHand();
	}
	
	public void viewCards(Player player) {
//		for (Card card : player.getHand()) {
//			System.out.println(card.toString());
//			System.out.println("Hand value: " + ((BlackjackHand) hand).getHandValue());
//		}
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand() {
		hand = new BlackjackHand();
	}

	
	
	
}
