package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		super();
		setDeck(new Deck());
		deck.shuffle();
	}

	public void dealInitialCards(Player user) {
		dealAll(user);
		dealAll(user);
	};

	public void dealAll(Player user) {
		getBlackjackHand().addCard(deck.dealCard());
		user.getBlackjackHand().addCard(deck.dealCard());
	}

	public void viewKnownCards() {
		System.out.println("\n> Dealer's visible (second dealt) card: " + getBlackjackHand().getCard(1).toString());
		System.out.println("Dealer's visible hand value: " + getBlackjackHand().getSingleCardValue(1));
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
