package FitnessApp;

import java.io.PrintStream;

/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Kayttaja {
	
	private int 	kid;
	private String 	nimi= "";
	private String 	sPosti = "";
	private String 	salasana = "";
	
	public Kayttaja() {
		
	}
	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", kid) + " "+ nimi+" "+sPosti);
	}
	
	public static void main(String[] args) {
		Kayttaja aku = new Kayttaja();
		Kayttaja aku2 = new Kayttaja();
		
//		aku.rekisteroi();
//		aku2.rekisteroi();
		
		aku.tulosta(System.out);
		aku2.tulosta(System.out);
		
//		aku.vastaaAkuAnkka();
//		aku2.vastaaAkuAnkka();
		
	}

}
