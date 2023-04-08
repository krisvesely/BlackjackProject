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
//		sgetHand().add(getDeck().dealCard());
//		player.getHand().add(getDeck().dealCard());
	}
	
	public void viewKnownCards(Player dealer) {
//		System.out.println(dealer.getHand().get(1).toString());
//		System.out.println("Hand value: " + ((BlackjackHand) getHand()).getSingleCardValue(1));
	}
	
//	public void viewCards() {
//		for (Card card : hand) {
//			System.out.println(card.toString());
//			System.out.println("Hand value: " + ((BlackjackHand) hand).getHandValue());
//		}
//	}
	
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
