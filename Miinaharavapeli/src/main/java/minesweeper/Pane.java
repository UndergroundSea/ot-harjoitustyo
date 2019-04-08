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

    public Pane(int x, int y, Button button) {

        this.x = x;
        this.y = y;
        this.mine = false;
        this.value = 99;
        this.button = button;
        this.turned = false;
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

    public void turn() {
        this.turned = true;
    }

    public void setOnAction(MineField minefield, Label gameState) {
        button.setOnAction((event) -> {
            if (minefield.getTurning()) {
                if (minefield.getAlive()) {

                    this.turnPane(minefield, gameState);

                }

            } else {
                if (minefield.getAlive()) {
                    button.setText("X");
                }
            }

        });
    }

    public void turnPane(MineField minefield, Label gameState) {
        if (this.getMine()) {
            minefield.endGame();
            button.setText("¤");
            gameState.setText("Heh heh hee, hävisit pelin!");
        } else {
            button.setText(Integer.toString(minefield.countValue(this)));
            button.setTextFill(this.color);
            this.turn();            
            minefield.addTurnedPane();            
            if (minefield.getTurnedPanes() == 43) {
                gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
            }
        }
    }

}

//                    if (this.getMine()) {
//                        minefield.endGame();
//                        button.setText("¤");
//                        gameState.setText("Heh heh hee, hävisit pelin!");
//                    } else {
//                        button.setText(Integer.toString(minefield.countValue(this)));
//                        button.setTextFill(this.color);
//                        this.turn();
//                        minefield.addTurnedPane();
//                        if (minefield.getTurnedPanes() == 43) {
//                            gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
//                        }
//                    }
