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

public class PaanayttoController {
		
		@FXML
		private Button lopetaButton;
		
	   @FXML
	    private Menu mainLopeta;

	    @FXML
	    void handleLopeta(ActionEvent event) {
	    	lopeta();
	    }

	    @FXML
	    void redirAsetukset(ActionEvent event) {
	    	asetukset();
	    	poista();
	    	
	    }

	    @FXML
	    void redirLis‰‰Treeni(ActionEvent event) {
	    	lisaaTreeni();
	    	poista();
	    }

	    @FXML
	    void redirTreeniHistoria(ActionEvent event) {
	    	lisaaTreeniHistoria();
	    	poista();
	    }
//=============================================================
		private void lopeta() {
			Platform.exit();
		}
	    
	    private void lisaaTreeni() {
	    	redirLisaaTreeni();
	    }
	    
	    private void redirLisaaTreeni() {
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
	    private void lisaaTreeniHistoria() {
	    	redirLisaaTreeniHistoria();
	    }
	    
	    private void redirLisaaTreeniHistoria() {
	    	try {        
		        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("treenihistoria.fxml"));
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
	    	
	    	Window stage = lopetaButton.getScene().getWindow();
	    	stage.hide();
	    }
		private void asetukset() {
			try {        
		        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("asetukset.fxml"));
		        Scene scene = new Scene(root, 600, 374.4);
		        Stage stage = new Stage();
		        stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		}
}
