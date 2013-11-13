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

        get(new Route("/move/:cell") {
        	@Override
        	public Object handle(Request request, Response response) {
        		return null;
        	}
        });
    }

    private static String template(String html) {
    	return "<!doctype html><html><head><style>span { margin-left: 40px; font-size: 50px;}</style><title>TicTactoe</title></head><body>" + html +
    			"</body></html>";
    }
}
