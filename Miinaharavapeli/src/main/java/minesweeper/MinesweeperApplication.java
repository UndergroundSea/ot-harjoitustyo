package minesweeper;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MinesweeperApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Font normalFont = Font.font(40);

        Label gameState = new Label("Varo miinoja!");
        gameState.setFont(normalFont);

        BorderPane layout = new BorderPane();

        layout.setTop(gameState);
        layout.setPadding(new Insets(10, 10, 10, 10));

        GridPane mineField = new GridPane();
        mineField.setHgap(10);
        mineField.setVgap(10);
        mineField.setPadding(new Insets(100, 50, 50, 50));

        MineField minefield = new MineField(10, 5);

        int mines = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int placedMine = random.nextInt(50);
            if (!list.contains(placedMine)) {
                list.add(placedMine);
                mines++;
            }
        }

        int timeForAMine = 0;

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {

                Button button = new Button();
//                button.setFont(normalFont);
                button.setPrefWidth(50);
                button.setPrefHeight(50);

                mineField.add(button, x, y);

                Pane pane = new Pane(x, y, button);
                minefield.setPane(pane, x, y);
                if (list.contains(timeForAMine)) {
                    pane.setMine(true);
                }
//                pane.setMine(true);

                button.setOnAction((event) -> {
                    if (minefield.getAlive()) {
                        if (pane.getMine()) {
                            minefield.endGame();
                            button.setText("¤");
                            gameState.setText("Heh heh hee, hävisit pelin!");
                        } else {
//                        minefield.countValue(pane);
                            button.setText(Integer.toString(minefield.countValue(pane)));
                            pane.turn();
                            minefield.turnPane();
                            if (minefield.getTurnedPanes() == 43) {
                                gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
                            }
                        }
                    }

                });

                timeForAMine++;

            }
        }

        layout.setCenter(mineField);

        Scene outlook = new Scene(layout);

        stage.setScene(outlook);
        stage.show();

    }

    public static void main(String[] args) {
        launch(MinesweeperApplication.class);
//        System.out.println("Hello world");
    }

}
