package is.lenoobs.tictactoe.game;

public class Cell {
    public int x;
    public int y;
    public Character symbol;

    public Cell(int x, int y, Character symbol) {
        if (!onBoard(x)) throw new IllegalArgumentException("x coordinate is out of board");
        if (!onBoard(y)) throw new IllegalArgumentException("y coordinate is out of board");
        if (!(symbol == 'X' || symbol == 'O')) throw new IllegalArgumentException("symbol is invalid");
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    private boolean onBoard(int i) {
        return (i < 8 && i >= 0);
    }
}
