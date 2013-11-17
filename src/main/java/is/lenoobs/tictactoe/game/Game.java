package is.lenoobs.tictactoe.game;

public class Game {

    protected Board board;

    public Game() {
        board = new Board();
    }

    public void computerMove() {
        board.randomPlace('O');
    }

    public void playerMove(int cellIndex) {
        board.place(cellIndex, 'X');
    }

    // This method is really only to make the class more testable.
    public void customMove(int cellIndex, char value) {
        board.place(cellIndex, value);
    }

    public String winner() {
        int emptyCells = board.emptyCount();

        if (emptyCells > 4) return null;

        int[][] win_rows = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        for (int[] winning : win_rows) {
            if(board.get(winning[0]) == 'X' && board.get(winning[1]) == 'X' && board.get(winning[2]) == 'X')
                return "Player wins!";
            else if(board.get(winning[0]) == 'O' && board.get(winning[1]) == 'O' && board.get(winning[2]) == 'O')
                return "Computer wins!" ;
        }

        if (emptyCells == 0) return "It's a tie!";

        return null;
    }

    public boolean isDone() {
        return board.isFull() || winner() != null;
    }

}
