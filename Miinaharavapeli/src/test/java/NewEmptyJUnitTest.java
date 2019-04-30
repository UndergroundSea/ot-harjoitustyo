import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import minesweeper.GameMode;
import minesweeper.MineField;
import minesweeper.Pane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class NewEmptyJUnitTest {
    
    MineField minefield;
    Label gameState;
    GridPane grid;
    Pane pane;
    Button button;
    BorderPane layout;
    GameMode easy;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }  
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        minefield = new MineField(10, 5);
        pane = new Pane(0, 0, button);
        easy = new GameMode(10, 5, 7, "Helppo");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void endTheGame() {
        minefield.endGame();
        assertEquals(false, minefield.getAlive());
    }
    
    @Test
    public void addingTurnedPane() {
        minefield.addTurnedPane();
        assertEquals(1, minefield.getTurnedPanes());
    }
    
    @Test
    public void placeMines() {
        minefield.placeMines(7, 10, 5);
        assertEquals(7, minefield.getMines().size());       
    }
    
    @Test
    public void settingColor() {
        pane.setColor(Color.BLUE);
        assertEquals(Color.BLUE, pane.getColor());
    }
    
    @Test
    public void settingOtherColor() {
        pane.setColor(1);
        assertEquals(Color.GREEN, pane.getColor());
    }
    
    @Test
    public void settingAndGettingValue() {
        pane.setValue(4);
        assertEquals(4, pane.getValue());
    }
    
    @Test
    public void ammountOfMines() {
        assertEquals(7, easy.getMines());
    }
    
    
      
    
}
