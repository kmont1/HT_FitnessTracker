package FitnessApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Kayttajat {

	private static final int MAX_JASENIA   = 1;
	private int              lkm           = 0;
	private String           tiedostonNimi = "";
	public Kayttaja         alkiot[]      = new Kayttaja[MAX_JASENIA];

	public int getLkm() {
	        return lkm;
	}

//	uusi alkio
	public Kayttajat() {
		
	}
	
    /**
     * Lis‰‰ uuden kayttaja tietorakenteeseen. 
     * @param treenikerta lis‰t‰‰v‰n treenikerta viite
     * @example
     * <pre name="test">
     * 
     * Kayttajat kayttajat = new Kayttajat();
     * Kayttaja eka = new Kayttaja();
     * Kayttaja toka = new Kayttaja();
     * kayttajat.getLkm() === 0;
     * eka.rekisteroi();
     * kayttajat.lisaa(eka);
     * kayttajat.getLkm() === 1;
     * toka.rekisteroi();
     * kayttajat.lisaa(toka);
     * kayttajat.getLkm() === 2;
     * eka.rekisteroi(); 
     * kayttajat.lisaa(eka);
     * kayttajat.getLkm() === 3;
     * kayttajat.anna(0) === eka;
     * kayttajat.anna(1) === toka;
     * kayttajat.anna(2) === eka;
     * kayttajat.anna(1) == eka === false;
     * kayttajat.anna(1) == toka === true;
     * </pre>
     */
	
	 public void lisaa(Kayttaja kayttaja) {
		 if(lkm >=alkiot.length) uusiAlkio();
		 this.alkiot[this.lkm] = kayttaja;
		 lkm++;
	 }
//	 Uuden alkion lis‰‰minen jos liian lyhyt ja t‰yttyy
	public void uusiAlkio() { 
		Kayttaja newArr[] = new Kayttaja[alkiot.length+1];
		 for (int i = 0; i < alkiot.length; i++)
	            newArr[i] = alkiot[i];
		  alkiot = newArr;
		  
		}
//anna i alkiot
	 public Kayttaja anna(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || lkm <= i)
	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
	        return alkiot[i];
	    }

	 
	
// p‰‰ohjelma joka tuo tarvittavat kayttajat. Luonti rekisterˆityminen sek‰ lis‰‰minen tapahtuu kayttaja aliohjelman kautta. 
	public static void main(String[] args) throws IOException {
		Kayttajat kayttajat = new Kayttajat();
		Kayttaja aku = new Kayttaja();
		Kayttaja aku2 = new Kayttaja();
		
		aku.rekisteroi();
		aku2.rekisteroi();
		
		aku.vastaaAkuAnkka();
		aku2.vastaaAkuAnkka();
		
		kayttajat.lisaa(aku);
		kayttajat.lisaa(aku2);
		kayttajat.lisaa(aku2);
		
		System.out.println("============= J‰senet testi =================");

		
        for (int i = 0; i < kayttajat.getLkm(); i++) {
            Kayttaja kayttaja = kayttajat.anna(i);
            System.out.println("J‰sen nro: " + i);
            kayttaja.tulosta(System.out);
            
        }
        
        
       
       
        
	}

}
