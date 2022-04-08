package application;



import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import FitnessApp.Kayttaja;
import FitnessApp.Treeni;
import FitnessApp.TreeniKerta;
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

public class UusiTreeniController implements Initializable {

    @FXML
     ListView<String> sarjaList;
    
    @FXML
     ListView<String> toistoList;
    
    @FXML
     ListView<String> painoList;
    
    @FXML
     ListView<String> nimiList;
    
	@FXML
    private TextField liikkeenNimi;
	
	@FXML
    private TextField painoInput;

    @FXML
    private TextField sarjaInput;

    @FXML
    private TextField toistoInput;

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
    	private int nykyinenKID;
    	private int nykyinenLID;
    	private int nykyinenTKID;
    	private int initTarkistaja = 0;
    	private String nykyinenLiike = "toimii";
    	
		private Object fitnessApp;
	/*
	 * sulje ohjelma 
	 */
     
	private void lopeta() {
		Platform.exit();
	}


	/*
	 * takaisin p‰‰n‰ytˆlle
	 */
	private void paanaytto() {
    	try {       
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("paanaytto.fxml"));
            Parent root = loader.load();    		
	        PaanayttoController seuraava = loader.getController();
	        seuraava.l‰het‰KID(nykyinenKID);
	        
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
	 * siirrytty‰ halutulle n‰ytˆlle suljetaan edellinen ikkuna
	 */
	private void poista() {
    	
    	Window stage = lopetaButton.getScene().getWindow();
    	stage.hide();
    }
	private void tallenna() {
		TreeniKerta uusi = new TreeniKerta();
		uusi.luo();
		uusi.VastaaMalli();
		uusi.tkid = nykyinenTKID;
		uusi.kid = nykyinenKID;
		try {
			uusi.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	paanaytto();
    	poista();
	}
//	TALLENNA uusi treeni sek‰ lis‰‰ sille treenikertaID
	private void tallennaLiike() {
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
    	listaan();
    	uusi.tulosta(System.out);
    	

    	

	}
	//Vie uusi liike v‰lilehdelle 
	private void UusiLiike() {
		try {        
    		FXMLLoader loader = new 		  FXMLLoader(getClass().getResource("LisaaLiike.fxml"));
            Parent root = loader.load();    		
	        LisaaLiikeController seuraava = loader.getController();
	        seuraava.l‰het‰KID(nykyinenKID);
	        seuraava.l‰het‰TKID(nykyinenTKID);
	        
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("help plz");
	        stage.show();
			
//	        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("lisaaliike.fxml"));
//	        Scene scene = new Scene(root, 600, 374.4);
//	        Stage stage = new Stage();
//	        stage.setTitle("New Window");
//	        stage.setScene(scene);
//	        stage.show();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		poista();
	}
//    Vastaanottaa KIDIN
    public void l‰het‰KID(int l‰hetettyKID){
    	nykyinenKID =l‰hetettyKID; 
        System.out.println("uusiTreeni toimii  "+nykyinenKID);
      	
    	
    	
        
    
    }
//  Vastaanottaa LIDIN sek‰ lis‰‰ tekstin liikkeenNimi kohtaan 

public void l‰het‰LID(int l‰hetettyLID, String L‰hetettyLiike) {
	nykyinenLID =l‰hetettyLID; 
    System.out.println("uusiTreenin LID LƒHETYS toimii  "+nykyinenLID);
    nykyinenLiike = L‰hetettyLiike;
    initialize(null, null);
	
}



@Override
public void initialize(URL url, ResourceBundle rb) {
	 liikkeenNimi.setText(nykyinenLiike);
	 int i = 0;
	

} 	
//luo tkiden sek‰ muut tarpeelliset arvot
public void l‰het‰Tarkistaja(int i) {
	TreeniKerta uusiT = new TreeniKerta();
	 uusiT.luo();
	uusiT.VastaaMalli();
	uusiT.tulosta(System.out);
	 nykyinenTKID = uusiT.getTKID();
	 System.out.println(nykyinenTKID);
} 	
//aseta oikea tkid
public void l‰het‰TKID(int i) {
	 nykyinenTKID = i;
	 System.out.println(nykyinenTKID);
	 
} 	

/*
 * lis‰t‰‰n tallentamisen j‰lkeen liikesarjat alas
 */
public void listaan() {
	
	int tk= this.nykyinenTKID;
	String nykyinen = "";
	String nykyinen1 = "";
	String nykyinenParse = "";
	int liikeId;
	int tulos;
	 try  
 	{  
FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treeni.txt");       
Scanner sc=new Scanner(fis);   

	while(sc.hasNextLine())  
	{  
		nykyinen = sc.nextLine();
		if(Integer.parseInt(nykyinen.split(" ")[5]) == tk ) {
			liikeId = Integer.parseInt(nykyinen.split(" ")[1]);
			//paino
			nykyinenParse = nykyinen.split(" ")[3];
			painoList.getItems().add(nykyinenParse);
			//sarja
			nykyinenParse = nykyinen.split(" ")[2];
			sarjaList.getItems().add(nykyinenParse);
			//toisto
			nykyinenParse = nykyinen.split(" ")[4];
			toistoList.getItems().add(nykyinenParse);
			//nimi
			
			 try  
			 	{  
			FileInputStream fis1=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Liike.txt");       
			Scanner sc1=new Scanner(fis1);   

				while(sc1.hasNextLine())  
				{  
					nykyinen1 = sc1.nextLine();
					if(Integer.parseInt(nykyinen1.split(" ")[0]) == liikeId) {
						nykyinenParse = nykyinen1.split(" ")[2];
						nimiList.getItems().add(nykyinenParse);
					}
					}
					
					
//				System.out.println(sc.nextLine().charAt(0));   
				
			  
				
			}  
			catch(IOException e)  
			{  
			e.printStackTrace();  
			}  
			} 
			
		
		
		
//	System.out.println(sc.nextLine().charAt(0));   
	
}  
	sc.close();
}  
catch(IOException e)  
{  
e.printStackTrace();  
}  
} 

}

