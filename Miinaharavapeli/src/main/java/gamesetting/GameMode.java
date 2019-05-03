package gamesetting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import minefield.MineField;

/**
 * Metodi luo peliasetukset, joiden ansiosta pelin vaikeusasteen pystyy
 * muuttamaan. Luokalla on myös metodi, joka luo pelikentän.
 */
public class GameMode {

    private int x;
    private int y;
    private int mines;
    private String name;
    private BorderPane layout;
    private HBox settingButtons;
    private Button turn;
    private Button bewareMine;
    private int gamesWon;

    public GameMode(int x, int y, int mines, String name) {

        this.x = x;
        this.y = y;
        this.mines = mines;
        this.name = name;
        this.layout = new BorderPane();

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getMines() {
        return this.mines;
    }

    public String getName() {
        return this.name;
    }

    public BorderPane getLayout() {
        return this.layout;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }

    public void setGamesWon(int i) {
        this.gamesWon = i;
    }

    /**
     * Metodi luo pelikentän, luokan asetusten perusteella.
     *
     * @param stage Näyttö jolla peli näytetään.
     * @param gamemode Valittu peliasetus.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void createGame(Stage stage, GameMode gamemode) throws IOException {
        MineField minefield = new MineField(this.x, this.y);

        Font normalFont = Font.font(35);
        this.load();

        Label gameState = new Label("Varo miinoja! // " + this.name);
        Label winningRecord = new Label("Voitetut pelit: " + Integer.toString(this.gamesWon));
        gameState.setFont(normalFont);
        winningRecord.setFont(normalFont);
        gameState.setPadding(new Insets(20, 50, 5, 50));
        winningRecord.setPadding(new Insets(20, 50, 5, 50));
        VBox labels = new VBox(5);
        labels.getChildren().addAll(gameState, winningRecord);

        this.setButtons(minefield);

        this.settingButtons.getChildren().addAll(this.turn, this.bewareMine);

        Button newGame = new Button("Uusi peli");

        this.layout.setRight(newGame);
        this.layout.setTop(labels);
        this.layout.setCenter(settingButtons);
        this.layout.setPadding(new Insets(10, 70, 10, 10));

        GridPane grid = new GridPane();
        this.setGridPaneSize(grid);

        this.setNewGameOnAction(newGame, minefield, grid, gameState, stage, gamemode);

        minefield.placeMines(this.mines, this.x, this.y);
        minefield.placeButtons(grid, gameState, this.x, this.y, this.mines, gamemode);

        this.layout.setBottom(grid);

    }

    /**
     * Metodi asettaa painikkeet toimintoineen, joilla päätetään halutaanko
     * kääntää ruutu, vai merkata miina.
     *
     * @param minefield Miinakenttä, jolle nämä painikkeet luodaan.
     */
    public void setButtons(MineField minefield) {
        this.settingButtons = new HBox(10);
        this.settingButtons.setPadding(new Insets(30, 50, 20, 50));
        this.turn = new Button("käännä");
        this.bewareMine = new Button("miina");
        this.turn.setPrefWidth(75);
        this.bewareMine.setPrefWidth(75);
        this.turn.setPrefHeight(35);
        this.bewareMine.setPrefHeight(35);
        this.turn.setOnAction((event) -> {
            minefield.setTurning(true);
        });
        this.bewareMine.setOnAction((event) -> {
            minefield.setTurning(false);
        });
    }

    /**
     * Metodi asettaa toiminnon painikkeelle, joka luo uuden pelin.
     *
     * @param button Painike, josta painamalla uusi peli luodaan.
     * @param minefield Miinakenttä, jolle luodaan uusi peli.
     * @param grid Pelikentän ruudukko.
     * @param gameState Pelitilanteen teksti.
     * @param stage Näyttö jolla peli näytetään.
     * @param gamemode Valittu peliasetus.
     */
    public void setNewGameOnAction(Button button, MineField minefield, GridPane grid, Label gameState, Stage stage, GameMode gamemode) {
        button.setOnAction((event) -> {
            try {
                minefield.startGame(grid, gameState, this.x, this.y, this.mines, this.name, gamemode);
                StartingInterface newGameInterface = new StartingInterface();
                Scene outlook = new Scene(newGameInterface.getStartingView());
                newGameInterface.createStartingInterface(stage, outlook);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Asettaa oikean koon ruudukolle.
     *
     * @param grid Ruudukko, jolle koko asetetaan.
     */
    public void setGridPaneSize(GridPane grid) {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 0, 50, 50));
    }

    /**
     * Tallentaa voitettujen pelien määrän.
     * 
     * @throws IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void save() throws IOException {
        File file = new File("save.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            int winnings = this.gamesWon;
            System.out.println(winnings);
            writer.write(winnings + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lataa muistista voitettujen pelien määrän.
     * 
     * @throws FileNotFoundException Jos tiedostoa ei ole.
     * @throws IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void load() throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream("save.txt");
        BufferedReader buf = new BufferedReader(new InputStreamReader(input));

        String line = buf.readLine();
        List<String> lines = new ArrayList<>();

        while (line != null) {
            lines.add(line);
            line = buf.readLine();
        }
        
        this.setGamesWon(Integer.parseInt(lines.get(0)));
    }

}
