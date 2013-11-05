package is.lenoobs.tictactoe;

import is.lenoobs.tictactoe.game.Player;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void nametest() {
		Player test = new Player("Test");
		assertEquals("Test", test.getName());
	}

	@Test
	public void winstest() {
		Player test = new Player("test");
		assertEquals(0, test.getWins());
	}

	@Test
	public void lossestest() {
		Player test = new Player("test");
		assertEquals(0, test.getLosses());
	}
}