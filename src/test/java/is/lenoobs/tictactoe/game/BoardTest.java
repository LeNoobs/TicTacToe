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
    public void winTestNoWin() {
    	Board b = new Board();
    	b.board[0] = 'X';
    	b.board[1] = 'X';
    	b.board[2] = 'X';
    	String w = b.win();
    	assertEquals(null, w);
    }

    @Test()
    public void winTestWin() {
    	Board b = new Board();
    	b.board[0] = 'X';
    	b.board[1] = 'X';
    	b.board[2] = 'X';
    	b.board[4] = 'O';
    	b.board[5] = 'O';
    	String w = b.win();
    	assertEquals("Player Wins!", w);

        b = new Board();
        b.board[0] = 'X';
        b.board[1] = 'O';
        b.board[2] = 'O';
        b.board[3] = 'O';
        b.board[4] = 'X';
        b.board[5] = 'X';
        b.board[6] = 'O';
        b.board[7] = 'X';
        b.board[8] = 'X';
        assertEquals("Player Wins!", b.win());

        b = new Board();
        b.board[0] = 'X';
        b.board[1] = 'O';
        b.board[2] = 'O';
        b.board[3] = 'X';
        b.board[4] = 'X';
        b.board[5] = 'O';
        b.board[6] = 'O';
        b.board[7] = 'X';
        b.board[8] = 'X';
        assertEquals("Player Wins!", b.win());
    }
    
    @Test()
    public void randomMoveTest() {
    	Board b = new Board();
    	String initial = b.toString();
    	b.computerMove();
    	String afterMove = b.toString();
    	assertEquals(false, initial.equals(afterMove));
    }
    
    @Test()
    public void randomMoveTest2() {
    	Board b = new Board();
    	for (int i = 0; i < 9; i++) {
    		b.computerMove();
    	}
    	String bs = b.toString();
    	assertEquals(false, bs.contains("_"));
    }

}
