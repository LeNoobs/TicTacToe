package is.lenoobs.tictactoe.game;

import java.util.ArrayList;

public class Game {
	private Board board;
	
	public Game() {
		board = new Board();
	}
	
	public void computerMove() {
		board.computerMove();
	}
	
	public void playerMove(int cellIndex) {
		board.playerMove(cellIndex);
	}

    public String win() {
        return board.win();
    }

    public boolean done() {
        return board.done();
    }

    public String results() {
        return board.results();
    }
	
	public ArrayList<Integer> freeCells() {
		return board.freeCells();
	}
	
	public String toHTML() {
		return board.toHTML();
	}
	
	@Override
	public String toString() {
		return board.toString();
	}
}
