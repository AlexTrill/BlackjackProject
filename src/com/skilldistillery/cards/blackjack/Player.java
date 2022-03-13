package com.skilldistillery.cards.blackjack;

public class Player {

	private BlackJackHand hand = new BlackJackHand();

	public BlackJackHand getHand() {
		return hand;

	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}
	
}
