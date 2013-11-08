package is.lenoobs.tictactoe.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test()
    public void boardTest() {
        Board b = new Board();
        String s = b.toString();
        assertEquals("___\n___\n___\n", s);
    }
}
