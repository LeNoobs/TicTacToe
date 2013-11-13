package is.lenoobs.tictactoe.game;

import org.junit.Test;

public class CellTest {
    @Test(expected=IllegalArgumentException.class)
    public void createCell1() {
        @SuppressWarnings("unused")
		Cell c = new Cell(10, 9, 'Y');
    }
    @Test(expected=IllegalArgumentException.class)
    public void createCell2() {
        @SuppressWarnings("unused")
        Cell c = new Cell(0, 9, 'X');
    }
    @Test(expected=IllegalArgumentException.class)
    public void createCell3() {
        @SuppressWarnings("unused")
        Cell c = new Cell(3, -1, 'X');
    }
    @Test(expected=IllegalArgumentException.class)
    public void createCell4() {
        @SuppressWarnings("unused")
        Cell c = new Cell(3, 1, 'U');
    }
}

