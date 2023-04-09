package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		super();
		setDeck(new Deck());
	}

	public void dealInitialCards(Player user, String count) {
		System.out.println("\nDealing the " + count + " cards to each Player ...");
		dealAll(user);
	}

	public void dealAll(Player user) {
		getBlackjackHand().addCard(deck.dealCard());
		user.getBlackjackHand().addCard(deck.dealCard());
	}

	public void dealACard(Player aPlayer) {
		aPlayer.getBlackjackHand().addCard(deck.dealCard());
	}

	public void viewKnownCard() {
		System.out.println("> Dealer's visible (second dealt) card: " + getBlackjackHand().getCard(1).toString());
		System.out.println("Dealer's visible hand value: " + getBlackjackHand().getSingleCardValue(1));
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
