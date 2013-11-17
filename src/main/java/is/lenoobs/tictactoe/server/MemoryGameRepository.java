package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

import java.util.HashMap;
import java.util.UUID;

public class MemoryGameRepository<T extends Game> implements GameRepository<T> {

    private HashMap<String, T> games;

    public MemoryGameRepository() {
        games = new HashMap<>();
    }

    public String putGame(T game) {
        String uuid = UUID.randomUUID().toString();
        games.put(uuid, game);
        return uuid;
    }

    public T getGame(String uuid) {
        return games.get(uuid);
    }

}
