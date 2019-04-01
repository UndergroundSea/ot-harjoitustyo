package minesweeper;

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

//        Label gameMode = new Label("Helppo");
//        gameMode.setFont(normalFont);

        BorderPane layout = new BorderPane();

//        layout.setTop(gameMode);

        GridPane mineField = new GridPane();
        mineField.setHgap(10);
        mineField.setVgap(10);
        mineField.setPadding(new Insets(200, 50, 100, 50));

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {
                
                Button button = new Button();
                button.setFont(normalFont);
                
                mineField.add(button, x, y);
                
                

            }
        }

        layout.setCenter(mineField);

        Scene outlook = new Scene(layout);

        stage.setScene(outlook);
        stage.show();

    }

    public static void main(String[] args) {
        launch(MinesweeperApplication.class);
        System.out.println("Hello world");
    }

}
