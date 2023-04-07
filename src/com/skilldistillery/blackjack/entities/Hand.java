package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		
	}
	public void clear() {
		for (Card card : hand) {
			hand.remove(card);
		}
	}
	
	public abstract int getHandValue(Player player);

	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
	
}
