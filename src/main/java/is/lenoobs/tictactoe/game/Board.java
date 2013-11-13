package is.lenoobs.tictactoe.game;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private Character[] board;

    public Board() {
        board = new Character[9];
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

//	public void randomMove() {
//		ArrayList<Integer> emptyCells = new ArrayList<>();
//		
//		for (Character cell : board) {
//			if (cell == '_') emptyCells.add(cell);
//		}
//		
//		Random rand = new Random();
//		int randCell = rand.nextInt(emptyCells.size());
//		emptyCells.get(randCell)
//	}
}
