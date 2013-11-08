package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class MemoryGameRepositoryTest {
    private GameRepository games = new MemoryGameRepository();

    @Test
    public void testPutGame() throws Exception {
        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();

        UUID uuid1 = games.putGame(game1);
        UUID uuid2 = games.putGame(game2);
        UUID uuid3 = games.putGame(game3);
        UUID uuid4 = games.putGame(game4);

        assertEquals(game1, games.getGame(uuid1));
        assertEquals(game2, games.getGame(uuid2));
        assertEquals(game3, games.getGame(uuid3));
        assertEquals(game4, games.getGame(uuid4));
    }

}
