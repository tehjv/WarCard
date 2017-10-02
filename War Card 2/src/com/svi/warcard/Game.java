package com.svi.warcard;

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
}
