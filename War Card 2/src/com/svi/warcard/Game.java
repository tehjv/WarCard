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
	Deck deck;
	private ArrayList<Player> players = new ArrayList<Player>();
	int endFlag = 4;

	// Constructor
	Game() {
		start();
	}

	private void start() {

		// initializing user input storage
		int playerNumber = 0;
		int numberOfShuffle = 0;

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

		// input for number of shuffles
		System.out.println("Please enter number of Shuffle: ");
		numberOfShuffle = sc.nextInt();
		while (numberOfShuffle < 1) {
			System.out.println("Please only enter a value greater than 0");
			numberOfShuffle = sc.nextInt();
		}
		sc.close();

		// creating deck, shuffling deck as per number of shuffles and
		// displaying deck
		deck = new Deck();
		System.out.println("\nInitial Deck:");
		System.out.println(getDeck().toString());

		shuffle(numberOfShuffle);
		System.out.println("\nShuffled Deck:");
		System.out.println(getDeck().toString());

		// deal cards to players
		dealCards();

		// display player cards
		System.out.println("\nPLAYER CARDS BEFORE THE ROUNDS START");
		System.out.println("-----------------------------------------");
		displayPlayerCards();

		// battles
		int counter = 1;
		while (endFlag != 1) {
			
			battle();
			System.out.println("\nPLAYER CARDS AFTER ROUND " + counter);
			System.out.println("-----------------------------------------");
			displayPlayerCards();
			counter++;
		}
	}

	private void battle() {
		ArrayList<Card> table = new ArrayList<Card>();

		// placing cards on table
		for (int i = 0; i < players.size(); i++) {
			if (!players.get(i).getPlayerCards().contains(null)) {
				table.add(players.get(i).getPlayerCards().get(0));
			}
			players.get(i).getPlayerCards().remove(0);
		}

		// comparing cards
		int winner = 0;

		for (int j = 1; j < table.size(); j++) {
			if (compareCards(table.get(j), table.get(winner))) {
				winner = j;
			}
		}

		// collecting and adding cards to winner

		for (int i = winner; i < table.size(); i++) {
			players.get(winner).getPlayerCards().add(table.get(i));
		}
		for (int i = 0; i < winner; i++) {
			players.get(winner).getPlayerCards().add(table.get(i));
		}

		// check for losers
		endFlag = players.size();
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getPlayerCards().contains(null)) {
				endFlag--;
			}
		}

	}

	private void dealCards() {
		for (int i = deck.size() - 1; i > -1;) {
			for (int j = 0; j < players.size(); j++) {
				if (i > -1) {
					if (j == 0) {
						players.get(j).getPlayerCards().add(deck.get(i));
					} else {
						players.get(players.size() - j).getPlayerCards().add(deck.get(i));
					}
				}
				i--;
			}

		}
	}

	private void displayPlayerCards() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println("\nPlayer " + players.get(i).getId() + "'s cards:");
			System.out.println(players.get(i).getPlayerCards().toString());
		}
	}

	private void shuffle(int numberOfShuffle) {
		for (int i = 0; i < numberOfShuffle; i++) {
			basicShuffle(deck);
		}
	}

	private void basicShuffle(Deck deck) {
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

	private boolean compareCards(Card card1, Card card2) {
		if (card1.getRank().getValue() > card2.getRank().getValue()) {
			return true;
		} else if (card1.getRank().getValue() < card2.getRank().getValue()) {
			return false;
		} else {
			if (card1.getSuit().getValue() > card2.getSuit().getValue()) {
				return true;
			} else if (card1.getSuit().getValue() < card2.getSuit().getValue()) {
				return false;
			} else {
				return true; // never happens (no same card)
			}
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
