package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

import java.util.UUID;

public interface GameRepository {
    public Game getGame(UUID uuid);
    public UUID putGame(Game game);
}
