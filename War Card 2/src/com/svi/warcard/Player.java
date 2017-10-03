package com.svi.warcard;

import java.util.Stack;

public class Player {
	private int id;
	Stack<Card>playerCards=new Stack<Card>();

	Player(int id) {
		this.id = id;
	}

	public Stack<Card> getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(Stack<Card> playerCards) {
		this.playerCards = playerCards;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return ""+ id + " ";
	}

}
