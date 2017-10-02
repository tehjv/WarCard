package com.svi.warcard;

public class Player {
	private int id;

	Player(int id) {
		this.id = id;
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
