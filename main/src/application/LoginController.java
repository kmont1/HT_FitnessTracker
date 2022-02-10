package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/*
 * Controlleri kirjautuminen välilehdelle
 */
public class LoginController {
	
	@FXML
	private Button kirjauduButton;
	
    @FXML
    void handleKirjaudu() {
    	kirjaudu();
    	poista(); 
    }
    

    @FXML
    void redirRekisteroidy() {
    	rekisteroidy();
    	poista();
    }
    

    @FXML
    void redirAsetukset(ActionEvent event) {
    	
    }
    
    @FXML
    void handleLopeta(ActionEvent event) {
    	lopeta();
    }
    
    //===============================================================
	/*
	 * sulje ohjelma 
	 */
	private void lopeta() {
		Platform.exit();
	}
	/*
	 *avaa päänäyttö
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
	 * siirryttyä paanäytölle suljetaan edellinen ikkuna
	 */


	private void poista() {
    	
    	Window stage = kirjauduButton.getScene().getWindow();
    	stage.hide();
    }

    
	/*
	 *kirjaudu napin toiminta
	 */
    private void kirjaudu() {
    	int i = 1;
    	if(i == 0)
    	{
    		Dialogs.showMessageDialog("Salasana on väärin");
    	}
    	else
    	{
    		paanaytto();
    	}
    	
    	
    }   
	
	/*
	 *siirry rekisteröitymään
	 */
	private void rekisteroidy() {
    	try {        
	        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("rekisteroidy.fxml"));
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

