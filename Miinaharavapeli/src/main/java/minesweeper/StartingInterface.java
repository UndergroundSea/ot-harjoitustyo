package minesweeper;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartingInterface {
    
    private GameMode easy;
    private GameMode medium;
    private GameMode hard;
    private GameMode insane;
    private Button easyMode;
    private Button mediumMode;
    private Button hardMode;
    private Button insaneMode;
    private BorderPane startingView;
    
    public StartingInterface() {
        easy = new GameMode(10, 5, 7, "Helppo");
        medium = new GameMode(12, 7, 12, "Keskitaso");
        hard = new GameMode(15, 9, 20, "Vaikea");
        insane = new GameMode(20, 15, 50, "Hullu!");
        easyMode = new Button("Helppo");
        mediumMode = new Button("Keskitaso");
        hardMode = new Button("Vaikea");
        insaneMode = new Button("Hullu!");
        startingView = new BorderPane();
    }
    
    public void createStartingInterface(Stage stage, Scene outlook) {
        
        HBox gameModes = new HBox();
        VBox text = new VBox();
        
        Label gameName = new Label("Miinaharava");
        gameName.setPadding(new Insets(0, 50, 50, 0));
        Label gameText = new Label("Valitse vaikeusaste");
        gameText.setPadding(new Insets(0, 50, 50, 0));
        gameModes.setPadding(new Insets(40, 0, 100, 60));
        
        text.getChildren().addAll(gameName, gameText);
        text.setPadding(new Insets(60, 50, 20, 80));
        this.startingView.setTop(text);
        
        this.startingView.setPadding(new Insets(0, 120, 50, 20));
        
        
        this.easyMode.setPrefWidth(125);
        this.mediumMode.setPrefWidth(125);
        this.hardMode.setPrefWidth(125);
        this.insaneMode.setPrefWidth(125);
        
        this.easyMode.setPrefHeight(35);
        this.mediumMode.setPrefHeight(35);
        this.hardMode.setPrefHeight(35);
        this.insaneMode.setPrefHeight(35);
        
        this.setOnAction(stage);
        
        gameModes.getChildren().addAll(easyMode, mediumMode, hardMode, insaneMode);
        
        this.startingView.setCenter(gameModes);
        stage.setScene(outlook);
    }
    
    public BorderPane getStartingView() {
        return this.startingView;
    }
    
    public void setOnAction(Stage stage) {
        BorderPane gameField = new BorderPane();
//        Scene outlook = new Scene(gameField);
        
        this.easyMode.setOnAction((event) -> {
            this.easy.createGame(stage);
            Scene gameMode = new Scene(easy.getLayout());
            stage.setScene(gameMode);
        });
        this.mediumMode.setOnAction((event) -> {
            this.medium.createGame(stage);
            Scene gameMode = new Scene(medium.getLayout());
            stage.setScene(gameMode);
        });
        this.hardMode.setOnAction((event) -> {
            this.hard.createGame(stage);
            Scene gameMode = new Scene(hard.getLayout());
            stage.setScene(gameMode);
        });
        this.insaneMode.setOnAction((event) -> {
            this.insane.createGame(stage);
            Scene gameMode = new Scene(insane.getLayout());
            stage.setScene(gameMode);
        });
    }
    
}
