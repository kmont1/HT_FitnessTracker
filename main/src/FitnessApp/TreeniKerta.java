package FitnessApp;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
 

/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class TreeniKerta {

	public int 		tkid;
	private int 		kid;
	public String 		PVM 			= "";
	
	static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

	private static int 	seuraavaNro 	= 1;
	
	
	public TreeniKerta() {
		
	}
//	Luo valitun treenikerran sekä antaa tarvittavat arvot
	 public void VastaaMalli() {
		 
//		 PVM
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
		 LocalDateTime now = LocalDateTime.now();  
		 String formattedDateTime = now.format(formatter);
		 this.PVM = formattedDateTime;
	        
	    }

//		Tulosta vastaanotettu käyttäjä

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", tkid) + " "+ kid+" "+PVM);
	}
	
//	Tulosta vastaanotettu käyttäjä ei käytössä vielä
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiteröi treenikerrat
	public int luo() {
		this.tkid = seuraavaNro;
		seuraavaNro++;
		return this.tkid;
	}
	
//	Hae TKID
	 public int getTKID() {
	        return tkid;
	    }
//Pääohjelma joka rekisteröi, vastaa sekä tulostaa treenikerrat

	public static void main(String[] args) {
		TreeniKerta eka = new TreeniKerta();
		TreeniKerta toka = new TreeniKerta();
		
		eka.luo();
		toka.luo();
//		
//		eka.VastaaMalli();
//		toka.VastaaMalli();
//		
		eka.tulosta(System.out);
		toka.tulosta(System.out);
		

		
	}

}
