package com.skilldistillery.blackjack.entities;

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
		handValue = 0;
		for (Card card : getHand()) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public boolean isBlackjack() {
		boolean isBlackjack = false;
		if (getHandValue() == 21) {
			isBlackjack = true;
		}
		return isBlackjack;
	}

	public boolean isBust() {
		boolean isBust = false;
		if (getHandValue() > 21) {
			isBust = true;
		}
		return isBust;
	}

}
