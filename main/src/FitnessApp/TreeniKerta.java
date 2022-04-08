package FitnessApp;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
 

/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class TreeniKerta {

	public int 		tkid;
	public int 		kid;
	public String 		PVM 			= "";
	
	static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

	private static int 	seuraavaNro 	= 1;
	
	
	public TreeniKerta() {
		
	}
//	Luo valitun treenikerran sekä antaa tarvittavat arvot
	 public void VastaaMalli() {
		 
//		 PVM
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
		 LocalDateTime now = LocalDateTime.now();  
		 String formattedDateTime = now.format(formatter);
		 this.PVM = formattedDateTime;
	        
	    }

//		Tulosta vastaanotettu käyttäjä

	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", tkid) + " "+ kid+" "+PVM);
	}
	
//	Tulosta vastaanotettu käyttäjä ei käytössä vielä
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}

//	Reksiteröi treenikerrat
    /**
     * 	Reksiteröi treenikerta
     * @return TKID
     * @example
     * <pre name="test">
     *   TreeniKerta testi = new TreeniKerta();
     *   testi.luo();
     *   testi.VastaaMalli();
     *   try {
		testi.tallenna();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     *   TreeniKerta testi1 = new TreeniKerta();
     *   testi1.luo();
     *   testi1.VastaaMalli();
     *   try {
		testi.tallenna();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     *   int n1 = testi.getTKID();
     *   int n2 = testi1.getTKID();
     *   n1 === n2-1;
     * </pre>
     */	
	public int luo() {
		try {
			this.tkid = haeSeuraavaNro()+1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.tkid;
	}
	
	private int haeSeuraavaNro() throws FileNotFoundException {
	    int i = 0;
	    int tulos = 0;
	    char t = 'a';
	    char t1 = 'a';
	    String yhd = "";
	    String nykyinen ="";
	    
	    
	    try  
	    	{  
	  FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treenikerrat.txt");       
	  Scanner sc=new Scanner(fis);   
	   
		while(sc.hasNextLine())  
		{  
			nykyinen = sc.nextLine();
		if (nykyinen.charAt(1) == ' ') {
			t = nykyinen.charAt(0);
  		System.out.println(t); 
		}
		else {
			t = nykyinen.charAt(0);
			t1 = nykyinen.charAt(1);
		}
			
			
//		System.out.println(sc.nextLine().charAt(0));   
		
}  
		sc.close();
}  
catch(IOException e)  
{  
e.printStackTrace();  
}  
if (t1 != 'a') {
	yhd = Character.toString(t) + Character.toString(t1);
	tulos = Integer.parseInt(yhd);
}
else {
  tulos = Character.getNumericValue(t);  
  System.out.println("saat tämän "+tulos); 
}

return tulos;
}
	
//	Hae TKID
	 public int getTKID() {
	        return tkid;
	    }
//Pääohjelma testaamiseen joka rekisteröi, vastaa sekä tulostaa treenikerrat

	public static void main(String[] args) {
		TreeniKerta eka = new TreeniKerta();
		TreeniKerta toka = new TreeniKerta();
		
		eka.luo();
		toka.luo();
		
		eka.VastaaMalli();
		toka.VastaaMalli();
		
		try {
		eka.tallenna();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		eka.tulosta(System.out);
		toka.tulosta(System.out);
		

		
	}
	
	
	public void tallenna() throws IOException {
	      Writer output;
	      output = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treenikerrat.txt", true));  
	      output.append(" \n"+ tkid + " "+ kid+" "+PVM);
	      output.close();
			
		}

}
