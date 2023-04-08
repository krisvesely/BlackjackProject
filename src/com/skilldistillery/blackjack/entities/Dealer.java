package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer extends Player {
	private Deck deck;
	
	public Dealer() {
		super();
		setDeck(new Deck());
		deck.shuffle();
	}
	
	public void dealCards(Player player) {
		dealAll(player);
		dealAll(player);
	};
	
	public void dealAll(Player player) {
		getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
	}
	
	public void viewKnownCards() {
		System.out.println("Dealer's visible card: " + ((BlackjackHand) getHand()).getCard(1).toString());
		System.out.println("Dealer's visible hand value: " + ((BlackjackHand) getHand()).getSingleCardValue(1));
	}
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
