package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemoryGameRepositoryTest {
    private GameRepository<Game> games = new MemoryGameRepository<>();

    @Test
    public void testPutGame() throws Exception {
        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();

        String uuid1 = games.putGame(game1);
        String uuid2 = games.putGame(game2);
        String uuid3 = games.putGame(game3);
        String uuid4 = games.putGame(game4);

        assertEquals(game1, games.getGame(uuid1));
        assertEquals(game2, games.getGame(uuid2));
        assertEquals(game3, games.getGame(uuid3));
        assertEquals(game4, games.getGame(uuid4));
    }

}
