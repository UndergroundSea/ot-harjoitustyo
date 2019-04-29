package minesweeper;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Metodi luo peliasetukset, joiden ansiosta pelin vaikeusasteen pystyy muuttamaan.
 * Luokalla on myös metodi, joka luo pelikentän. 
 */
public class GameMode {
   
    private int x;
    private int y;
    private int mines;
    private String name;
    private BorderPane layout;
   
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
   
    /**
     * Metodi luo pelikentän parametrina annetulle pohjalle luokan asetusten perusteella.
     * 
     * @param layout Pohja jolle pelikenttä luodaan.
     */
    public void createGame(Stage stage) {
        MineField minefield = new MineField(this.x, this.y);

        Font normalFont = Font.font(35);

        Label gameState = new Label("Varo miinoja! // " + this.name);
        gameState.setFont(normalFont);
        gameState.setPadding(new Insets(20, 50, 5, 50));
       
        HBox settingButtons = new HBox(10);
        settingButtons.setPadding(new Insets(30, 50, 20, 50));
        Button turn = new Button("käännä");
        Button bewareMine = new Button("miina");
        turn.setPrefWidth(75);
        bewareMine.setPrefWidth(75);
        turn.setPrefHeight(35);
        bewareMine.setPrefHeight(35);
        turn.setOnAction((event) -> {
            minefield.setTurning(true);
        });
        bewareMine.setOnAction((event) -> {
            minefield.setTurning(false);
        });
       
        settingButtons.getChildren().addAll(turn, bewareMine);
       
        Button newGame = new Button("Uusi peli");
               
        this.layout.setRight(newGame);
        this.layout.setTop(gameState);
        this.layout.setCenter(settingButtons);
        this.layout.setPadding(new Insets(10, 70, 10, 10));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 0, 50, 50));  
        
        
       
        newGame.setOnAction((event) -> {
            minefield.startGame(grid, gameState, this.x, this.y, this.mines, this.name);
            StartingInterface newGameInterface = new StartingInterface(); 
            Scene outlook = new Scene(newGameInterface.getStartingView());
            newGameInterface.createStartingInterface(stage, outlook);
        });

        minefield.placeMines(this.mines, this.x, this.y);
        minefield.placeButtons(grid, gameState, this.x, this.y, this.mines);

        this.layout.setBottom(grid);
        
//        Scene outlook = new Scene(layout);
    }
   
}