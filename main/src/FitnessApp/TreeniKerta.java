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
//	Luo valitun treenikerran sek� antaa tarvittavat arvot
	 public void VastaaMalli() {
		 
//		 PVM
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
		 LocalDateTime now = LocalDateTime.now();  
		 String formattedDateTime = now.format(formatter);
		 this.PVM = formattedDateTime;
	        
	    }

//		Tulosta vastaanotettu k�ytt�j�

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", tkid) + " "+ kid+" "+PVM);
	}
	
//	Tulosta vastaanotettu k�ytt�j� ei k�yt�ss� viel�
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiter�i treenikerrat
	public int luo() {
		this.tkid = seuraavaNro;
		seuraavaNro++;
		return this.tkid;
	}
	
//	Hae TKID
	 public int getTKID() {
	        return tkid;
	    }
//P��ohjelma joka rekister�i, vastaa sek� tulostaa treenikerrat

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
