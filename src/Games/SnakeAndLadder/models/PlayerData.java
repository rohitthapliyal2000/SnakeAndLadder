package Games.SnakeAndLadder.models;

public class PlayerData {
    public final String name;
    public Dimension position;

    public PlayerData(String name) {
        this.name = name;
        this.position = new Dimension(0, 0);
    }
}
