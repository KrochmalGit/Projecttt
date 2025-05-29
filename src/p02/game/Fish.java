package p02.game;

import java.util.Random;

public class Fish {
    private int column;
    private int row;

    public Fish() {
        Random rand = new Random();
        column = rand.nextInt(5);  // Random column (5 possible positions)
        row = 11;  // Fish starts at the bottom row
    }

    public void moveUp() {
        if (row > 0) {
            row--;
        }
    }

    public boolean isAtSurface() {
        return row == 0;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
