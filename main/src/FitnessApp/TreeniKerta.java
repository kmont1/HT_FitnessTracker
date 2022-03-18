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
	    
	    try  
	    	{  
	  FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treenikerrat.txt");       
	  Scanner sc=new Scanner(fis);   
	   
	    		while(sc.hasNextLine())  
	    		{  
	    			
//	    		System.out.println(sc.nextLine().charAt(0));   
	    		t = sc.nextLine().charAt(0);
	    		System.out.println(t); 
	  }  
	    		sc.close();
	}  
	catch(IOException e)  
	    {  
	   e.printStackTrace();  
	}  
	    
	    tulos = Character.getNumericValue(t);  
	    System.out.println("saat tämän "+tulos); 
		return tulos;
	}
	
//	Hae TKID
	 public int getTKID() {
	        return tkid;
	    }
//Pääohjelma joka rekisteröi, vastaa sekä tulostaa treenikerrat

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
