package Games.SnakeAndLadder;

import Games.SnakeAndLadder.models.*;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Snake snake = new Snake(new Dimension(3, 2), new Dimension(1, 2));
        Snake snake2 = new Snake(new Dimension(10, 9), new Dimension(1, 3));
        Snake snake3 = new Snake(new Dimension(10, 8), new Dimension(1, 3));
        Snake snake4 = new Snake(new Dimension(10, 7), new Dimension(1, 3));
        Ladder ladder = new Ladder(new Dimension(1, 3), new Dimension(5, 2));

        List<Snake> snakes = new ArrayList<>();
        snakes.add(snake);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(ladder);

        List<PlayerData> players = new ArrayList<>();
        players.add(new PlayerData("Rohit"));
        players.add(new PlayerData("Chiranjeev"));

        // Instantiate the board, dice, and the Game
        Board board = new Board(snakes, ladders, 10, 10);
        Dice die = new Dice(6);
        Game game = new Game(board, die, players);

        game.startGame();
    }
}