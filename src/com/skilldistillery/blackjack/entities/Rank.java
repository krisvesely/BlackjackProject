package com.skilldistillery.blackjack.entities;

public enum Rank {
	TWO(2, "Two"),
	THREE(3, "Three"),
	FOUR(4, "Four"),
	FIVE(5, "Five"),
	SIX(6, "Six"),
	SEVEN(7, "Seven"),
	EIGHT(8, "Eight"),
	NINE(9, "Nine"),
	TEN(10, "Ten"),
	JACK(10, "Jack"),
	QUEEN(10, "Queen"),
	KING(10, "King"),
	ACE(11, "Ace");
	

	final private int rank;
	final private String name;
	
//	Rank(int theRank) {
//		this.rank = theRank;
//	}
	
	Rank(int theRank, String theName) {
		this.rank = theRank;
		this.name = theName;
	}
	
	public int getValue() {
		return rank;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
