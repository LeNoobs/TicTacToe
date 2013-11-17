package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

public class Server {

    private static GameRepository gameRepo = new MemoryGameRepository();
    
    public static void main(String[] args) {
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
            	Game game = gameRepo.getGame(request.cookie("game"));

                if (game == null || game.done()) {
                    game = new Game();
                    String id = gameRepo.putGame(game);
                    response.cookie("game", id);
                }

                return template(game.toHTML());
            }
        });

        get(new Route("/move/:cell") {
        	@Override
        	public Object handle(Request request, Response response) {
                Game game = gameRepo.getGame(request.cookie("game"));

                if (game != null && !game.done()) {
                    try {
                        int cell = Integer.parseInt(request.params(":cell"));
                        game.playerMove(cell);
                        if (!game.done()) game.computerMove();
                        if (game.done() || game.win() != null) {
                            response.removeCookie("game");
                            return template(game.results());
                        }
                    } catch (NumberFormatException e) {
                        return "Woops";
                    }
                }

        		response.redirect("/");
                return null;
        	}
        });
    }

    private static String template(String mainContent) {
    	return "<!doctype html><html><head><style>" +
                "a,span { font-family: monospace; margin-left: 40px; font-size: 50px; text-decoration:none;}" +
                "a:visited { color: blue;}" +
                "</style><title>TicTactoe</title></head><body>" +
                mainContent +
    			"</body></html>";
    }
}
