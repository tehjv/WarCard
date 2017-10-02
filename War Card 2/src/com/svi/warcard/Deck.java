package com.svi.warcard;

import java.util.Stack;

import com.svi.warcard.Game.Rank;
import com.svi.warcard.Game.Suit;

public class Deck extends Stack<Card> {
	Deck() {
		Suit suit = null;
		Rank rank = null;

		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				suit = Suit.DIAMONDS;
			} else if (i == 1) {
				suit = Suit.HEARTS;
			} else if (i == 2) {
				suit = Suit.SPADES;
			} else {
				suit = Suit.CLUBS;
			}
			for (int j = 0; j < 13; j++) {
				if (j == 0) {
					rank = Rank.Ace;
				} else if (j == 1) {
					rank = Rank.Two;
				} else if (j == 2) {
					rank = Rank.Three;
				} else if (j == 3) {
					rank = Rank.Four;
				} else if (j == 4) {
					rank = Rank.Five;
				} else if (j == 5) {
					rank = Rank.Six;
				} else if (j == 6) {
					rank = Rank.Seven;
				} else if (j == 7) {
					rank = Rank.Eight;
				} else if (j == 8) {
					rank = Rank.Nine;
				} else if (j == 9) {
					rank = Rank.Ten;
				} else if (j == 10) {
					rank = Rank.Jack;
				} else if (j == 11) {
					rank = Rank.Queen;
				} else if (j == 12) {
					rank = Rank.King;
				}
			}
			push(new Card(rank, suit));

		}
	}
}
