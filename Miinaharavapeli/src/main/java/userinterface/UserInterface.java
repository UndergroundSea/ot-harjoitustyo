
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


