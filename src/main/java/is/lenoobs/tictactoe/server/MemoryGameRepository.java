package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryGameRepository implements GameRepository {
    private ConcurrentHashMap<UUID, Game> games;

    public MemoryGameRepository() {
        games = new ConcurrentHashMap<UUID, Game>();
    }

    public UUID putGame(Game game) {
        UUID uuid = UUID.randomUUID();
        games.put(uuid, game);
        return uuid;
    }

    public Game getGame(UUID uuid) {
        return games.get(uuid);
    }
}
