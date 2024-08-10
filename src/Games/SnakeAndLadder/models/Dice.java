package Games.SnakeAndLadder.models;

import java.util.Random;

public class Dice {
    private final int minimum;
    private final int maximum;

    public Dice(int maximum) {
        this.minimum = 1;
        this.maximum = maximum;
    }

    public int rollDice() {
        return new Random().nextInt(minimum, maximum);
    }




}
