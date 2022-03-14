package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class Dealer {
	Deck deck = new Deck();
	BlackJackHand hand = new BlackJackHand();

	public BlackJackHand getHand() {
		return hand;

	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

	public void deal() {
	

	}
}