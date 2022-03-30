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
		try {
			this.tid = haeSeuraavaNro()+1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.tid;
	}

	
	
	private int haeSeuraavaNro() throws FileNotFoundException {
	    int i = 0;
	    int tulos = 0;
	    char t = 'a';
	    
	    try  
	    	{  
	  FileInputStream fis=new FileInputStream("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treeni.txt");       
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
	
//	Hae tID
	 public int getTid() {
	        return tid;
	    }
//Pääohjelma joka rekisteröi, vastaa sekä tulostaa treenit

	public static void main(String[] args) {
		Treeni akunEka = new Treeni();
		Treeni akunToka = new Treeni();
		
		akunEka.luoTreeni();
		akunToka.luoTreeni();
		
		akunEka.vastaaAkunTreeni();
		akunToka.vastaaAkunTreeni();
		
		try {
			akunEka.tallenna();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		akunEka.tulosta(System.out);
		akunToka.tulosta(System.out);
		
	}
	
	public void tallenna() throws IOException {
	      Writer output;
	      output = new BufferedWriter(new FileWriter("C:\\Users\\Khondker\\Dropbox\\HT_Alpha\\HT_FitnessTracker\\main\\Databases\\Treeni.txt", true));  
	      output.append(" \n"+ tid+" "+ lid + " "+ sarjoja+" "+painot+ " "+ tkid);
	      output.close();
			
		}
}
