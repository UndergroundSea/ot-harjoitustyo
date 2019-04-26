import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
//        gameState.setText("Hi hi hiii, kutittaa! Voitit pelin!");
//        minefield.setPane(pane, 0, 0);
        
    }
    
    @After
    public void tearDown() {
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
    
//     @Test
//     public void hello() {}
     
//     @Test
//     public void setAndGetValue() {
////         Pane pane = new Pane(10, 1, new Button("miina"));
//         pane.setMine(true);
//         assertEquals(true, pane.getMine());
//     }
    
    @Test
    public void endTheGame() {
//        MineField minefield = new MineField(10, 5);
        minefield.endGame();
        assertEquals(false, minefield.getAlive());
    }
    
    @Test
    public void addingTurnedPane() {
        minefield.addTurnedPane();
        assertEquals(1, minefield.getTurnedPanes());
    }
//    
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
    
    
    





    
    
    
    
//    @Test
//    public void placingButtons() {
//        minefield.placeButtons(grid, gameState);
//        assertEquals(50, timeForAMine);
//    }
    
//    @Test
//    public void winningTheGame() {
//        Label gameState = new Label("Varo miinoja!");
//        for (int i = 0; i < 42; i++) {
//            minefield.addTurnedPane();
//        }
//        pane.turnPane(minefield, gameState);
//        assertEquals("Hi hi hiii, kutittaa! Voitit pelin!", gameState.getText());
//    }
    
//    kortti.lataaRahaa(100);
//        assertEquals("saldo: 1.10", kortti.toString());
    
}
