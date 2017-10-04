package com.svi.warcard;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Table extends ArrayList<Card> {
	ArrayList<Integer> competitors = new ArrayList<Integer>();
	
	public void takeCards(ArrayList<Player> players) {
		
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).size() != 0) {
				add(players.get(i).get(0));
				players.get(i).remove(0);
				competitors.add(i);
			}
		}
	}

	public ArrayList<Integer> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(ArrayList<Integer> competitors) {
		this.competitors = competitors;
	}

	public int findRoundWinner(ArrayList<Player> players) {
		int winner = 0;
		
		for (int j = 1; j < size(); j++) {
			if (compareCards(get(j), get(winner))) {
				winner = j;
			}
		}
		return winner;
	}
	
	public void addSpoils(int winner, ArrayList<Player> players){
		
		for (int i = winner; i < size(); i++) {
			players.get(getCompetitors().get(winner)).add(get(i));
		}
		for (int i = 0; i < winner; i++) {
			players.get(getCompetitors().get(winner)).add(get(i));
		}
	}

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
				// this condition won't take effect since there are no duplicate cards
				return true; 
			}
		}
	}

}
