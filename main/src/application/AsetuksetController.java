package application;



import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
    private TextField sahkoposti;


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
    void handleSahkopostiLaheta(ActionEvent event) {
    	SahkopostiLaheta();
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
	private String salasanaConst;
	
	
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
	
	
	/**
	 * lähetä käyttäjätunnuksen muutos
	 */
	private void KayttajatunnusLaheta() {
		muuta(etunimi.getText() +" "+ sukunimi.getText(), sahkoposti.getText(), salasanaConst);
	 }
	
	
	/**
	 * lähetä salasanan muutos
	 */
	private void SalasanaLaheta() {
		
		muuta(etunimi.getText() +" "+ sukunimi.getText(), sahkoposti.getText(), salasana.getText());
		 }
	
	
	/**
	 * lähetä etunimen muutos
	 */
	private void EtunimiLaheta() {
		
		muuta(etunimi.getText() +" "+ sukunimi.getText(), sahkoposti.getText(), salasanaConst);
					
		}
	
	
	/**
	 * lähetä sukunimen muutos
	 */
   private void SukunimiLaheta() {
	   muuta(etunimi.getText() +" "+ sukunimi.getText(), sahkoposti.getText(), salasanaConst);
		
	}
   
	/**
	 * lähetä spostin muutos
	 */
   private void SahkopostiLaheta() {
	   muuta(etunimi.getText() +" "+ sukunimi.getText(), sahkoposti.getText(), salasanaConst);
		
	}
   
   
   /**
    * Muuta käyttäjätietoja
    * @param nimi
    * @param sPosti
    * @param salasana
    */
   private void muuta(String nimi, String sPosti, String salasana) {
	   
	   
	   try  
	   {
	 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");       
	 Scanner sc=new Scanner(fis);   
	 int i = 0;
	 int x = 0;
 	int  rivi = 0;
 	int kid = 1;
 	String tarkistus = "";
	   		while(sc.hasNextLine())  
	   		{  
	   		tarkistus = sc.nextLine();
	   		if ((tarkistus.split(" ")[0]).equals(Integer.toString(nykyinenKID))) {
	   			
	   			try {
	   			Writer output;
	   			output = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\KayttajatTemp.txt", true));  
	   			FileInputStream fis1=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");  
	   			String tarkistus1 = "";
	   			Scanner sc1 = new Scanner(fis1);
	   	
	   				while (sc1.hasNextLine()) {
	   					tarkistus1 = sc1.nextLine();
	   					if (i == 0){
	   						if (tarkistus1.split(" ")[0].equals(Integer.toString(nykyinenKID))) {
		   						output.append(nykyinenKID + " "+ nimi+" "+sPosti+ " "+ salasana);
		   					}
		   					else {
		   						output.append(tarkistus1);
		   					}
	   					}
	   					else {
	   					 
	   					if (tarkistus1.split(" ")[0].equals(Integer.toString(nykyinenKID))) {
	   						output.append(" \n"+ nykyinenKID + " "+ nimi+" "+sPosti+ " "+ salasana);
	   					}
	   					else {
	   						output.append(" \n"+ tarkistus1);
	   					}
	   					
	   					
	   				}
	   					i++;}

	   				
	   				sc1.close();
	   				output.close();
	   			}				
	   			catch(IOException e)  
	   		   {  
	   		   
	   		} 	
	   			Writer output3;
	   			output3 = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt"));  
	   			output3.append("");
	   			output3.close();
	   			try {
		   			Writer output1;
		   			output1 = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt", true));  
		   			FileInputStream fis2=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\KayttajatTemp.txt");  
		   			String tarkistus1 = "";
		   			Scanner sc2 = new Scanner(fis2);
		   		 
		   				while (sc2.hasNextLine()) {
		   					tarkistus1 = sc2.nextLine();
		   					if (x==0) {
		   						output1.append(tarkistus1);
		   					}
		   					else {
		   					
		   					 output1.append(" \n"+tarkistus1);
		   					}
		   					x++;
		   				}
		   				
		   				sc2.close();
		   				output1.close();
		   			}				
		   			catch(IOException e)  
		   		   {  
	   			
	   		}
	   			Writer output2;
	   			output2 = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\KayttajatTemp.txt"));  
	   			output2.append("");
	   			output2.close();
	 }  
	   	
	 }
	   		sc.close();
	   		} 
	catch(IOException e)  
	   {  
	   
	} 	
   }
   
   
   /**
    * Vataanota KID sekätee siitä nykyinen
    * @param lähetettyKID
    */
   public void lähetäKID(int lähetettyKID){
   	nykyinenKID =lähetettyKID; 
       System.out.println("asetus toimii  "+nykyinenKID); 
   }
   

   /**
    * init (EI KÄYTÖSSÄ)
    */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
//	  String raaka = etsiKayttaja();
//	  String arr[] = raaka.split(" ", 4); 
//	  
//	  
//	  etunimi.setText(arr[1]);
//	  sukunimi.setText(arr[2]);
//	  kayttajatunnus.setText(arr[0]);
  
   }
   
   
   /**
    * Initin tilalle. 
    * Asettaa tarvittavat tiedot heti ohjelman käynnistyessä
    */
   public void alusta() {
	  String raaka = etsiKayttaja();
	  String arr[] = raaka.split(" ", 5); 
	  
	  
	  etunimi.setText(arr[1]);
	  sukunimi.setText(arr[2]);
	  kayttajatunnus.setText(arr[0]);
	  sahkoposti.setText(arr[3]);
	  this.salasanaConst = arr[4];
   }
   
//private String etsiKayttaja() {
//	System.out.println(nykyinenKID);
//String temp = Integer.toString(nykyinenKID);
//char etsittava = temp.charAt(0);
//String t = "";
//char tc = 'n';
//String tulos = "";
//	   try  
//   	{  
// FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");       
// Scanner sc=new Scanner(fis);   
//  
//   		while(sc.hasNextLine())  
//   		{  
//   		t = sc.nextLine();
//   		if (t.charAt(0)==etsittava) {
//   			tulos = t; 
//   		}
//   		System.out.println(t); 
// }  
//   		sc.close();
//}  
//catch(IOException e)  
//   {  
//  e.printStackTrace();
//  
//}  
//	   return tulos;
//} 	
   
   
   /**
    * Etsi haluttu käyttäjä ja palauta haluttu tieto
    * @return
    */
   private String etsiKayttaja() {
	String t = "";
	String tulos = "";
		   try  
	   	{  
	 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");       
	 Scanner sc=new Scanner(fis);   
	  
	   		while(sc.hasNextLine())  
	   		{  
	   		t = sc.nextLine();
	   		if (Integer.parseInt(t.split(" ")[0])==nykyinenKID) {
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
   


