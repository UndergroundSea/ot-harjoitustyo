
package minesweeper;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Pane {

    private int x;
    private int y;
    private boolean mine;
    private int value;
    private Button button;
    private boolean turned;
    private Color color;
    private boolean zeroTurned;

    public Pane(int x, int y, Button button) {

        this.x = x;
        this.y = y;
        this.mine = false;
        this.value = 99;
        this.button = button;
        this.turned = false;
        this.zeroTurned = false;
        this.color = Color.BLACK;

    }

    public void setValue(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getMine() {
        return this.mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColor(int mines) {
        if (mines == 0) {
            this.setColor(Color.WHITE);
        } else if (mines == 1) {
            this.setColor(Color.GREEN);
        } else if (mines == 2) {
            this.setColor(Color.BLUE);
        } else if (mines == 3) {
            this.setColor(Color.RED);
        } else {
            this.setColor(Color.DARKRED);
        }
    }

    public Color getColor() {
        return this.color;
    }

    public Button getButton() {
        return this.button;
    }

    public void turn() {
        this.turned = true;
    }

    public boolean getTurned() {
        return this.turned;
    }

    public void zeroTurn() {
        this.zeroTurned = true;
    }

    public boolean getZeroTurned() {
        return this.zeroTurned;
    }

    public void setOnAction(MineField minefield, Label gameState, int x, int y, int mines) {
        button.setOnAction((event) -> {
            if (minefield.getTurning()) {
                if (minefield.getAlive()) {

                    this.turnPane(minefield, gameState, x, y, mines);

                }

            } else {
                if (minefield.getAlive()) {
                    button.setText("X");
                }
            }

        });
    }

    public void turnPane(MineField minefield, Label gameState, int x, int y, int mines) {
        if (this.getMine()) {
            minefield.endGame();
            this.button.setText("¤");
            gameState.setText("Heh heh hee, hävisit pelin!");
        } else if (minefield.countValue(this, x, y) == 0) {


            this.turnZeroPane(minefield, gameState, this, this.button, x, y, mines);

//            this.turnSafePane(minefield, gameState);
        } else {
            this.turnSafePane(minefield, gameState, x, y, mines);
        }
    }


    public void turnZeroPane(MineField minefield, Label gameState, Pane pane, Button button, int length, int large, int mines) {
        if (minefield.countValue(pane, length, large) == 0) {
            pane.zeroTurn();
            pane.turnSafePane(minefield, gameState, pane, button, length, large, mines);

            pane.turnAll(minefield, gameState, pane, button, length, large, mines);
            for (int i = pane.getX() - 1; i < pane.getX() + 2; i++) {
                for (int j = pane.getY() - 1; j < pane.getY() + 2; j++) {
                    if (i < 0 || j < 0 || i > (length - 1) || j > (large - 1)) {
                        continue;
                    }
                    if (minefield.countValue(minefield.getPane(i, j), length, large) == 0 && !minefield.getPane(i, j).getZeroTurned()) {
                        minefield.getPane(i, j).turnZeroPane(minefield, gameState, minefield.getPane(i, j), minefield.getPane(i, j).getButton(), length, large, mines);

                    }
                }
            }
        }
    }    

    public void turnAll(MineField minefield, Label gameState, Pane pane, Button button, int length, int large, int mines) {
        for (int i = pane.getX() - 1; i < pane.getX() + 2; i++) {
            for (int j = pane.getY() - 1; j < pane.getY() + 2; j++) {
                if (i < 0 || j < 0 || i > (length - 1) || j > (large - 1)) {
                    continue;
                }
                pane.turnSafePane(minefield, gameState, minefield.getPane(i, j), minefield.getPane(i, j).getButton(), length, large, mines);
            }
        }
    }

    public void turnSafePane(MineField minefield, Label gameState, Pane pane, Button button, int x, int y, int mines) {
        int win = (x * y) - mines;
        button.setText(Integer.toString(minefield.countValue(pane, x, y)));
        button.setTextFill(pane.getColor());
        if (!pane.getTurned()) {
            minefield.addTurnedPane();
            pane.turn();
        }
        if (minefield.getTurnedPanes() == win) {
            gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");

        }
    }

    public void turnSafePane(MineField minefield, Label gameState, int length, int large, int mines) {
        int win = (length * large) - mines;
        this.button.setText(Integer.toString(minefield.countValue(this, length, large)));
        this.button.setTextFill(this.color);
        this.turn();
        minefield.addTurnedPane();
        if (minefield.getTurnedPanes() == win) {
            gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
        }
    }

}















