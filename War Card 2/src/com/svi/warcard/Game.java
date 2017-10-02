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
		int numberOfCuts = 0;
		playerNumber = sc.nextInt();
		while (playerNumber > 52 || playerNumber < 2) {
			System.out.println("Please only enter a value from 2 to 52");
			playerNumber = sc.nextInt();
		}

		for (int x = 1; x <= playerNumber; x++) {
			addPlayer(new Player(x));

		}
		System.out.println("Please enter number of Cuts: ");
		numberOfCuts = sc.nextInt();
		while (numberOfCuts > 52 || numberOfCuts < 1) {
			System.out.println("Please only enter a value from 1 to 52");
			numberOfCuts = sc.nextInt();
		}
		sc.close();
		deck = new Deck();
		System.out.println(getDeck().toString());

		shuffle(numberOfCuts);
		System.out.println("\n");
		System.out.println(getDeck().toString());

	}

	private void shuffle(int numberOfCuts) {
		ArrayList<Stack<Card>> stacks = new ArrayList<Stack<Card>>();
		// Stack<Card> tempDeck = new Stack<Card>();

		// creates cuts stacks
		for (int i = 0; i < numberOfCuts; i++) {
			stacks.add(new Stack<Card>());
		}
		// distributes cards to cuts
		for (int j = 0; j < deck.size();) {
			for (int k = 0; k < numberOfCuts; k++) {
				stacks.get(k).push(deck.pop());
			}
		}

		// testing
		// for(int l=0; l<stacks.size();l++){
		// for(m=0;m<stacks.get(l).size();m++){
		// stacks.get(l).get(m)
		// }
		// }
		//

		// stack them up together to deck
		while (stacks != null) {
			for (int l = 0; l < stacks.size(); l++) {
				if (stacks.get(l) != null) {
					deck.push(stacks.get(l).pop());
				}
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
