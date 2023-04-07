package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	final private String suit;

	Suit(String theSuit) {
		this.suit = theSuit;
	}
	
	@Override
	public String toString() {
		return suit;
	}
}
