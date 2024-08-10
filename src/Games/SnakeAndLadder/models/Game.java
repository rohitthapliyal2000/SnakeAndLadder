package Games.SnakeAndLadder.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

    private Dice dice;

    private List<String> winners;

    private GameConfig gameConfig;

    private List<PlayerData> players;

    private int currentPlayer;

    public Game(Board board, Dice dice, List<PlayerData> players) {
        this.board = board;
        this.dice = dice;
        this.gameConfig = new GameConfig();
        this.players = players;
        winners = new ArrayList<>();
        currentPlayer = 0;
    }

    public void startGame() throws IOException {
        while(winners.size() == 0) {
            // Rolling the dice and making the move
            int rollValue = dice.rollDice();
            currentPlayer = currentPlayer >= players.size() ? 0 : currentPlayer;
            board.makeMove(players.get(currentPlayer), rollValue);

            // Checking if the Player has won
            int currentPlayerRow = players.get(currentPlayer).position.getX();
            int currentPlayerColumn = players.get(currentPlayer).position.getY();

            if(currentPlayerRow == board.row && currentPlayerColumn == board.column) {
                winners.add(players.get(currentPlayer).name);
                players.remove(currentPlayer);
            }
            currentPlayer++;
        }
        board.myWriter.close();
    }
}
