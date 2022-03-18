package FitnessApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
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
	
	
//	Luo valitun treenin sekä antaa tarvittavat arvot
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

//		Tulosta vastaanotettu treeni ja sen ominaisuudet

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", tid) + " "+ lid+" "+painot+" "+sarjoja+" "+toistoja+" "+tkid);
	}
	
//	Tulosta vastaanotettu treeni ei käytössä vielä
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiteröi treeni
	public int luoTreeni() {
		this.tid = seuraavaNro;
		seuraavaNro++;
		return this.tid;
	}
	
//	Hae tID
	 public int getTid() {
	        return tid;
	    }
//Pääohjelma joka rekisteröi, vastaa sekä tulostaa treeniy

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
