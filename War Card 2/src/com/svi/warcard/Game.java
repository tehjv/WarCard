package com.svi.warcard;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Game {

	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS
	};

	public enum Rank {
		Ace(14), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(
				12), King(13);

		private int value;

		Rank(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	};

	Deck deck;
	private ArrayList<Player> players = new ArrayList<Player>();

	Game() {
		start();
	}

	private void start() {
		System.out.println("*****WELCOME TO WAR CARD*****\n\n");
		System.out.println("Please enter number of Players: ");
		Scanner sc = new Scanner(System.in);
		int playerNumber = 0;
		int numberOfShuffle = 0;
		playerNumber = sc.nextInt();
		while (playerNumber > 52 || playerNumber < 2) {
			System.out.println("Please only enter a value from 2 to 52");
			playerNumber = sc.nextInt();
		}

		for (int x = 1; x <= playerNumber; x++) {
			addPlayer(new Player(x));

		}
		System.out.println("Please enter number of Shuffle: ");
		numberOfShuffle = sc.nextInt();
		while (numberOfShuffle < 1) {
			System.out.println("Please only enter a value greater than 0");
			numberOfShuffle = sc.nextInt();
		}
		sc.close();
		deck = new Deck();
		System.out.println(getDeck().toString());

		shuffle(numberOfShuffle);
		System.out.println("\n");
		System.out.println(getDeck().toString());

	}

	private void shuffle(int numberOfShuffle) {
		for(int i=0;i<numberOfShuffle;i++){
			basicShuffle(deck);
		}

	}
	
	private void basicShuffle(Deck deck) {
		ArrayList<Card> deckCut1 = new ArrayList<Card>();
		ArrayList<Card> deckCut2 = new ArrayList<Card>();
		int cardsInDeck = deck.size();

		for (int i = 0; i < (cardsInDeck / 2); i++) {
			deckCut1.add(deck.pop());
		}
		for (int i = 0; i < (cardsInDeck / 2); i++) {
			deckCut2.add(deck.pop());
		}
		for (int i = 0; i < (cardsInDeck / 2); i++) {
			deck.push(deckCut2.get(deckCut2.size() - 1));
			deckCut2.remove(deckCut2.size() - 1);
			deck.push(deckCut1.get(deckCut1.size() - 1));
			deckCut1.remove(deckCut1.size() - 1);
			

		}

	}

	private void addPlayer(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
