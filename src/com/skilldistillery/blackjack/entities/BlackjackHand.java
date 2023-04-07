package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	private List<Card> hand;
	private Deck deck;
	
	public BlackjackHand() {
		hand = new ArrayList<>();
		deck = new Deck();
	}
	
	@Override
	public int getHandValue(Player player) {
		int handValue = 0;
//		for (Card card : hand) {
//			handValue += card.getValue();
//		}
		return handValue;
	}
	
	public boolean isBlackjack(Player player) {
		boolean isBlackjack = false;
//		if (player.getHandValue() )
		return isBlackjack;
	}
	
	public boolean isBust() {
		boolean isBust = false;
		return isBust;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
}
