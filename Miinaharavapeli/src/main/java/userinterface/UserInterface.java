
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
import minesweeper.StartingInterface;

/**
 * Sovelluksen graafinen käyttöliittymä
 */
public class UserInterface extends Application {

    /**
     * Luo sovelluksen aloitusnäkymän, josta voi valita pelin vaikeusasteen.
     * 
     * @param stage Paikka johon aloitusnäkymä tulee esille.
     * 
     * @throws Exception Virhetilanteessa annetaan Javan hoitaa homma.
     */
    @Override
    public void start(Stage stage) throws Exception {

        StartingInterface start = new StartingInterface();
              
        BorderPane layout = new BorderPane();
                
        Scene outlook = new Scene(start.getStartingView());
        
        start.createStartingInterface(stage, outlook);
        
        stage.show();

    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

}


