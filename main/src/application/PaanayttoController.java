package application;

import java.io.IOException;

import FitnessApp.Kayttaja;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

/*
 * Controlleri p‰‰n‰yttˆ v‰lilehdelle
 */

public class PaanayttoController   {
		
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
	    	redirLisaaTreeni();
	    	poista();
	    }

	    @FXML
	    void redirTreeniHistoria(ActionEvent event) {
	    	redirLisaaTreeniHistoria();
	    	poista();
	    }
//=============================================================
	    private int nykyinenKID;
		/*
		 * sulje ohjelma 
		 */
		private void lopeta() {
			Platform.exit();
		}
		
		/*
		 * siirry asetukset v‰lilehdelle
		 */
		private void asetukset() {
			try {  
				FXMLLoader loader = new  FXMLLoader(getClass().getResource("asetukset.fxml"));
	            Parent root = loader.load();    		
		        AsetuksetController seuraava = loader.getController();
		        seuraava.l‰het‰KID(nykyinenKID);
		        
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root));
		        stage.setTitle("help plz");
		        stage.show();
				
//		        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("asetukset.fxml"));
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
		 * siirr‰ lisaa treeni v‰lilehdelle
		 */

	    
	    private void redirLisaaTreeni() {
	    	try {        
	    		FXMLLoader loader = new 		  FXMLLoader(getClass().getResource("UusiTreeni.fxml"));
	            Parent root = loader.load();    		
		        UusiTreeniController seuraava = loader.getController();
		        seuraava.l‰het‰KID(nykyinenKID);
		        seuraava.l‰het‰Tarkistaja(1);
		        
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root));
		        stage.setTitle("help plz");
		        stage.show();
	    		
//	    		RekisteroidyController data = new RekisteroidyController();
//	    		data.getNykyinenKID();
////	    		Kayttaja uusi = new Kayttaja();
//	    		
//	    		System.out.print("moi   "+ data.getNykyinenKID());
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
		 * siirr‰ treenihistoria v‰lilehdelle
		 */
	    
	    private void redirLisaaTreeniHistoria() {
	    	try {     
	    		FXMLLoader loader = new 		  FXMLLoader(getClass().getResource("treenihistoria.fxml"));
	            Parent root = loader.load();    		
		        TreeniHistoriaController seuraava = loader.getController();
		        seuraava.l‰het‰KID(nykyinenKID);
		        
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root));
		        stage.setTitle("help plz");
		        stage.show();
	    		

//		        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("treenihistoria.fxml"));
//		        Scene scene = new Scene(root, 600, 374.4);
//		        Stage stage = new Stage();
//		        stage.setTitle("New Window");
//		        stage.setScene(scene);
//		        stage.show();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
			
		}
	    
//	    Vastaanottaa KIDIN
	    public void l‰het‰KID(int l‰hetettyKID){
	    	nykyinenKID =l‰hetettyKID; 
	        System.out.println("paanaytto controller toimiii  "+nykyinenKID);
	        
	    }
	    
		/*
		 * siirrytty‰ halutulle sivustolle suljetaan edellinen ikkuna
		 */
		private void poista() {
	    	
	    	Window stage = lopetaButton.getScene().getWindow();
	    	stage.hide();
	    }
		
}
