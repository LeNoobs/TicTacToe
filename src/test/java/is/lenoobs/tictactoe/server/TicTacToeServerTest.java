package is.lenoobs.tictactoe.server;

import static org.junit.Assert.assertEquals;

import is.lenoobs.tictactoe.server.TicTacToeServer;
import org.junit.Test;

public class TicTacToeServerTest {
    @Test
    public void serverSaysSomething() {
        assertEquals("Playing Tic-tac-toe!", TicTacToeServer.run());
    }
}
