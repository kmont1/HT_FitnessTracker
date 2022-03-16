package application;



import java.io.IOException;

import FitnessApp.FitnessApp;
import FitnessApp.Kayttaja;
import FitnessApp.Liike;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
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
	    private TextField liikeInput;


		@FXML
	    void handleLopeta(ActionEvent event) {
	    	lopeta();
	    }

	    @FXML
	    void redirTakaisin(ActionEvent event) {
	    	uusiTreeni();
	    	poista();
	    }
	    //================================================
	    private FitnessApp fitnessApp = new FitnessApp();
	    private int nykyinenKID;
	    private int nykyinenTKID;
	    private int nykyinenLID;
	    private String nykyinenLiike;
	    
	    private void lopeta() {
	    	Platform.exit();
	    }
	    /*
		 * takaisin uuteen treeniin
		 */
	    private void uusiTreeni() {
	    	try {        
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("UusiTreeni.fxml"));
	            Parent root = loader.load();    		
		        UusiTreeniController seuraava = loader.getController();
		        seuraava.l‰het‰KID(nykyinenKID);
		        seuraava.l‰het‰LID(nykyinenLID, nykyinenLiike);
		        seuraava.l‰het‰TKID(nykyinenTKID);
		        
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root));
		        stage.setTitle("help plz");
		        stage.show();
	    		
//		        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("UusiTreeni.fxml"));
//		        Scene scene = new Scene(root, 600, 374.4);
//		        Stage stage = new Stage();
//		        stage.setTitle("New Window");
//		        stage.setScene(scene);
//		        stage.show();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
			
		}
	    /*
		 * siirrytty‰ halutulle n‰ytˆlle suljetaan edellinen ikkuna
		 */
		private void poista() {
	    	
	    	Window stage = lopetaButton.getScene().getWindow();
	    	stage.hide();
	    }
		// vastaanota kid
		 public void l‰het‰KID(int l‰hetettyKID){
		    	nykyinenKID =l‰hetettyKID; 
		        System.out.println("vittu kyll‰ se toimii, mene nyt nukkumaan saatanan autisti "+nykyinenKID);
		        
		    }
//		 ota sis‰‰npistetty arvo lis‰‰ se liikkeeksi ja l‰het‰ eteenp‰in
	    private void jatka() {
	    	lisaa();
	    	uusiTreeni();
	    	poista();
	    	
			
		}
	    private void lisaa() {
	    	String input = liikeInput.getText();
	    	if (input.length() > 3) {
	    	    
	    	    	
	    	    	int tarkistajaInt = 1;
	    	    	this.fitnessApp = fitnessApp;
	    	    	Liike uusi = new Liike();
	    	    	uusi.luoLiike();
	    	    	nykyinenLID = uusi.getLid();
	    	    	nykyinenLiike= input;
	    	    	uusi.vastaaLiikeNimi(input);
	    	    	uusi.tulosta(System.out);
	    	    	}
	
}

		public void l‰het‰TKID(int l‰hetettyTKID) {
			nykyinenTKID = l‰hetettyTKID;
			
		}
	    
	}

