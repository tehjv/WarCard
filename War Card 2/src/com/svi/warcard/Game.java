package com.svi.warcard;

import java.util.ArrayList;

/**
*   A description of your class goes here
*/

import java.util.Scanner;

/**
 * This class handles the War Card game and calls an instance of Table class
 * when running through rounds.
 */

public class Game {
	// Fields
	private Deck deck;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int endFlag;
	private int roundNumber;

	// Constructor
	public Game() {
		setDeck(new Deck());
	}

	/**
	 * List of possible Suit values.
	 */
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

	/**
	 * List of possible Rank values.
	 */
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

	/**
	 * Starts the War Card game includes the welcome message, takes user input
	 * for number of players and shuffles and calls runGame method passing user
	 * input.
	 */
	public void startGame() {
		// welcome message
		System.out.println("*****WELCOME TO WAR CARD*****\n\n");

		// input for number of players
		System.out.println("Please enter number of Players: ");
		Scanner sc = new Scanner(System.in);
		int playerNumber = sc.nextInt();
		while (playerNumber > 52 || playerNumber < 2) {
			System.out.println("Please only enter a value from 2 to 52");
			playerNumber = sc.nextInt();
		}
		// input for number of shuffles
		System.out.println("Please enter number of Shuffle: ");
		int numberOfShuffle = sc.nextInt();
		while (numberOfShuffle < 1) {
			System.out.println("Please only enter a value greater than 0");
			numberOfShuffle = sc.nextInt();
		}
		sc.close();

		// run game with properties set by user
		runGame(playerNumber, numberOfShuffle);

	}

	public int getEndFlag() {
		return endFlag;
	}

	public void setEndFlag(int endFlag) {
		this.endFlag = endFlag;
	}

	/**
	 * Takes user input for number of players and number of shuffles and run the
	 * game rounds.
	 */
	public void runGame(int playerNumber, int numberOfShuffle) {
		// creating game players
		for (int x = 1; x <= playerNumber; x++) {
			addPlayer(new Player(x));
		}

		// displaying deck
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
		setRoundNumber(0);
		while (getEndFlag() != 1) {

			beginRound();
			System.out.println("\nPLAYER CARDS AFTER ROUND " + getRoundNumber());
			System.out.println("-----------------------------------------");
			displayPlayerCards();

			// checking if only 1 player has cards
			setEndFlag(players.size());
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).size() == 0) {
					setEndFlag(getEndFlag() - 1);
				}
			}
		}
		System.out.println(endGameMessage());
	}

	/**
	 * Returns message at the end of the game.
	 */
	public String endGameMessage() {
		// declare winner
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).size() != 0) {
				return "\n-----------------------------------------\nPLAYER" + players.get(i).getID()
						+ " WON THE GAME!";
			}
		}
		return null;
	}

	/**
	 * Handles giving each player cards and takes the cards from the top of
	 * deck.
	 */
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

	/**
	 * Handles displaying the cards a player has.
	 */
	public void displayPlayerCards() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println("\nPlayer " + players.get(i).getID() + "'s cards:");
			System.out.println(players.get(i).toString());
		}
	}

	/**
	 * Shuffles deck depending on how many times specified.
	 */
	public void shuffleRepeatedly(int numberOfShuffle) {
		for (int i = 0; i < numberOfShuffle; i++) {
			shuffleOnce(deck);
		}
	}

	/**
	 * Handles shuffling the deck with a specific process that cuts the deck in
	 * half, takes card from bottom, starting with second half of deck.
	 */
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

	/**
	 * Adds a Player instance.
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}

	/**
	 * Gets collection of players.
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Gets deck which is a collection of 52 unique cards.
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Sets the deck the War Card game will use.
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	/**
	 * Handles the War Card rounds.
	 */
	private void beginRound() {
		Table table = new Table();

		// placing cards on table
		table.takeCards(players);

		// comparing cards
		int winner = table.findRoundWinner(players);

		// collecting and adding cards to winner
		table.addSpoils(winner, players);

		// set round number
		setRoundNumber(getRoundNumber() + 1);
	}
}
