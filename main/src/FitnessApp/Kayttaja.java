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
	public String 		nimi			= "";
	public String 		sPosti 			= "";
	public String 		salasana 		= "";
	
	private static int 	seuraavaNro 	= 1;
	
	
	public Kayttaja() {
		
	}
//	Luo valitun aku ankan sek� antaa tarvittavat arvot
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

//		Tulosta vastaanotettu k�ytt�j�

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", kid) + " "+ nimi+" "+sPosti);
	}
	
//	Tulosta vastaanotettu k�ytt�j� ei k�yt�ss� viel�
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiter�i k�ytt�j�
	public int rekisteroi() {
		this.kid = seuraavaNro;
		seuraavaNro++;
		return this.kid;
	}
	
//	Hae KID
	 public int getKid() {
	        return kid;
	    }
//P��ohjelma joka rekister�i, vastaa sek� tulostaa k�ytt�j�t

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
