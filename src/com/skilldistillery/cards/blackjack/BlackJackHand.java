package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Hand;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() { // value of hand
		int totalValue = 0;
		for (int i = 0; i < getHand().size(); i++) {
			totalValue += getHand().get(i).getValue();
		}
		return totalValue;
	}

	BlackJackHand() {
		super();
	}

	public boolean isBLackJack() {
		// if value is 21 return true
		boolean option = true;
		if (getHandValue() == 21) {
			option = true;
		} else {
			option = false;
		}
		return option;

	}

	public boolean isBust() {
		// if value is over 21 return true.
		boolean option = true;
		if (getHandValue() > 21) {
			option = true;
			return option;
		} else {
			option = false;

			return option;

		}
	}
}
