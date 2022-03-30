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
 *10.02.2022
 */

public class UusiTreeniController {

    @FXML
    private Button lopetaButton;

    @FXML
    void handleLopeta(ActionEvent event) {
    	lopeta();
    }

    @FXML
    void handleTallenna(ActionEvent event) {
    	tallenna();
    }

    @FXML
    void handleTallennaLiike(ActionEvent event) {
    	tallennaLiike();
    }

    @FXML
    void handleUusiLiike(ActionEvent event) {
    	UusiLiike();
    }

    @FXML
    void redirPaanaytto(ActionEvent event) {
    	paanaytto();
    	poista();
    }
    //====================================================================
    
	/*
	 * sulje ohjelma 
	 */
	private void lopeta() {
		Platform.exit();
	}
	
	/*
	 * takaisin päänäytölle
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
	 * siirryttyä halutulle näytölle suljetaan edellinen ikkuna
	 */
	private void poista() {
    	
    	Window stage = lopetaButton.getScene().getWindow();
    	stage.hide();
    }
	private void tallenna() {
		Dialogs.showMessageDialog("ei vielä prkl");
	}
	private void tallennaLiike() {
<<<<<<< Updated upstream
		Dialogs.showMessageDialog("ei vielä prkl");
=======
    	int tarkistajaInt = 1;
    	this.fitnessApp = fitnessApp;
    	Treeni uusi = new Treeni();
    	uusi.luoTreeni();
    	uusi.vastaaAkunTreeni();
    	uusi.lid = nykyinenLID;
    	uusi.sarjoja = sarjaInput.getText();
    	uusi.painot = painoInput.getText();
    	uusi.toistoja = toistoInput.getText();
    	uusi.tkid = nykyinenTKID;
    	try {
			uusi.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	uusi.tulosta(System.out);
    	

    	

>>>>>>> Stashed changes
	}
	private void UusiLiike() {
		try {        
	        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("lisaaliike.fxml"));
	        Scene scene = new Scene(root, 600, 374.4);
	        Stage stage = new Stage();
	        stage.setTitle("New Window");
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		poista();
	}
	
}

