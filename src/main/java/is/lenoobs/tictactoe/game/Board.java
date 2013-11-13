package is.lenoobs.tictactoe.game;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private char[] board;

    public Board() {
        board = new char[9];
        for (int i = 0; i < 9; i++) {
        	board[i] = '_';
        }
    }

    @Override
    public String toString() {
        String boardString = "";
        for (int i = 0; i < 9; i++) {
        	boardString += board[i];
        	if ((i+1) % 3 == 0) boardString += "\n";
        }
        return boardString;
    }
    
    public String toHTML() {
    	String html = "";
    	for (int i = 0; i < 9; i++) {
    		html += "<span class='cell' id='" + i + "'>" + board[i] + "</span>";
    		if ((i+1) % 3 == 0) html += "<br/>";
    	}
    	return html;
    }
    
	private void randomMove() {
		ArrayList<Integer> freeCells = freeCells();
		
		int rand = (new Random()).nextInt(freeCells.size());
		int randCellIndex = freeCells.get(rand);
		move(randCellIndex, 'O');
	}
	
	private void move(int cellIndex, char value) {
		if (cellIndex < 0 || cellIndex > 8) throw new IllegalArgumentException("cell index out of range");
		if (board[cellIndex] != '_') throw new IllegalArgumentException("cell not empty");
		
		board[cellIndex] = value;
	}
	
	public void computerMove() {
		randomMove();
	}

	public void playerMove(int cellIndex) {
		move(cellIndex, 'X');
	}

	public ArrayList<Integer> freeCells() {
		ArrayList<Integer> freeCells = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++) {
			if (board[i] == '_') freeCells.add(i);
		}
		
		return freeCells;
	}
}
