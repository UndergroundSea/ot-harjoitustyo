
package minesweeper;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MineField {

    private Pane[][] grid;
    private boolean alive;
    private int turnedPanes;
    private ArrayList<Integer> mines;
    private boolean turning;

    public MineField(int x, int y) {

        this.grid = new Pane[x][y];
        this.alive = true;
        this.turnedPanes = 0;
        this.mines = new ArrayList<>();
        this.turning = true;

    }

    public void setPane(Pane pane, int x, int y) {
        grid[x][y] = pane;
    }

    public Pane getPane(int x, int y) {
        return grid[x][y];
    }

    public void endGame() {
        this.alive = false;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public ArrayList<Integer> getMines() {
        return this.mines;
    }

    public void addTurnedPane() {
        this.turnedPanes++;
    }

    public int getTurnedPanes() {
        return this.turnedPanes;
    }

    public void setTurnedPanes(int turnedPanes) {
        this.turnedPanes = turnedPanes;
    }

    public void setTurning(boolean turning) {
        this.turning = turning;
    }

    public boolean getTurning() {
        return this.turning;
    }

    public int countValue(Pane pane, int length, int large) {
        int x = pane.getX();
        int y = pane.getY();
        int mines = 0;

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {

                if (i < 0 || j < 0 || i > (length - 1) || j > (large - 1)) {
                    continue;
                }
                if (grid[i][j].getMine()) {
                    mines++;
                }
            }
        }

        pane.setColor(mines);

        return mines;

    }

    public void placeMines(int ammount, int x, int y) {
        int mines = 0;
        Random random = new Random();
        int size = x * y;

        while (mines < ammount) {
            int placedMine = random.nextInt(size);
            if (!this.mines.contains(placedMine)) {
                this.mines.add(placedMine);
                mines++;
            }
        }
    }

    public void placeButtons(GridPane grid, Label gameState, int length, int large, int mines) {
        int timeForAMine = 0;

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < large; y++) {

                Button button = new Button();
                button.setPrefWidth(50);
                button.setPrefHeight(50);

                grid.add(button, x, y);

                Pane pane = new Pane(x, y, button);
                this.setPane(pane, x, y);
                if (this.getMines().contains(timeForAMine)) {
                    pane.setMine(true);
                }

                pane.setOnAction(this, gameState, length, large, mines);

                timeForAMine++;

            }
        }
    }

    public void startGame(GridPane grid, Label gameState, int x, int y, int ammount, String name) {
        gameState.setText("Varo miinoja! // " + name);
        this.grid = new Pane[x][y];
        this.alive = true;
        this.turnedPanes = 0;
        this.mines = new ArrayList<>();
        this.turning = true;
        this.placeMines(ammount, x, y);
        this.placeButtons(grid, gameState, x, y, ammount);
       
    }

}




