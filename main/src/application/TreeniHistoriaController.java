package application;



import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import FitnessApp.FitnessApp;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * 
 * @author Kmontasi
 *10.02.2022
 */

public class TreeniHistoriaController extends FitnessApp implements Initializable {
	
    @FXML
    private ListView<String> treeniLista;
    
    @FXML
    private TextField eka;
	
	@FXML
    private Button lopetaButton;

    @FXML
    private void handleLopeta(ActionEvent event) {
    	lopeta();
    }
    @FXML
    private void handleAvaaTreeni( ) {
    	avaaTreeni();
    }
    


    @FXML
    void redirPaanaytto() {
    	paanaytto();
    	poista();
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
    
//    Vastaanottaa KIDIN
    public void lähetäKID(int lähetettyKID){
    	nykyinenKID =lähetettyKID; 
        System.out.println("treenihistoria  "+nykyinenKID);
        
    }
    //poista sivu
	private void poista() {
    	
    	Window stage = lopetaButton.getScene().getWindow();
    	stage.hide();
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
	}
	
/*
 * töytä alustustiedot
 */
	public void alusta() {
//		String tulos = etsiKayttaja();
//		eka.setText(tulos);
		etsiKayttaja();
		
	}
	
	private String etsiKayttaja() {
		String temp = Integer.toString(nykyinenKID);
		char etsittava = temp.charAt(0);
		String t = "";
		char tc = 'n';
		String tulos = "";
			   try  
		   	{  
		 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treenikerrat.txt");       
		 Scanner sc=new Scanner(fis);   
		  
		   		while(sc.hasNextLine())  
		   		{  
		   		t = sc.nextLine();
		   		if (Integer.parseInt(t.split(" ")[1]) == nykyinenKID) {
		   			tulos = t; 
		   			treeniLista.getItems().add(tulos);
		   		}
		   		
		 }  
		   		sc.close();
		}  
		catch(IOException e)  
		   {  
		  e.printStackTrace();  
		}  
			   return tulos;
		} 	
		   /*
		    * käsittele tietyn treenin klikkausta, avaa uusi ikkuna sekä listaa kaikki liikkeet
		    */
	private void avaaTreeni() {
		treeniLista.getSelectionModel().getSelectedItem();
		System.out.print(treeniLista.getSelectionModel().getSelectedItem());
	}

}


