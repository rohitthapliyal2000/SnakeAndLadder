package Games.SnakeAndLadder.models;

public abstract class BoardObjects {
    public BoardObjects(Dimension start, Dimension end) {
        this.start = start;
        this.end = end;
    }

    public Dimension getStart() {
        return start;
    }

    public Dimension getEnd() {
        return end;
    }

    public final Dimension start;
    public final Dimension end;
}
