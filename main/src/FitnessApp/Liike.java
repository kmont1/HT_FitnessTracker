package FitnessApp;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Scanner;



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
    /**
     * 		Reksiteröi liike
     * @return TID
     * @example
     * <pre name="test">
     *   Liike testi = new Liike();
     *   testi.luoLiike();
     *   testi.vastaaLiikeNimi("Hauiskääntö");
     *   		try {
			testi.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     *   Liike testi1 = new Liike();
     *   testi1.luoLiike();
     *   testi.vastaaLiikeNimi("Hauiskääntö");
     *   		try {
			testi1.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     *   int n1 = testi.getLid();
     *   int n2 = testi1.getLid();
     *   n1 === n2-1;
     * </pre>
     */	
	public int luoLiike(int kid) {

			try {
				this.lid = haeSeuraavaNro()+1;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		this.kid = kid;
		return this.lid;
	}
	
	private int haeSeuraavaNro() throws FileNotFoundException {
	    int tulos = 0;
	    String nykyinen ="";
	    try  
	    	{  
	  FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Liike.txt");       
	  Scanner sc=new Scanner(fis);   
	   
		while(sc.hasNextLine())  
		{  
			
			
			nykyinen = sc.nextLine();
			nykyinen = nykyinen.substring(0,3);
			tulos =  Integer.parseInt(nykyinen);

}  
		sc.close();
}  
catch(IOException e)  
{  
e.printStackTrace();  
}  

return tulos;
}
//	Hae LID
	 public int getLid() {
	        return lid;
	    }
//Pääohjelma joka luo tarvittavat liikkeet

	public static void main(String[] args) {
		
		Liike eka = new Liike();
		Liike toka = new Liike();
		
		
		eka.luoLiike(1);
		toka.luoLiike(2);

		eka.vastaaLiikeNimi("Hauiskääntö");
		toka.vastaaLiikeNimi("penkki");
		
		try {
			eka.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eka.tulosta(System.out);
		toka.tulosta(System.out);
		
		

		
	}
	/*
	 * Tallenna tarpeelliset tiedot 
	 */
	public void tallenna() throws IOException {
	      Writer output;
	      output = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Liike.txt", true));  
	      output.append(" \n"+ String.format("%03d", lid)+ " "+ String.format("%03d", kid)+" "+nimi);
	      output.close();
			
		}

}
