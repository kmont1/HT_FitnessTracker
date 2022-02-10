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

/*
 * Controlleri asetukset v�lilehdelle
 */

public class AsetuksetController {

	@FXML
    private Button lopetaButton;

    @FXML
    void handleLopeta(ActionEvent event) {
    	lopeta();
    }

    @FXML
    void redirPaanaytto() {
    	paanaytto();
    	poista();
    	
    }
    @FXML
    void handleKayttajatunnusLaheta() {
    	KayttajatunnusLaheta();
    }
   
		
	

	@FXML
    void handleSalasanaLaheta() {
    	SalasanaLaheta();
    }
   
	

	@FXML
    void HandleEtunimiLaheta() {
    	EtunimiLaheta();
    }


	@FXML
    void handleSukunimiLaheta() {
    	SukunimiLaheta();
    }
    

//=================================================================
	
	/*
	 * sulje ohjelma 
	 */
	private void lopeta() {
    	Platform.exit();
    }
    
	/*
	 * takaisin p��n�yt�lle
	 */
    private void paanaytto() {
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
       
    /*
	 * siirrytty� halutulle n�yt�lle suljetaan edellinen ikkuna
	 */
	private void poista() {
    	
    	Window stage = lopetaButton.getScene().getWindow();
    	stage.hide();
    }
	
	private void KayttajatunnusLaheta() {
		Dialogs.showMessageDialog("ei toimi");
	 }
	private void SalasanaLaheta() {
		Dialogs.showMessageDialog("ei toimi");
		 }
		 
	
	private void EtunimiLaheta() {
		Dialogs.showMessageDialog("ei toimi");
					
		}
				
   private void SukunimiLaheta() {
	   Dialogs.showMessageDialog("ei toimi");
		
	}
}

