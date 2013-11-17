package is.lenoobs.tictactoe.game;

public class WebGame extends Game {

    public WebGame() {
        super();
    }

    public String render() {
        String html = "";
        for (int i = 0; i < 9; i++) {
            html += "<a href='/move/" + i + "'>" + board.board[i] + "</a>";
            if ((i+1) % 3 == 0) html += "<br/>";
        }
        return html;
    }

}
