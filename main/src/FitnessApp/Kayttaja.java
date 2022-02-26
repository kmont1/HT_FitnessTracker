package FitnessApp;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;


/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Kayttaja {
	
	private int 		kid;
	private String 		nimi			= "";
	private String 		sPosti 			= "";
	private String 		salasana 		= "";
	
	private static int 	seuraavaNro 	= 1;
	
	
	public Kayttaja() {
		
	}
	
	 public void vastaaAkuAnkka() {

	        Random rand =new Random();
	        int randInt = rand.nextInt(100);
	        nimi = "Ankka Aku ";
	        sPosti 	= randInt+"aku.a@gmail.com" ;
	        salasana = "sdkladka";
	    }

	
	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", kid) + " "+ nimi+" "+sPosti);
	}
	
	
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

	
	public int rekisteroi() {
		this.kid = seuraavaNro;
		seuraavaNro++;
		return this.kid;
	}
	
	
	 public int getKid() {
	        return kid;
	    }


	public static void main(String[] args) {
		Kayttaja aku = new Kayttaja();
		Kayttaja aku2 = new Kayttaja();
		
		aku.rekisteroi();
		aku2.rekisteroi();
		
		aku.vastaaAkuAnkka();
		aku2.vastaaAkuAnkka();
		
		aku.tulosta(System.out);
		aku2.tulosta(System.out);
		

		
	}

}
