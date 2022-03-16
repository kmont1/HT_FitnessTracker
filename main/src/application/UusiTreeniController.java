package application;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    	uusi.tulosta(System.out);

    	

	}
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

public void l‰het‰Tarkistaja(int i) {
	TreeniKerta uusiT = new TreeniKerta();
	 uusiT.luo();
	uusiT.VastaaMalli();
	uusiT.tulosta(System.out);
	 nykyinenTKID = uusiT.getTKID();
	 System.out.println(nykyinenTKID);
} 	

public void l‰het‰TKID(int i) {
	 nykyinenTKID = i;
	 System.out.println(nykyinenTKID);
} 	
}

