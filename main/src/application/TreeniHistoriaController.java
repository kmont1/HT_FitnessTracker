package application;



import java.io.IOException;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TreeniHistoriaController {

    @FXML
    private Menu mainLopeta;
    @FXML
    private Button rekisteroidyButton;

    @FXML
    void handleLopeta(ActionEvent event) {
    	lopeta();
    }

    @FXML
    void handlePaanaytto(ActionEvent event) {
    	rekisteroidy();
    	poista();
    }

//=================================================================
    
    private void lopeta() {
    	
    }
    
    private void rekisteroidy() {
    	Dialogs.showMessageDialog("kirjautumista ei ole vielä lisätty");
    	
    	redirMainMenu();
    }
    
    private void redirMainMenu() {
    	try {        
	        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("paanaytto.fxml"));
	        Scene scene = new Scene(root, 600, 374.4);
	        Stage stage = new Stage();
	        stage.setTitle("New Window");
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
	}

	private void poista() {
    	
    	Window stage = rekisteroidyButton.getScene().getWindow();
    	stage.hide();
    }
}

