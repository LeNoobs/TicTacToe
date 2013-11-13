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

    public String win() {
        int count = 0;
        for(int i = 0; i < 9; i++) {
            if(board[i] == '_')
                count++;
        }
        if(count > 4) return null;
    
        int[][] win_rows = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        
        for(int i = 0; i < 8; i++) {
        	if(board[win_rows[i][0]] == 'X' && board[win_rows[i][1]] == 'X' && board[win_rows[i][2]] == 'X')
        		return "Player Wins!";
        	else if(board[win_rows[i][0]] == 'O' && board[win_rows[i][1]] == 'O' && board[win_rows[i][2]] == 'O')
        		return "Computer Wins!" ;
        	else
        		return null;
        }
        return null;
    }
}
