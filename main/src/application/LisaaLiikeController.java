package application;



import java.io.IOException;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * 
 * @author Kmontasi
 *14.02.2022
 */

public class LisaaLiikeController {

	

	    @FXML
	    private Button jatkaButton;
	    	
	    @FXML
	    private Button lopetaButton;
	    	
	    @FXML
	    void handleJatka(ActionEvent event) {
	    	jatka();
	    }



		@FXML
	    void handleLopeta(ActionEvent event) {
	    	lopeta();
	    }

	    @FXML
	    void redirTakaisin(ActionEvent event) {
	    	paanaytto();
	    	poista();
	    }
	    //================================================
	    private void lopeta() {
	    	Platform.exit();
	    }
	    /*
		 * takaisin päänäytölle
		 */
	    private void paanaytto() {
	    	try {        
		        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("UusiTreeni.fxml"));
		        Scene scene = new Scene(root, 600, 374.4);
		        Stage stage = new Stage();
		        stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
			
		}
	    /*
		 * siirryttyä halutulle näytölle suljetaan edellinen ikkuna
		 */
		private void poista() {
	    	
	    	Window stage = lopetaButton.getScene().getWindow();
	    	stage.hide();
	    }
		
	    private void jatka() {
	    	Dialogs.showMessageDialog("ei toimi");
			
		}
	}

