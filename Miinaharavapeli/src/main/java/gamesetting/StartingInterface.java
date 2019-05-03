package gamesetting;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Luokka, joka hallinnoi pelin aloitusnäkymää.
 */
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

    /**
     * Metodi luo aloitusnäkymän, josta voi valita pelin vaikeusasteen.
     *
     * @param stage Näyttö jolla peli näytetään.
     * @param outlook Kuva, joka näytetään näytöllä.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void createStartingInterface(Stage stage, Scene outlook) throws IOException {

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

        this.setNormalSize(easyMode, mediumMode, hardMode, insaneMode);

        this.setOnAction(stage);

        gameModes.getChildren().addAll(easyMode, mediumMode, hardMode, insaneMode);

        this.startingView.setCenter(gameModes);
        stage.setScene(outlook);
    }

    public BorderPane getStartingView() {
        return this.startingView;
    }

    /**
     * Metodi asettaa kaikille aloitusnäytön painikkeille toiminnallisuudet.
     *
     * @param stage Näyttö jolla peli näytetään.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void setOnAction(Stage stage) throws IOException {
        BorderPane gameField = new BorderPane();

        this.setButtonOnAction(this.easyMode, easy, stage);
        this.setButtonOnAction(this.mediumMode, medium, stage);
        this.setButtonOnAction(this.hardMode, hard, stage);
        this.setButtonOnAction(this.insaneMode, insane, stage);
    }

    /**
     * Metodi asettaa painikkeelle toiminnallisuuden, joka luo pelikentän
     * metodille annettujen parametrien mukaan.
     *
     * @param button Painike, jolle toiminnallisuus tehdään.
     * @param gamemode Peliasetus, jonka mukaan luodaan pelikenttä painikkeesta
     * painaessa.
     * @param stage Näyttö jolla peli näytetään.
     */
    public void setButtonOnAction(Button button, GameMode gamemode, Stage stage){
        button.setOnAction((event) -> {
            try {
                gamemode.createGame(stage, gamemode);
                Scene gameMode = new Scene(gamemode.getLayout());
                stage.setScene(gameMode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Metodi asettaa neljälle painikkeelle tietyn koon.
     *
     * @param first Ensimmäinen painike, jolle koko asetetaan.
     * @param second toinen painike, jolle koko asetetaan.
     * @param third kolmas painike, jolle koko asetetaan.
     * @param fourth neljäs painike, jolle koko asetetaan.
     */
    public void setNormalSize(Button first, Button second, Button third, Button fourth) {
        first.setPrefWidth(125);
        second.setPrefWidth(125);
        third.setPrefWidth(125);
        fourth.setPrefWidth(125);

        first.setPrefHeight(35);
        second.setPrefHeight(35);
        third.setPrefHeight(35);
        fourth.setPrefHeight(35);
    }

}
