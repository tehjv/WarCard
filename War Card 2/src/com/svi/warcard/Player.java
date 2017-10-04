package com.svi.warcard;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Player extends ArrayList<Card> {
	private int id;
	private int initialNumberOfCards;
	
	public Player(int id) {
		setID(id);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getInitialNumberOfCards() {
		return initialNumberOfCards;
	}

	public void setInitialNumberOfCards(int initialNumberOfCards) {
		this.initialNumberOfCards = initialNumberOfCards;
	}
}
