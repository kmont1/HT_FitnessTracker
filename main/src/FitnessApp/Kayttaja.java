package FitnessApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Kayttaja {

	public int 			kid;
	public String 		nimi			= "";
	public String 		sPosti 			= "";
	public String 		salasana 		= "";
	
	
	private static int 	seuraavaNro 	= 1;
	
	
	public Kayttaja() {
		
	}
//	Luo valitun aku ankan sekä antaa tarvittavat arvot
	 public void vastaaAkuAnkka() {

	        Random rand =new Random();
	        int randInt = rand.nextInt(100);
//	        nimi = application.RekisteroidyController.get;
//	        sPosti 	= randInt+"aku.a@gmail.com" ;
//	        salasana = "sdkladka";
	        
	        nimi = "Ankka Aku ";
	        sPosti 	= randInt+"aku.a@gmail.com" ;
	        salasana = "sdkladka";
	        
	    }

//		Tulosta vastaanotettu käyttäjä

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", kid) + " "+ nimi+" "+sPosti);
	}
	
//	Tulosta vastaanotettu käyttäjä ei käytössä vielä
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiteröi käyttäjä
	 /**
     * 		Reksiteröi käyttäjä
     * @return KID
     * @example
     * <pre name="test">
     *   Kayttaja testi = new Kayttaja();
     *   testi.rekisteroi();
     *   testi.vastaaAkuAnkka();
     *   		try {
			testi.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     *   Kayttaja testi1 = new Kayttaja();
     *   testi1.rekisteroi();
     *   testi.vastaaAkuAnkka();
     *   		try {
			testi1.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     *   int n1 = testi.getKid();
     *   int n2 = testi1.getKid();
     *   n1 === n2-1;
     * </pre>
     */	
	public int rekisteroi() {
		try {
			this.kid = haeSeuraavaNro()+1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.kid;
	}
	

//	etsitään vapaa kid jota ei ole vielä laitetu
private int haeSeuraavaNro() throws FileNotFoundException {
    int i = 0;
    int tulos = 0;
    char t = 'a';
    char t1 = 'a';
    String yhd = "";
    String nykyinen ="";
    
    try  
    	{  
  FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt");       
  Scanner sc=new Scanner(fis);   
   
    		while(sc.hasNextLine())  
    		{  
    			nykyinen = sc.nextLine();
    		if (nykyinen.charAt(1) == ' ') {
    			t = nykyinen.charAt(0);
        		System.out.println(t); 
    		}
    		else {
    			t = nykyinen.charAt(0);
    			t1 = nykyinen.charAt(1);
    		}
    			
    			
//    		System.out.println(sc.nextLine().charAt(0));   
    		
  }  
    		sc.close();
}  
catch(IOException e)  
    {  
   e.printStackTrace();  
}  
    if (t1 != 'a') {
    	yhd = Character.toString(t) + Character.toString(t1);
    	tulos = Integer.parseInt(yhd);
    }
    else {
        tulos = Character.getNumericValue(t);  
        System.out.println("saat tämän "+tulos); 
    }

	return tulos;
}

//	Hae KID
	 public int getKid() {
	        return kid;
	    }
//Pääohjelma joka rekisteröi, vastaa sekä tulostaa käyttäjät

	public static void main(String[] args) {
		Kayttaja aku = new Kayttaja();
		Kayttaja aku2 = new Kayttaja();
		
		aku.rekisteroi();
		aku2.rekisteroi();
		
		aku.vastaaAkuAnkka();
		aku2.vastaaAkuAnkka();
		try {
			aku.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		aku.tulosta(System.out);
		aku2.tulosta(System.out);
		
	}
	
	public void tallenna() throws IOException {
      Writer output;
      output = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Kayttajat.txt", true));  
      output.append(" \n"+ kid + " "+ nimi+" "+sPosti+ " "+ salasana);
      output.close();
		
	}

	
}
