package p02.game;

public class Player {
    private int x;
    private int y;

    public Player() {
        x = 0;  // Starting position on the board
        y = 0;
    }

    public void moveLeft() {
        if (x > 0) {
            x--;
        }
    }

    public void moveRight() {
        if (x < 11) {  // Assuming the board has 12 rows
            x++;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
