package FitnessApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;



/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Liike {
 
	private int 		lid;
	private int 		kid;
	public String 		nimi			= "";
	
	
	private static int 	seuraavaNro 	= 1;
	
	
	public Liike() {
		
	}
//	Luo valitunLiikeen sekä antaa tarvittavat arvot
	 public void vastaaLiikeNimi(String i) {
	        nimi = i;
	    }

//		Tulosta vastaanotettu Liike

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", lid) + " "+ nimi);
	}
	
//	Tulosta vastaanotettu Liike ei käytössä vielä
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiteröi Liike
	public int luoLiike() {
		this.lid = seuraavaNro;
		seuraavaNro++;
		return this.lid;
	}
	
//	Hae LID
	 public int getLid() {
	        return lid;
	    }
//Pääohjelma joka luo tarvittavat liikkeet

	public static void main(String[] args) {
		
		Liike eka = new Liike();
		Liike toka = new Liike();
		
		
		eka.luoLiike();
		toka.luoLiike();

		eka.vastaaLiikeNimi("Hauiskääntö");
		toka.vastaaLiikeNimi("penkki");
		
		
		eka.tulosta(System.out);
		toka.tulosta(System.out);
		
		

		
	}
	
	public void tallenna() throws IOException {
	      Writer output;
	      output = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treenikerrat.txt", true));  
	      output.append(" \n"+ kid + " "+ lid+" "+nimi);
	      output.close();
			
		}

}
