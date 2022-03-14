package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackJackApp {
	private char a = '\u2660';
	private char b = '\u2662';
	private char c = '\u2665';
	private char d = '\u2667';

	Dealer dealer = new Dealer();
	Player player = new Player();
	Deck deck = new Deck();
	BlackJackHand hand = new BlackJackHand();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		BlackJackApp BJA = new BlackJackApp();
		BJA.run();

	}

	public void displayMenu() {
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-");
		System.out.println("Welcome to BlackJack ");
		System.out.print(a);
		System.out.print(b);
		System.out.print(c);
		System.out.print(d);
		System.out.println("\n");
		System.out.println("What would you like to do?");
		System.out.println("1. Start game");
		System.out.println("2. Exit program");
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-");
		int start = kb.nextInt();

		if (start == 1) {
			startGame();
		} else if (start == 2) {
			System.out.println("Goodbye");

		} else {
			System.out.println("invalid, Please enter either 1 or 2");
		}
	}

	private void startGame() {

		deck.createDeck();
		System.out.println("Now dealing!");
		System.out.println("...");
		player.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
		System.out.println("Your hand " + player.getHand() + "  " + player.getHand().getHandValue());
		dealer.getHand().addCard(deck.dealCard());
		System.out.println();
		System.out.println("The dealers face card " + dealer.getHand() + " " + dealer.getHand().getHandValue());
		dealer.getHand().addCard(deck.dealCard());
		System.out.println();

		if (player.getHand().isBLackJack() && dealer.getHand().isBLackJack()) {
			System.out.println("Push, no one wins this hand");
			playAgain();
		} else if (player.getHand().isBLackJack()) {
			System.out.println("You got Blackjack! You win the hand");
			playAgain();
		} else if (dealer.getHand().isBLackJack()) {
			System.out.println("The dealer got BlackJack! " + dealer.getHand() + " " + dealer.getHand().getHandValue());

			System.out.println("you lose the hand");

			playAgain();
		}
		hitOrStay();

	}

	private void run() {

		displayMenu();

	}

	public void hitOrStay() {

		System.out.println("-----------------------");
		System.out.println("Would you like to Hit (Y/N)");
		switch (kb.next()) {
		case "Y":
		case "y":
			hit();

			break;
		case "N":
		case "n":
			stay();
		}

	}

	public void hit() {

		player.getHand().addCard((deck.dealCard()));
		System.out.println("You added a card to your hand");
		System.out.println("Your new hand " + player.getHand() + "  " + player.getHand().getHandValue());
		if (player.getHand().getHandValue() < 21) {
			hitOrStay();
		} else if (player.getHand().getHandValue() > 21) {
			System.out.println("Uh-Oh, you bust!!");
			playAgain();
		} else {
			stay();
		}
	}

	public void stay() {
		System.out.println("The dealers hand " + dealer.getHand() + " " + dealer.getHand().getHandValue());

		if (dealer.getHand().getHandValue() < 17) {

			dealer.getHand().addCard(deck.dealCard());
			System.out.println("...");
			System.out.println("The dealer added another card");
			stay();

		} else if (dealer.getHand().getHandValue() > 21) {
			System.out.println();
			System.out.println("The dealer bust! You win the hand");
			playAgain();
		} else {
			calculateWinner();
		}
	}

	public void playAgain() {
		System.out.println("\n Would you like to play again? (Y/N)");
		switch (kb.next()) {
		case "Y":
		case "y":

			player.getHand().clearHand();
			dealer.getHand().clearHand();
			startGame();

			break;
		case "N":
		case "n":
			System.out.println("Thanks for Playing!");
			break;
		}
	}

	public void calculateWinner() {
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("Your total hand " + player.getHand() + "  " + player.getHand().getHandValue());

			System.out.println();
			System.out.println("THE DEALER WON THE HAND! You should probably have another drink...");
		} else if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println("CONGRATS, YOU WIN THE HAND!");
		} else if ((dealer.getHand().getHandValue() == player.getHand().getHandValue()))
			System.out.println("Push, no one wins this time");
		System.out.println("-----------------------");
		playAgain();
	}
}
