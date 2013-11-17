package is.lenoobs.tictactoe.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test()
    public void winTest() {
        Game g = new Game();
        g.customMove(0, 'X');
        g.customMove(1, 'X');
        g.customMove(2, 'X');
        assertEquals(null, g.winner());

        g = new Game();
        g.customMove(0, 'X');
        g.customMove(1, 'X');
        g.customMove(2, 'X');
        g.customMove(4, 'O');
        g.customMove(5, 'O');
        assertEquals("Player wins!", g.winner());

        g = new Game();
        g.customMove(0, 'X');
        g.customMove(1, 'O');
        g.customMove(2, 'O');
        g.customMove(3, 'O');
        g.customMove(4, 'X');
        g.customMove(5, 'X');
        g.customMove(6, 'O');
        g.customMove(7, 'X');
        g.customMove(8, 'X');
        assertEquals("Player wins!", g.winner());

        g = new Game();
        g.customMove(0, 'X');
        g.customMove(1, 'O');
        g.customMove(2, 'O');
        g.customMove(3, 'X');
        g.customMove(4, 'X');
        g.customMove(5, 'O');
        g.customMove(6, 'O');
        g.customMove(7, 'X');
        g.customMove(8, 'X');
        assertEquals("Player wins!", g.winner());
    }

}
