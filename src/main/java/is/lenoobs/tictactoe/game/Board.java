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

    public char get(int index) {
        return board[index];
    }

	public void randomPlace(char value) {
		ArrayList<Integer> freeCells = emptyCells();
		
		int rand = (new Random()).nextInt(freeCells.size());
		int randCellIndex = freeCells.get(rand);
		place(randCellIndex, value);
	}
	
	public void place(int cellIndex, char value) {
		if (cellIndex < 0 || cellIndex > 8) throw new IllegalArgumentException("cell index out of range");
		if (board[cellIndex] != '_') throw new IllegalArgumentException("cell not empty");
		
		board[cellIndex] = value;
	}

    public boolean isFull() {
        return !toString().contains("_");
    }

    public int emptyCount() {
        int count = 0;
        for (char c : board) {
            if (c == '_') count++;
        }
        return count;
    }

	private ArrayList<Integer> emptyCells() {
		ArrayList<Integer> freeCells = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			if (board[i] == '_') freeCells.add(i);
		}

		return freeCells;
	}
}
