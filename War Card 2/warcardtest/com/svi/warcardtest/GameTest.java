package com.svi.warcardtest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.svi.warcard.Game;

public class GameTest {

	@Test
	public void testStartGame() {
		Game gameTest1 = new Game();
		gameTest1.runGame(3, 1);
		assertEquals(145, gameTest1.getRoundNumber());
		assertEquals("\n-----------------------------------------\nPLAYER1 WON THE GAME!", gameTest1.endGameMessage());
		Game gameTest2 = new Game();
		gameTest2.runGame(4, 3);
		assertEquals(13, gameTest2.getRoundNumber());
		assertEquals("\n-----------------------------------------\nPLAYER1 WON THE GAME!", gameTest1.endGameMessage());
		Game gameTest3 = new Game();
		gameTest3.runGame(5, 2);
		assertEquals(244, gameTest3.getRoundNumber());
		assertEquals("\n-----------------------------------------\nPLAYER1 WON THE GAME!", gameTest1.endGameMessage());

	}

	@Test
	public void testShuffleRepeatedly() {
		Game gameTest1 = new Game();
		gameTest1.shuffleRepeatedly(5);
		assertEquals(
				"[D-A, D-6, H-J, H-3, S-8, C-K, C-5, D-9, H-A, H-6, S-J, S-3, C-8, D-Q, D-4, H-9, S-A, S-6, C-J, C-3, D-7, H-Q, H-4, S-9, C-A, C-6, D-10, D-2, H-7, S-Q, S-4, C-9, D-K, D-5, H-10, H-2, S-7, C-Q, C-4, D-8, H-K, H-5, S-10, S-2, C-7, D-J, D-3, H-8, S-K, S-5, C-10, C-2]",
				gameTest1.getDeck().toString());

		Game gameTest2 = new Game();
		gameTest2.shuffleRepeatedly(100);
		assertEquals(
				"[D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3, D-Q, H-9, S-6, C-3, H-Q, S-9, C-6, D-2, S-Q, C-9, D-5, H-2, C-Q, D-8, H-5, S-2, D-J, H-8, S-5, C-2]",
				gameTest2.getDeck().toString());

	}

}
