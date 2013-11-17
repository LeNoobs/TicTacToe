package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

import java.util.HashMap;
import java.util.UUID;

public class MemoryGameRepository implements GameRepository {
    private HashMap<String, Game> games;

    public MemoryGameRepository() {
        games = new HashMap<>();
    }

    public String putGame(Game game) {
        String uuid = UUID.randomUUID().toString();
        games.put(uuid, game);
        return uuid;
    }

    public Game getGame(String uuid) {
        return games.get(uuid);
    }
}
