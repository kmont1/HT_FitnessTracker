package application;



import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import FitnessApp.FitnessApp;
import FitnessApp.Kayttaja;
import FitnessApp.Kayttajat;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
 *10.02.2022
 */

/*
 * Controlleri asetukset välilehdelle
 */

public class AsetuksetController  implements Initializable{

	@FXML
    private TextField etunimi;

    @FXML
    private TextField kayttajatunnus;
    
    @FXML
    private TextField salasana;

    @FXML
    private TextField sukunimi;

	
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
	private int nykyinenKID;
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
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("paanaytto.fxml"));
            Parent root = loader.load();    		
	        PaanayttoController seuraava = loader.getController();
	        seuraava.lähetäKID(nykyinenKID);
	        
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("help plz");
	        stage.show();
    		
//	        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("paanaytto.fxml"));
//	        Scene scene = new Scene(root, 600, 374.4);
//	        Stage stage = new Stage();
//	        stage.setTitle("New Window");
//	        stage.setScene(scene);
//	        stage.show();
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
//ei toiminnassa vielä
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
   
   public void lähetäKID(int lähetettyKID){
   	nykyinenKID =lähetettyKID; 
       System.out.println("asetus toimii  "+nykyinenKID);
       
     
       
   }
   
   @Override
   public void initialize(URL url, ResourceBundle rb) {
	  String raaka = etsiKayttaja();
	  String arr[] = raaka.split(" ", 4); 
	  
	  
	  etunimi.setText(arr[1]);
	  sukunimi.setText(arr[2]);
	  kayttajatunnus.setText(arr[0]);
   }

   
private String etsiKayttaja() {
String temp = Integer.toString(nykyinenKID);
char etsittava = temp.charAt(0);
String t = "";
char tc = 'n';
String tulos = "";
	   try  
   	{  
 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");       
 Scanner sc=new Scanner(fis);   
  
   		while(sc.hasNextLine())  
   		{  
   		t = sc.nextLine();
   		if (t.charAt(0)==etsittava) {
   			tulos = t; 
   		}
   		System.out.println(t); 
 }  
   		sc.close();
}  
catch(IOException e)  
   {  
  e.printStackTrace();  
}  
	   return tulos;
} 	
   

   }
   


