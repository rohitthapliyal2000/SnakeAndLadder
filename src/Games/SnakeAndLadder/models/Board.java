package Games.SnakeAndLadder.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Board {
    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    public final int row;
    public final int column;
    FileWriter myWriter;

    public Board(List<Snake> snakes, List<Ladder> ladders, int row, int column) throws IOException {
        this.snakes = snakes;
        this.ladders = ladders;
        this.row = row;
        this.column = column;
        myWriter = new FileWriter("output.txt");
    }

    public void makeMove(PlayerData playerData, int rollValue) throws IOException {
        // Getting Player's current position
        Dimension positionBeforeMove = new Dimension(
                playerData.position.getX(), playerData.position.getY());
        int currentRow = positionBeforeMove.getX(), currentColumn = positionBeforeMove.getY();
        for (int i = 0; i < rollValue; i++) {
            currentColumn++;

            // Moving from out of the board to first row
            if(currentRow == 0) {
                positionBeforeMove.setX(1);
                currentRow = 1;
            }

            if (currentColumn > column) {
                currentRow++;
                currentColumn = 1;
            }
        }

        // Invalid move: Moving out of the board
        if (currentRow > row || currentColumn > column) {
            return;
        }

        // Checking the position for snake and ladder entry
        boolean snakeOrLadderFound;
        do {
            snakeOrLadderFound = false;
            for (Snake snake : snakes) {
                // Snake found at the current position
                if(snake.start.getX() == currentRow && snake.start.getY() == currentColumn) {
                    snakeOrLadderFound = true;
                    currentRow = snake.end.getX();
                    currentColumn = snake.end.getY();
                }
            }

            for (Ladder ladder : ladders) {
                // Ladder found at the current position
                if(ladder.start.getX() == currentRow && ladder.start.getY() == currentColumn) {
                    snakeOrLadderFound = true;
                    currentRow = ladder.end.getX();
                    currentColumn = ladder.end.getY();
                }
            }
        } while(snakeOrLadderFound);

        playerData.position.setX(currentRow);
        playerData.position.setY(currentColumn);

        printTheMove(playerData, rollValue, positionBeforeMove, playerData.position);
    }

    private void printTheMove(PlayerData playerData,
                              int rollValue,
                              Dimension positionBeforeMove,
                              Dimension positionAfterMove) throws IOException {
        System.out.println(positionBeforeMove.getX() + " " + positionBeforeMove.getY());
        System.out.println(positionAfterMove.getX() + " " + positionAfterMove.getY());
        int decimalPositionBeforeMove = (positionBeforeMove.getX()-1) * 10 + positionBeforeMove.getY();
        int decimalPositionAfterMove = (positionAfterMove.getX()-1) * 10 + positionAfterMove.getY();
        System.out.printf(playerData.name + " rolled a " + rollValue + " and moved from " +
                decimalPositionBeforeMove + " to " + decimalPositionAfterMove);
        myWriter.write(playerData.name + " rolled a " + rollValue + " and moved from " +
                decimalPositionBeforeMove + " to " + decimalPositionAfterMove + "\n");
    }
}
