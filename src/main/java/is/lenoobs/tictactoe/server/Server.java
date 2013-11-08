package is.lenoobs.tictactoe.server;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class Server {

    private GameRepository gameRepo = new MemoryGameRepository();

    public static void main(String[] args) {
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                // Tjékka á köku, og finna leik eða búa til nýjan.
                return null;
            }
        });

        post(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                // Skoða köku, finna leik og skrá move.
                return null;
            }
        });
    }

}
