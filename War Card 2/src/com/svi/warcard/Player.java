package com.svi.warcard;

import java.util.ArrayList;

public class Player {
	private int id;
	ArrayList<Card> playerCards = new ArrayList<Card>();

	public Player(int id) {
		this.id = id;
	}

	public ArrayList<Card> getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(ArrayList<Card> playerCards) {
		this.playerCards = playerCards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
