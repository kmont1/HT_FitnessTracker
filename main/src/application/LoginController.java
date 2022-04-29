package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;

import FitnessApp.FitnessApp;
import FitnessApp.Kayttaja;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * 
 * @author Kmontasi
 *10.02.2022
 */

/*
 * Controlleri kirjautuminen välilehdelle
 */
public class LoginController {
    @FXML
    private Text ilmoitus;
	
	@FXML
	private PasswordField salasanaFields;

	@FXML
	private TextField spostiField;
	
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
    private FitnessApp fitnessApp;
    private int nykyinenKID;
    
    
    /**
     * aseta haluttu fitnessappi
     * ei käytössä
     * @param fitnessApp
     */
    public void setFitnessApp(FitnessApp fitnessApp) {
    	this.fitnessApp = fitnessApp;
    }
    
    
    /**
     * tarkista sulkemiselle
     * @return
     */
    public boolean voikoSulkea() {
        tallenna();
        return true;
    }

    
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
//    	try {        
//	        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("paanaytto.fxml"));
//	        Scene scene = new Scene(root, 600, 374.4);
//	        Stage stage = new Stage();
//	        stage.setTitle("New Window");
//	        stage.setScene(scene);
//	        stage.show();
//	    } catch (IOException e) {
//	    	e.printStackTrace();
//	    }
    	
try {        
    		
    		FXMLLoader loader = new 		  FXMLLoader(getClass().getResource("paanaytto.fxml"));
            Parent root = loader.load();    		
	        PaanayttoController paanaytto = loader.getController();
	        paanaytto.lähetäKID(nykyinenKID);
	        
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("help plz");
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
     	int i = 0;
    	int  rivi = 0;
    	int kid = 1;
    	String tarkistus = "";
    	String sposti = spostiField.getText();
    	String salasana = salasanaFields.getText();
    		
    		   try  
    		   {
   		 FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");       
   		 Scanner sc=new Scanner(fis);   
   		  
   		   		while(sc.hasNextLine())  
   		   		{  
   		   		tarkistus = sc.nextLine();
   		   		if ((tarkistus.split(" ")[3]).equals(sposti)) {
   		   			i += 1;
   		   		}
   		   		if ((tarkistus.split(" ")[4]).equals(salasana)) {
   		   			i += 1;
   		   			if (i == 2) {
   		   				
   		   				
   		   				
   		   				String nykyinenKIDs= tarkistus.split(" ")[0];
   		   				this.nykyinenKID = Integer.parseInt(nykyinenKIDs);
   		   			}
   		   		}
   		   		kid++;
   		   		
   		 }  
   		   		sc.close();
   		 }  
   		catch(IOException e)  
   		   {  
    		   
   		} 	
    		 

    	
    		   if(i < 2)
    	{
    			   ilmoitus.setText("väärät tunnukset");
    			   kirjaudu();
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
	
	private void tallenna() {
	        Dialogs.showMessageDialog("Tallennetetaan! Mutta ei toimi vielä");
	    }

}

