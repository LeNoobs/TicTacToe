package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

public interface GameRepository {
    public Game getGame(String uuid);
    public String putGame(Game game);
}
