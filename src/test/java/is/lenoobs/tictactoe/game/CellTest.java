package is.lenoobs.tictactoe.game;

import static org.junit.Assert.assertEquals;

import is.lenoobs.tictactoe.game.Cell;
import org.junit.Test;

public class CellTest {
    @Test(expected=IllegalArgumentException.class)
    public void createCell1() {
        Cell c = new Cell(10, 9, 'Y');
    }
    @Test(expected=IllegalArgumentException.class)
    public void createCell2() {
        Cell c = new Cell(0, 9, 'X');
    }
    @Test(expected=IllegalArgumentException.class)
    public void createCell3() {
        Cell c = new Cell(3, -1, 'X');
    }
    @Test(expected=IllegalArgumentException.class)
    public void createCell4() {
        Cell c = new Cell(3, 1, 'U');
    }
}

