package com.svi.warcard;

import com.svi.warcard.Game.Rank;
import com.svi.warcard.Game.Suit;

public class Card {
	private Rank rank;
	private Suit suit;

	Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

}
