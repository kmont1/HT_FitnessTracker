package application;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import FitnessApp.FitnessApp;
import FitnessApp.Kayttaja;
import FitnessApp.Liike;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    	ListView<String> liikeLista;
		
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
		 void handleClick(MouseEvent event) {
			 clickLis��();
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
	    
		/**
		 * sulje ohjelma
		 */
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
		        seuraava.l�het�KID(nykyinenKID);
		        seuraava.l�het�LID(nykyinenLID, nykyinenLiike);
		        seuraava.l�het�TKID(nykyinenTKID);
		        
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
		 * siirrytty� halutulle n�yt�lle suljetaan edellinen ikkuna
		 */
		private void poista() {
	    	
	    	Window stage = lopetaButton.getScene().getWindow();
	    	stage.hide();
	    }
		
		
		/**
		 *  vastaanota kid
		 * @param l�hetettyKID
		 */
		 public void l�het�KID(int l�hetettyKID){
			 	liikeN�ytt�();
		    	nykyinenKID =l�hetettyKID; 
		        System.out.println("liiketoimii  "+nykyinenKID);
		        
		    }
		 
		 

		 /**	
		  * ota sis��npistetty arvo lis�� se liikkeeksi ja l�het� eteenp�in
		  */
	    private void jatka() {
	    	lisaa();
	    	uusiTreeni();
	    	poista();
	    	
			
		}
	    
/**
 * lisaa  liikkeeseen
 */
	    private void lisaa() {
	    	String input = liikeInput.getText();
	    	if (input.length() > 0) {
	    	    
	    	    	
	    	    	int tarkistajaInt = 1;
	    	    	this.fitnessApp = fitnessApp;
	    	    	Liike uusi = new Liike();
	    	    	uusi.luoLiike(this.nykyinenKID);
	    	    	nykyinenLID = uusi.getLid();
	    	    	nykyinenLiike= input;
	    	    	uusi.vastaaLiikeNimi(input);
	    	    	try {
						uusi.tallenna();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	    	uusi.tulosta(System.out);
	    	    	}
	
}
/**
 * vastaanota tkid
 * @param l�hetettyTKID
 */
		public void l�het�TKID(int l�hetettyTKID) {
			nykyinenTKID = l�hetettyTKID;
			
		}
		
/*
 * asetetaan listalle kaikki k�ytt�j�n edelliset tallennetut liikkeet
 */
		public void liikeN�ytt�() {
			int k = this.nykyinenKID;
			String nykyinen = "";
			String nykyinenParse = "";
			int tulos;
		    try  
		    	{  
		  FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Liike.txt");       
		  Scanner sc=new Scanner(fis);   
		   
			while(sc.hasNextLine())  
			{  
				nykyinen = sc.nextLine();
				nykyinenParse = nykyinen.substring(5,7);
				tulos =  Integer.parseInt(nykyinenParse);
				if(tulos == k || tulos == 0) {
					nykyinenParse = nykyinen.substring(8);
					liikeLista.getItems().add(nykyinenParse);
				}
				
				
/**
 * 			System.out.println(sc.nextLine().charAt(0));   
 */		
	}  
			sc.close();
	}  
	catch(IOException e)  
	{  
	e.printStackTrace();  
	}  
			
		}
	

		/**
		 * aseta valittu teksti tekstikent�lle
		 */
		private void clickLis��() {
			liikeInput.setText(liikeLista.getSelectionModel().getSelectedItem());
		}
}
