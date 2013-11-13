package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryGameRepository implements GameRepository {
    private ConcurrentHashMap<String, Game> games;

    public MemoryGameRepository() {
        games = new ConcurrentHashMap<String, Game>();
    }

    public String putGame(Game game) {
        String uuid = UUID.randomUUID().toString();
        games.put(uuid, game);
        return uuid.toString();
    }

    public Game getGame(String uuid) {
        return games.get(uuid);
    }
}
