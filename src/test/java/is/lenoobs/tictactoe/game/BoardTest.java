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

    @Test()
    public void boardCellTest() {
        Board b = new Board();
        b.place(0, 'X');
        b.place(2, 'O');
        b.place(6, 'X');
        assertEquals(6, b.emptyCount());
        assertEquals(false, b.isFull());
        b.randomPlace('O');
        b.randomPlace('X');
        b.randomPlace('O');
        assertEquals(3, b.emptyCount());
        b.randomPlace('X');
        b.randomPlace('O');
        b.randomPlace('X');
        assertEquals(0, b.emptyCount());
        assertEquals(true, b.isFull());
    }

}
