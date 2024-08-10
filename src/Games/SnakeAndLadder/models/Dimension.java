package Games.SnakeAndLadder.models;

public class Dimension {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;

    public Dimension(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
