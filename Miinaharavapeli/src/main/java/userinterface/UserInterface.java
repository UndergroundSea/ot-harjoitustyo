
package userinterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import minesweeper.GameMode;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       
        GameMode easy = new GameMode(10, 5, 7, "Helppo");
        GameMode medium = new GameMode(12, 7, 12, "Keskitaso");
        GameMode hard = new GameMode(15, 9, 20, "Vaikea");
        GameMode insane = new GameMode(20, 15, 50, "Hullu!");
        
        BorderPane layout = new BorderPane();
        BorderPane starting = new BorderPane();
        HBox gameModes = new HBox();
        VBox text = new VBox();
        
        Label gameName = new Label("Miinaharava");
        gameName.setPadding(new Insets(0, 50, 50, 0));
        Label gameText = new Label("Valitse vaikeusaste");
        gameText.setPadding(new Insets(0, 50, 50, 0));
        gameModes.setPadding(new Insets(40, 0, 100, 60));
        
        text.getChildren().addAll(gameName, gameText);
        text.setPadding(new Insets(60, 50, 20, 80));
        starting.setTop(text);
        
        starting.setPadding(new Insets(0, 120, 50, 20));
        Button easyMode = new Button("Helppo");
        Button mediumMode = new Button("Keskitaso");
        Button hardMode = new Button("Vaikea");
        Button insaneMode = new Button("Hullu!");
        
        easyMode.setPrefWidth(125);
        mediumMode.setPrefWidth(125);
        hardMode.setPrefWidth(125);
        insaneMode.setPrefWidth(125);
        
        easyMode.setPrefHeight(35);
        mediumMode.setPrefHeight(35);
        hardMode.setPrefHeight(35);
        insaneMode.setPrefHeight(35);
        
        easyMode.setOnAction((event) -> {
            easy.createGame(layout);
            Scene gameMode = new Scene(layout);
            stage.setScene(gameMode);
        });
        mediumMode.setOnAction((event) -> {
            medium.createGame(layout);
            Scene gameMode = new Scene(layout);
            stage.setScene(gameMode);
        });
        hardMode.setOnAction((event) -> {
            hard.createGame(layout);
            Scene gameMode = new Scene(layout);
            stage.setScene(gameMode);
        });
        insaneMode.setOnAction((event) -> {
            insane.createGame(layout);
            Scene gameMode = new Scene(layout);
            stage.setScene(gameMode);
        });
        
        gameModes.getChildren().addAll(easyMode, mediumMode, hardMode, insaneMode);

       starting.setCenter(gameModes);


//        medium.createGame(layout);
       
       

        Scene outlook = new Scene(starting);

        stage.setScene(outlook);
        stage.show();

    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

}



















//package minesweeper;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//public class UserInterface extends Application {
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        
//        MineField minefield = new MineField(10, 5);
//
//        Font normalFont = Font.font(35);
//
//        Label gameState = new Label("Varo miinoja!");
//        gameState.setFont(normalFont);
//        gameState.setPadding(new Insets(20, 50, 5, 50));
//        
//        HBox settingButtons = new HBox(10);
//        settingButtons.setPadding(new Insets(30, 50, 20, 50));
//        Button turn = new Button("käännä");
//        Button bewareMine = new Button("miina");
//        turn.setPrefWidth(75);
//        bewareMine.setPrefWidth(75);
//        turn.setPrefHeight(35);
//        bewareMine.setPrefHeight(35);
//        turn.setOnAction((event) -> {
//            minefield.setTurning(true);
//        });
//        bewareMine.setOnAction((event) -> {
//            minefield.setTurning(false);
//        });
//        
//        settingButtons.getChildren().addAll(turn, bewareMine);
//        
//        Button newGame = new Button("Uusi peli");
//        
//        BorderPane layout = new BorderPane();
//                
//        layout.setRight(newGame);
//
//        layout.setTop(gameState);
//        layout.setCenter(settingButtons);
//        layout.setPadding(new Insets(10, 70, 10, 10));
//
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(20, 0, 50, 50));  
//        
//        newGame.setOnAction((event) -> {
//            minefield.startGame(grid, gameState, 10, 5);
//        });
//
//        minefield.placeMines();
//        minefield.placeButtons(grid, gameState);
//
//        layout.setBottom(grid);
//        
//        
//
//        Scene outlook = new Scene(layout);
//
//        stage.setScene(outlook);
//        stage.show();
//
//    }
//
//    public static void main(String[] args) {
//        launch(UserInterface.class);
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
////        int mines = 0;
////        ArrayList<Integer> list = new ArrayList<>();
////        Random random = new Random();
////
////        for (int i = 0; i < 7; i++) {
////            int placedMine = random.nextInt(50);
////            if (!list.contains(placedMine)) {
////                list.add(placedMine);
////                mines++;
////            }
////        }
//
//
//
//
//
//
////                pane.setMine(true);
//
////                button.setOnAction((event) -> {
////                    if (minefield.getAlive()) {
////                        if (pane.getMine()) {
////                            minefield.endGame();
////                            button.setText("¤");
////                            gameState.setText("Heh heh hee, hävisit pelin!");
////                        } else {
//////                        minefield.countValue(pane);
////                            button.setText(Integer.toString(minefield.countValue(pane)));
////                            pane.turn();
////                            minefield.turnPane();
////                            if (minefield.getTurnedPanes() == 43) {
////                                gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
////                            }
////                        }
////                    }
////
////                });
//
//
//
////        int timeForAMine = 0;
////
////        for (int x = 0; x < 10; x++) {
////            for (int y = 0; y < 5; y++) {
////
////                Button button = new Button();
//////                button.setFont(normalFont);
////                button.setPrefWidth(50);
////                button.setPrefHeight(50);
////
////                grid.add(button, x, y);
////
////                Pane pane = new Pane(x, y, button);
////                minefield.setPane(pane, x, y);
////                if (minefield.getMines().contains(timeForAMine)) {
////                    pane.setMine(true);
////                }
////
////                pane.setOnAction(minefield, gameState);
////
////                timeForAMine++;
////
////            }
////        }
