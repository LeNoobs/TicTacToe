package is.lenoobs.tictactoe.server;

import is.lenoobs.tictactoe.game.WebGame;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.setPort;

public class Server {

    private static MemoryGameRepository<WebGame> gameRepo = new MemoryGameRepository<>();
    
    public static void main(String[] args) {
        if (args != null) {
            setPort(Integer.parseInt(args[0]));
        } else {
            setPort(Integer.parseInt(System.getenv("PORT")));
        }

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
            	WebGame game = gameRepo.getGame(request.cookie("game"));

                if (game == null) {
                    game = new WebGame();
                    String id = gameRepo.putGame(game);
                    response.cookie("game", id);
                }

                if (game.isDone()) {
                    response.removeCookie("game");
                    return template("<span class='game_over'>" + game.winner() + "</span><br/><br/>" + game.render());
                }

                return template(game.render());
            }
        });

        get(new Route("/move/:cell") {
        	@Override
        	public Object handle(Request request, Response response) {
                WebGame game = gameRepo.getGame(request.cookie("game"));

                if (game != null && !game.isDone()) {
                    try {
                        int cell = Integer.parseInt(request.params(":cell"));
                        game.playerMove(cell);
                        if (!game.isDone()) game.computerMove();
                    } catch (NumberFormatException e) {
                        return "An error occurred";
                    } catch (IllegalArgumentException err) {               
                        return template("<span class='error'>Illegal Operation</span><br/><br/>" + game.render());
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
                "body { margin-top: 40px; }" +
                "</style><title>TicTactoe</title></head><body>" +
                mainContent +
    			"</body></html>";
    }
}
