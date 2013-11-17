package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

public interface GameRepository<T extends Game> {
    public T getGame(String uuid);
    public String putGame(T game);
}
