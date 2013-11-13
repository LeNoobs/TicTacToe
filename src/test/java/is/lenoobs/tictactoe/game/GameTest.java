package is.lenoobs.tictactoe.game;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
	@Test()
	public void gameTest() {
		// A random game played without errors.
		Game g = new Game();
		for (int i = 0; i < 9; i++) {
			if (i % 2 != 0) g.computerMove();
			else {
				ArrayList<Integer> freeCells = g.freeCells();
				int randMove = freeCells.get((new Random()).nextInt(freeCells.size()));
				g.playerMove(randMove);
			}
		}
		assertEquals(false, g.toString().contains("_"));
	}
}