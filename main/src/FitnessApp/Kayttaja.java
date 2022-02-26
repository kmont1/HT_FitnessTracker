package FitnessApp;

import java.io.OutputStream;
import java.io.PrintStream;

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
	
	
	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", kid) + " "+ nimi+" "+sPosti);
	}
	
	
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}
	 /**
     * Antaa jäsenelle seuraavan rekisterinumeron.
     * @return jäsenen uusi tunnusNro
     * @example
     * <pre name="test">
     *   Kayttaja aku1 = new Kayttaja();
     *   aku1.getKid() === 0;
     *   aku1.rekisteroi();
     *   Kayttaja aku2 = new Kayttaja();
     *   aku2.rekisteroi();
     *   int n1 = aku1.getKid();
     *   int n2 = aku2.getKid();
     *   n1 === n2-1;
     * </pre>
     */

	
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
		
		aku.tulosta(System.out);
		aku2.tulosta(System.out);
		
//		aku.vastaaAkuAnkka();
//		aku2.vastaaAkuAnkka();
		
	}

}
