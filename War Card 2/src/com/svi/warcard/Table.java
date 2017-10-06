package com.svi.warcard;

import java.util.ArrayList;

/**
 * A class that handles round processing for Game's instance.
 */

@SuppressWarnings("serial")
public class Table extends ArrayList<Card> {
	ArrayList<Integer> competitors = new ArrayList<Integer>();

	/**
	 * Places top-most card from each player onto the table.
	 */
	public void takeCards(ArrayList<Player> players) {

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).size() != 0) {
				add(players.get(i).get(0));
				players.get(i).remove(0);
				competitors.add(i);
			}
		}
	}

	/**
	 * Lists the players still competing.
	 */
	public ArrayList<Integer> getCompetitors() {
		return competitors;
	}

	/**
	 * Finds winner of a round by comparing all cards.
	 */
	public int findRoundWinner(ArrayList<Player> players) {
		int winner = 0;

		for (int j = 1; j < size(); j++) {
			if (compareCards(get(j), get(winner))) {
				winner = j;
			}
		}
		return winner;
	}

	/**
	 * A class that handles adding cards on table to winner's deck/hand.
	 */
	public void addSpoils(int winner, ArrayList<Player> players) {

		for (int i = winner; i < size(); i++) {
			players.get(getCompetitors().get(winner)).add(get(i));
		}
		for (int i = 0; i < winner; i++) {
			players.get(getCompetitors().get(winner)).add(get(i));
		}
	}

	/**
	 * Used to compare 2 cards.
	 */
	public boolean compareCards(Card card1, Card card2) {
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
				// this condition won't take effect since there are no duplicate
				// cards
				return true;
			}
		}
	}
}
