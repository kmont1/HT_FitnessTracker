package application;




import java.io.IOException;
import java.util.regex.Pattern;

import FitnessApp.FitnessApp;
import FitnessApp.Kayttaja;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * 
 * @author Kmontasi
 *10.02.2022
 */

/*
 * Controlleri rekistöityminen välilehdelle
 */

public class RekisteroidyController {
	@FXML
    private TextField etunimiField;
	@FXML
    private TextField sukunimiField;
	@FXML
	private TextField sPostiField;
	@FXML
    private PasswordField salasanaField;
	
    @FXML
    private Menu mainLopeta;
    @FXML
    private Button rekisteroidyButton;

    @FXML
    void handleLopeta(ActionEvent event) {
    	lopeta();
    }

    @FXML
    void handlePaanaytto(ActionEvent event) {

    	rekisteroidy();

    	poista();
    }

//=================================================================
    private FitnessApp fitnessApp = new FitnessApp();
    private int nykyinenKID ;
    

    
    public void setFitnessApp(FitnessApp fitnessApp) {
    	this.fitnessApp = fitnessApp;
    }
    
	/*
	 * sulje ohjelma 
	 */
	private void lopeta() {
		Platform.exit();
	}
	
	
    /*
     * siirrä päänäytölle
     */
    private void redirMainMenu() {
    	try {        
    		
    		FXMLLoader loader = new 		  FXMLLoader(getClass().getResource("paanaytto.fxml"));
            Parent root = loader.load();    		
	        PaanayttoController paanaytto = loader.getController();
	        paanaytto.lähetäKID(nykyinenKID);
	        
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
    	
    	Window stage = rekisteroidyButton.getScene().getWindow();
    	stage.hide();
    }

	
    /*
     * validaattori rekisteröitymiselle
     */
    
    private int rekisteroidy() {
    	int i = 0;
    	i = uusiKayttaja();
    	if (i == 1)  
        	{
        		sPostiField.setStyle("-fx-text-fill: red;");
//       		Dialogs.showMessageDialog("Sähköposti on väärässä muodossa");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Huomautus");
                alert.setHeaderText(null);
                alert.setContentText("Huomasithan että joulu meni jo!");
                alert.showAndWait();
        		i =uusiKayttaja();
        		
        	}
    	if (i == 2)
        	{
    			
    			
        		redirMainMenu();
        		
        	}
    	return i -1;	
//    	//i = uusiKayttaja();
//    	
//    	
//	
//    	//for (int k = 0; k < 2;) {
//    		k = uusiKayttaja();
//    		
//    		if ( k== 100)
//        	{
//        		Dialogs.showMessageDialog("Virhe kirjautumisesssa");
//        		i =uusiKayttaja();
//        	}
//        	if (k == 1)
//        	{
//        		sPostiField.setStyle("-fx-text-fill: red;");
////        		Dialogs.showMessageDialog("Sähköposti on väärässä muodossa");
//        		i =uusiKayttaja();
//        	}
//        	
//        	i = k;
//    	//}
//    	if (i == 2)
//    	{
//    		redirMainMenu();
//    	}
    }
    
//    haetaan käyttäjä
    
    protected void hae() {
 
		for (int i = 0; i < fitnessApp.getKayttajia(); i++) {
            Kayttaja kayttaja = fitnessApp.annaKayttaja(i);
            System.out.println("kayttaja paikassa: " + i);
            kayttaja.tulosta(System.out);
        }
       
    }
//luo uusi käyttäjä hankkimalla se textfieldistä, sekä lähetä validaaattorille
    
    private int uusiKayttaja() {
    	
    	int tarkistajaInt = 1;
    	this.fitnessApp = fitnessApp;
    	Kayttaja uusi = new Kayttaja();
    	uusi.rekisteroi();
    	uusi.vastaaAkuAnkka();
    	nykyinenKID = uusi.getKid();
    	uusi.nimi = etunimiField.getText() +" "+ sukunimiField.getText();
    	uusi.sPosti = sPostiField.getText();
    	try {
			uusi.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int nykyinenKID = uusi.kid;
    	
    	tarkistajaInt = tarkistaja(sPostiField.getText(), etunimiField.getText(), sukunimiField.getText(), uusi);  	
    	sPostiField.clear();
    	
    	return tarkistajaInt;
    }
    
//    tarkistaja joka uudellenohjaa spostin fieldin uusille aliohjelmille. muut tarkistukset suoritetaan saman aliohjelmman sisällä
    private int tarkistaja(String sposti, String etu, String suku, Kayttaja uusi) {
    	int i = 1;
    	int sp = 1;
    	int e = 1;
    	int s = 1;
    	if(sPostiTarkistaja(sposti)== true) {

    		sp = 2;
    	}
    	if(etu.length()> 1) {

    		e = 2;
    	}
    	if(suku.length()> 1) {

    		s = 2;
    	}
    	if(s ==2 && e == 2 && sp == 2)
    	{
    		fitnessApp.lisaa(uusi);	
    		hae();
    		i= 2;
    	}
    	return i;
    }
    // palauta nykyinenkid
	 public int getNykyinenKID() {
	        return nykyinenKID;
	    }
	 
//   tarkistaja spostille
    public static boolean sPostiTarkistaja(String sposti)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (sposti == null)
            return false;
        return pat.matcher(sposti).matches();
    }
}

