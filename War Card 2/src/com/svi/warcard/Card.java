package com.svi.warcard;

import com.svi.warcard.Game.Rank;
import com.svi.warcard.Game.Suit;

/**
*   This class is used to create Card objects.
*/

public class Card {
	private Rank rank;
	private Suit suit;
	
	/**
	*   Creates card object, sets rank and suit value.
	*/
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	*   Gets card Rank.
	*/
	public Rank getRank() {
		return rank;
	}

	/**
	*   Sets card's Rank.
	*/
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	/**
	*  Gets card's Suit.
	*/
	public Suit getSuit() {
		return suit;
	}
	
	/**
	*   Sets card's Suit.
	*/
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	/**
	*   Overrides original function to print card properties in format: Suit initial - Rank initial
	*/
	@Override
	public String toString() {
		String a = "";
		char b = ' ';
		
		switch (rank) {
		case Ace:
			a = "Ace";
			break;
		case Eight:
			a = "8";
			break;
		case Five:
			a = "5";
			break;
		case Four:
			a = "4";
			break;
		case Jack:
			a = "J";
			break;
		case King:
			a = "K";
			break;
		case Nine:
			a = "9";
			break;
		case Queen:
			a = "Q";
			break;
		case Seven:
			a = "7";
			break;
		case Six:
			a = "6";
			break;
		case Ten:
			a = "10";
			break;
		case Three:
			a = "3";
			break;
		case Two:
			a = "2";
			break;
		default:
			break;
		}

		switch (suit) {
		case CLUBS:
			b = 'C';
			break;
		case DIAMONDS:
			b = 'D';
			break;
		case HEARTS:
			b = 'H';
			break;
		case SPADES:
			b = 'S';
			break;
		default:
			break;
		}
		
		return b + "-" + a;
	}

}
