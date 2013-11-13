package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.Game;

import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;
import static spark.Spark.post;

public class Server {

    private static GameRepository gameRepo = new MemoryGameRepository();
    
    public static void main(String[] args) {
        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
            	Game game;
            	if (request.cookie("game") == null) {
            		game = new Game();
            		String id = gameRepo.putGame(game);
                	response.cookie("game", id.toString());
            	} else {
            		try {
                		game = gameRepo.getGame(request.cookie("game"));            			
            		} catch (Exception e) {
            			return "Woops";
            		}
            	}
        		return template(game.toHTML());
        		
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

    private static String template(String html) {
    	return "<doctype html><html><head><script src='/tictactoe.js'></script><style>span { margin-left: 40px; font-size: 50px;}</style><title>TicTactoe</title></head><body>" + html +
    			"</body></html>";
    }
}
