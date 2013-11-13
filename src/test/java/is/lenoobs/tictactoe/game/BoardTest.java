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

    // This test only works if board[][] is changed to public
    // @Test() 
    // public void wintest_notwin() {
    // 	Board b = new Board();
    // 	b.board[0] = 'X';
    // 	b.board[1] = 'X';
    // 	b.board[2] = 'X';
    // 	String w = b.win();
    // 	assertEquals(null, w);
    // }

    // This test only works if board[][] is changed to public
    // @Test() 
    // public void wintest_win() {
    // 	Board b = new Board();
    // 	b.board[0] = 'X';
    // 	b.board[1] = 'X';
    // 	b.board[2] = 'X';
    // 	b.board[4] = 'O';
    // 	b.board[5] = 'O';
    // 	String w = b.win();
    // 	assertEquals("Player Wins!", w);
    // }
    
    // next test with game.playermoves...

    
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
