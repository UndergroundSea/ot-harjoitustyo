package minefield;

import gamesetting.GameMode;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Luokka, joka hallinoi miinakentän ruutuja, eli painikkeita.
 */
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

    /**
     * Metodi asettaa ruudulle tekstin väriksi värin parametrina annetun
     * miinojen määrän mukaan.
     *
     * @param mines Miinojen määrä, joka määrittää ruudun värin.
     */
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

    /**
     * Asettaa ruudun asetukset käännetyiksi, jolloin sille pätee erilaiset
     * toiminnallisuudet.
     */
    public void turn() {
        this.turned = true;
    }

    public boolean getTurned() {
        return this.turned;
    }

    /**
     * Asettaa ruudun, jonka ympärillä ei ole miinaa, asetukset käännetyiksi,
     * jolloin sille pätee erilaiset toiminnallisuudet.
     */
    public void zeroTurn() {
        this.zeroTurned = true;
    }

    public boolean getZeroTurned() {
        return this.zeroTurned;
    }

    /**
     * Asettaa ruudulle toiminnallisuuksia siitä painaessa. Jos tarpeeksi monta
     * ruutua on käännetty, peli voitetaan.
     *
     * @param minefield Miinakenttä, jossa ruutu on.
     * @param gameState Teksti, joka kertoo pelin tilanteen.
     * @param x Ruudun x-kordinaatti ruudukossa.
     * @param y Ruudun y-kordinaatti ruudukossa.
     * @param mines Miinojen määrä kyseisessä pelissä.
     * @param gamemode Valittu peliasetus.
     */
    public void setOnAction(MineField minefield, Label gameState, int x, int y, int mines, GameMode gamemode) {
        button.setOnAction((event) -> {
            try {
                if (minefield.getTurning()) {
                    if (minefield.getAlive()) {

                        this.turnPane(minefield, gameState, x, y, mines, gamemode);

                    }

                } else {
                    if (minefield.getAlive()) {
                        button.setText("X");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Metodi kääntää ruudun.
     *
     * @param minefield Miinakenttä, jossa ruutu sijaitsee.
     * @param gameState Pelitilanteen teksti.
     * @param x Miinakentän pituus.
     * @param y Miinakentän leveys.
     * @param mines Miinojen määrä miinakentässä.
     * @param gamemode Valittu peliasetus.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void turnPane(MineField minefield, Label gameState, int x, int y, int mines, GameMode gamemode) throws IOException {
        if (this.getMine()) {
            minefield.endGame();
            this.button.setText("¤");
            gameState.setText("Heh heh hee, hävisit pelin!");
        } else if (minefield.countValue(this, x, y) == 0) {

            this.turnZeroPane(minefield, gameState, this, this.button, x, y, mines, gamemode);

        } else {
            this.turnSafePane(minefield, gameState, x, y, mines, gamemode);
        }
    }

    /**
     * Metodi kääntää ruudun, jonka ympärillä ei ole yhtäkään miinaa.
     *
     * @param minefield Miinakenttä, jossa ruutu sijaitsee.
     * @param gameState Pelitilanteen teksti.
     * @param pane Ruutu, joka käännetään.
     * @param button Käännettävän ruudun nappi.
     * @param length Miinakentän pituus.
     * @param large Miinakentän leveys.
     * @param mines Miinojen määrä.
     * @param gamemode Valittu peliasetus.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void turnZeroPane(MineField minefield, Label gameState, Pane pane, Button button, int length, int large, int mines, GameMode gamemode) throws IOException {
        if (minefield.countValue(pane, length, large) == 0) {
            pane.zeroTurn();
            pane.turnSafePane(minefield, gameState, pane, button, length, large, mines, gamemode);

            pane.turnAll(minefield, gameState, pane, button, length, large, mines, gamemode);
            for (int i = pane.getX() - 1; i < pane.getX() + 2; i++) {
                for (int j = pane.getY() - 1; j < pane.getY() + 2; j++) {
                    if (i < 0 || j < 0 || i > (length - 1) || j > (large - 1)) {
                        continue;
                    }
                    if (minefield.countValue(minefield.getPane(i, j), length, large) == 0 && !minefield.getPane(i, j).getZeroTurned()) {
                        minefield.getPane(i, j).turnZeroPane(minefield, gameState, minefield.getPane(i, j), minefield.getPane(i, j).getButton(), length, large, mines, gamemode);

                    }
                }
            }
        }
    }

    /**
     * Metodi kääntää ruudun ympärillä olevat ruudut, joiden ympärillä ei ole
     * yhtäkään miinaa.
     *
     * @param minefield Miinakenttä, jossa ruutu on.
     * @param gameState Pelitilanteen teksti.
     * @param pane Ruutu, jonka ympärillä käännettävät ruudut ovat.
     * @param button Sen ruudun nappi.
     * @param length Miinakentän pituus.
     * @param large Miinakentän leveys.
     * @param mines Miinojen määrä miinakentässä.
     * @param gamemode Valittu peliasetus.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void turnAll(MineField minefield, Label gameState, Pane pane, Button button, int length, int large, int mines, GameMode gamemode) throws IOException {
        for (int i = pane.getX() - 1; i < pane.getX() + 2; i++) {
            for (int j = pane.getY() - 1; j < pane.getY() + 2; j++) {
                if (i < 0 || j < 0 || i > (length - 1) || j > (large - 1)) {
                    continue;
                }
                pane.turnSafePane(minefield, gameState, minefield.getPane(i, j), minefield.getPane(i, j).getButton(), length, large, mines, gamemode);
            }
        }
    }

    /**
     * Metodi kääntää ruudun, jossa ei ole miinaa.
     *
     * @param minefield Miinakenttä, jossa ruutu sijaitsee.
     * @param gameState Pelitilanteen teksti.
     * @param pane Ruutu, joka käännetään.
     * @param button Käännettävän ruudun nappi.
     * @param x Miinakentän pituus.
     * @param y Miinakentän leveys.
     * @param mines Miinakentän miinojen määrä.
     * @param gamemode Valittu peliasetus.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void turnSafePane(MineField minefield, Label gameState, Pane pane, Button button, int x, int y, int mines, GameMode gamemode) throws IOException {
        int win = (x * y) - mines;
        button.setText(Integer.toString(minefield.countValue(pane, x, y)));
        button.setTextFill(pane.getColor());
        if (!pane.getTurned()) {
            minefield.addTurnedPane();
            pane.turn();
        }
        if (minefield.getTurnedPanes() == win) {
            gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
            gamemode.setGamesWon(gamemode.getGamesWon() + 1);
            gamemode.save();
        }
    }

    /**
     * Metodi kääntää ruudun, jossa ei ole miinaa.
     *
     * @param minefield Miinakenttä, jossa ruutu sijaitsee.
     * @param gameState Pelitilanteen teksti.
     * @param length Miinakentän pituus.
     * @param large Miinakentän leveys.
     * @param mines Miinakentän miinojen määrä.
     * @param gamemode Valittu peliasetus.
     * @throws java.io.IOException Jos tulee ongelma tiedoston kanssa.
     */
    public void turnSafePane(MineField minefield, Label gameState, int length, int large, int mines, GameMode gamemode) throws IOException {
        int win = (length * large) - mines;
        this.button.setText(Integer.toString(minefield.countValue(this, length, large)));
        this.button.setTextFill(this.color);
        this.turn();
        minefield.addTurnedPane();
        if (minefield.getTurnedPanes() == win) {
            gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
            int winnings = gamemode.getGamesWon();
            winnings++;
            gamemode.setGamesWon(winnings);
            gamemode.save();
        }
    }

}
