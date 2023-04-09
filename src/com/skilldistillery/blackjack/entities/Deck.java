package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		setDeck(buildDeck());
	}

	public List<Card> buildDeck() {
		deck = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card aCard = new Card(suit, rank);
				deck.add(aCard);
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		Card dealtCard = deck.remove(0);
		return dealtCard;
	}

	public void shuffle() {
		System.out.println("\nShuffling ... ");
		Collections.shuffle(deck);
	}

//	public List<Card> getDeck() {
//		return deck;
//	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

}
