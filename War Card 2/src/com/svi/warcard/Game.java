package com.svi.warcard;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public enum Suit {
		HEARTS(3), DIAMONDS(4), SPADES(2), CLUBS(1);

		private int value;

		Suit(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
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

	// Fields
	private Deck deck;
	private ArrayList<Player> players = new ArrayList<Player>();

	// Constructor
	public Game() {

	}

	public void startGame() {
		// initializing user input storage
		int playerNumber = 0;
		int numberOfShuffle = 0;
		int endFlag;

		// welcome message
		System.out.println("*****WELCOME TO WAR CARD*****\n\n");

		// input for number of players
		System.out.println("Please enter number of Players: ");
		Scanner sc = new Scanner(System.in);
		playerNumber = sc.nextInt();
		while (playerNumber > 52 || playerNumber < 2) {
			System.out.println("Please only enter a value from 2 to 52");
			playerNumber = sc.nextInt();
		}

		// creating game players
		for (int x = 1; x <= playerNumber; x++) {
			addPlayer(new Player(x));
		}
		endFlag = players.size();

		// input for number of shuffles
		System.out.println("Please enter number of Shuffle: ");
		numberOfShuffle = sc.nextInt();
		while (numberOfShuffle < 1) {
			System.out.println("Please only enter a value greater than 0");
			numberOfShuffle = sc.nextInt();
		}
		sc.close();

		// creating deck and displaying deck
		setDeck(new Deck());
		System.out.println("\nInitial Deck:");
		System.out.println(getDeck().toString());

		// shuffling deck and displaying shuffled deck
		shuffleRepeatedly(numberOfShuffle);
		System.out.println("\nShuffled Deck:");
		System.out.println(getDeck().toString());

		// deal cards to players
		dealCards();

		// display player cards
		System.out.println("\nPLAYER CARDS BEFORE THE ROUNDS START");
		System.out.println("-----------------------------------------");
		displayPlayerCards();

		// rounds processing
		int counter = 1;
		while (endFlag != 1) {

			beginRound();
			System.out.println("\nPLAYER CARDS AFTER ROUND " + counter);
			System.out.println("-----------------------------------------");
			displayPlayerCards();
			counter++;

			//checking if only 1 player has cards
			endFlag = players.size();
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).size() == 0) {
					endFlag--;
				}
			}
		}
		endGame();
	}

	private void endGame() {
		// declare winner
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).size() != 0) {
				System.out.println("\n-----------------------------------------");
				System.out.println("PLAYER " + players.get(i).getID() + " WON THE GAME!");
			}
		}
	}

	private void beginRound() {
		Table table = new Table();

		// placing cards on table
		table.takeCards(players);

		// comparing cards
		int winner = table.findRoundWinner(players);		

		// collecting and adding cards to winner
		table.addSpoils(winner, players);

	}

	public void dealCards() {
		int initialDeckSize = deck.size();
		for (int i = 0; i < initialDeckSize;) {
			for (int j = 0; j < players.size(); j++) {				
				if (deck.size() != 0) {					
					players.get(j).add(0, deck.get(0));
					deck.remove(0);				
				}
				i++;
			}

		}
	}

	public void displayPlayerCards() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println("\nPlayer " + players.get(i).getID() + "'s cards:");
			System.out.println(players.get(i).toString());
		}
	}

	public void shuffleRepeatedly(int numberOfShuffle) {
		for (int i = 0; i < numberOfShuffle; i++) {
			shuffleOnce(deck);
		}
	}

	public void shuffleOnce(Deck deck) {
		ArrayList<Card> deckCut1 = new ArrayList<Card>();
		ArrayList<Card> deckCut2 = new ArrayList<Card>();
		int cardsInDeck = deck.size();

		for (int i = 0; i < (deck.size() / 2); i++) {
			deckCut1.add(deck.get(i));
		}
		for (int i = (deck.size() / 2); i < deck.size(); i++) {
			deckCut2.add(deck.get(i));
		}
		deck.clear();
		for (int i = 0; i < (cardsInDeck / 2); i++) {
			deck.add(deckCut1.get(i));
			deck.add(deckCut2.get(i));
		}

	}

	

	public void addPlayer(Player player) {
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
