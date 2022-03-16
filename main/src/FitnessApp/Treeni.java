package FitnessApp;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;


/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Treeni {
	
	public int 		tid;
	public int 		lid;
	public String 		sarjoja;
	public String 		toistoja;
	public String 		painot;
	public int 		tkid;

	
	private static int 	seuraavaNro 	= 1;
	
	
	public Treeni() {
		
	}
//	Luo valitun aku ankan sekä antaa tarvittavat arvot
	 public void vastaaAkunTreeni() {

	        Random rand =new Random();
	        int randInt = rand.nextInt(10);
//	        nimi = application.RekisteroidyController.get;
//	        sPosti 	= randInt+"aku.a@gmail.com" ;
//	        salasana = "sdkladka";
	        
	        sarjoja = "1";
	        toistoja 	= "44";
	        painot = "12";
	        
	    }

//		Tulosta vastaanotettu käyttäjä

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", tid) + " "+ lid+" "+painot+" "+sarjoja+" "+toistoja+" "+tkid);
	}
	
//	Tulosta vastaanotettu käyttäjä ei käytössä vielä
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiteröi käyttäjä
	public int luoTreeni() {
		this.tid = seuraavaNro;
		seuraavaNro++;
		return this.tid;
	}
	
//	Hae KID
	 public int getTid() {
	        return tid;
	    }
//Pääohjelma joka rekisteröi, vastaa sekä tulostaa käyttäjät

	public static void main(String[] args) {
		Treeni akunEka = new Treeni();
		Treeni akunToka = new Treeni();
		
		akunEka.luoTreeni();
		akunToka.luoTreeni();
		
		akunEka.vastaaAkunTreeni();
		akunToka.vastaaAkunTreeni();
		
		akunEka.tulosta(System.out);
		akunToka.tulosta(System.out);
		

		
	}

}
