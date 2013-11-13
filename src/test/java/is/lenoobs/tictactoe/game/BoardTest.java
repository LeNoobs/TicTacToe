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
    public void randomMoveTest() {
    	Board b = new Board();
    	String initial = b.toString();
    	b.computerMove();
    	String afterMove = b.toString();
    	assertEquals(false, initial == afterMove);
    }
    
    @Test()
    public void randomMoveTest2() {
    	Board b = new Board();
    	for (int i = 0; i < 9; i++) {
    		b.computerMove();
    	}
    	String bs = b.toString();
    	System.out.println(bs);
    	assertEquals(false, bs.contains("_"));
    }
}
