package p02.game;

public class Turtle {
    private boolean isVisible;
    private boolean isDiving;

    public Turtle() {
        isVisible = true;
        isDiving = false;
    }

    public void dive() {
        isDiving = true;
        isVisible = false;
    }

    public void surface() {
        isDiving = false;
        isVisible = true;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isDiving() {
        return isDiving;
    }
}
