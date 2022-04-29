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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
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
 * Controlleri asetukset v‰lilehdelle
 */

public class TreeniNayttoController  implements Initializable{
	
		@FXML
	    private ListView<String> liikeLista;

	    @FXML
	    private Button lopetaButton;

	    @FXML
	    void handleLopeta(ActionEvent event) {

	    }

	    @FXML
	    void redirPaanaytto(ActionEvent event) {

	    }

	


//=================================================================
	private int nykyinenKID;
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * kutsu etsi treeni tidin avulla
	 * @param nykyinenKID
	 * @param TID
	 */
	public void l‰het‰Tiedot(int nykyinenKID, int TID) {
		etsiTreeni( TID);
	}

	/**
	 * etsi treeni tidin avulla
	 * @param TID
	 */
	private void etsiTreeni(int TID) {
		String t = "";
		   try  
		   	{  
		 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treeni.txt");       
		 Scanner sc=new Scanner(fis);   
		  
		   		while(sc.hasNextLine())  
		   		{  
		   		t = sc.nextLine();
		   		if (Integer.parseInt(t.split(" ")[5]) == TID) {
		   			lis‰‰Treeni(t);
		   		}
		   		
		 }  
		   		sc.close();
		}  
		catch(IOException e)  
		   {  
		  e.printStackTrace();  
		}  
			   
		} 	
		

	/**
	 * lis‰‰ treenit n‰ytˆlle sek‰ formattaa teksti
	 * @param treeni
	 */
	private void lis‰‰Treeni(String treeni) {
		System.out.print(treeni);
		String treeniNimi = etsiTreeniNimi(treeni.split(" ")[1]);
		String toistoja = treeni.split(" ")[4];
		String paino	= treeni.split(" ")[3];
		String sarjat 	= treeni.split(" ")[2];
		liikeLista.getItems().add(treeniNimi +", "+ paino + " KG, " + toistoja + " toistoa, "+ sarjat + " sarjaaa " );
	}

	/**
	 * etsu treenin nimi erillisest‰ databasista
	 * @param lid
	 * @return
	 */
	private String etsiTreeniNimi(String lid) {
		String nimi ="";
		int Lid = Integer.parseInt(lid);
		String t = "";
		try  
	   	{  
	 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Liike.txt");       
	 Scanner sc=new Scanner(fis);   
	  
	   		while(sc.hasNextLine())  
	   		{  
	   		t = sc.nextLine();
	   		if (Integer.parseInt(t.split(" ")[0]) == Lid) {
	   			nimi = t.split(" ")[2];
	   		}
	   		
	 }  
	   		sc.close();
	}  
	catch(IOException e)  
	   {  
	  e.printStackTrace();  
	}  
		   	
		return nimi;
		
	}
	
	
	public void alusta() {
		// TODO Auto-generated method stub
		
	}
}