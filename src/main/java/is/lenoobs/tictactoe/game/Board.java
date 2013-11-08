package is.lenoobs.tictactoe.game;

public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    @Override
    public String toString() {
        String boardString = "";
        for (char[] row : board) {
            for (char cell : row) {
                boardString += cell;
            }
            boardString += "\n";
        }
        return boardString;
    }
}
