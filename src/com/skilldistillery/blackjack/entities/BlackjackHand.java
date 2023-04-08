package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	private int handValue;
	
	public BlackjackHand() {
		super();
		handValue = 0;
	}
	
	public int getSingleCardValue(int handIndex) {
		int handValue = getHand().get(handIndex).getValue();
		return handValue;
	}
	
	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : getHand()) {
			handValue += card.getValue();
		}
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

}
