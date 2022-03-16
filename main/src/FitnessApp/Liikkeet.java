package FitnessApp;
/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Liikkeet {

	private static final int MAX_LIIKEET   = 1;
	private int              lkm           = 0;
	private String           tiedostonNimi = "";
	private Liike         alkiot[]= new Liike[MAX_LIIKEET];

	public int getLkm() {
	        return lkm;
	}

//	uusi alkio
	public Liikkeet() {
		alkiot = new Liike[MAX_LIIKEET];
	}
	
	
	 public void lisaa(Liike liike) {
		 if(lkm >=alkiot.length) uusiAlkio();
		 this.alkiot[this.lkm] = liike;
		 lkm++;
	 }
//	 Uuden alkion lis‰‰minen jos liian lyhyt ja t‰yttyy
	public void uusiAlkio() { 
		Liike newArr[] = new Liike[alkiot.length+1];
		 for (int i = 0; i < alkiot.length; i++)
	            newArr[i] = alkiot[i];
		  alkiot = newArr;
		  
		}
//jos ei tarpeeksi kohtia. ei k‰ytˆss‰
	 public Liike anna(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || lkm <= i)
	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
	        return alkiot[i];
	    }

// p‰‰ohjelma joka tuo tarvittavat kayttajat. Luonti rekisterˆityminen sek‰ lis‰‰minen tapahtuu kayttaja aliohjelman kautta. 
	public static void main(String[] args) {
		Liikkeet Liikkeet = new Liikkeet();
		Liike eka = new Liike();
		
		
		eka.luoLiike();
	
		
		eka.vastaaLiikeNimi("HAUISKƒƒNT÷");
		
		
		Liikkeet.lisaa(eka);
		Liikkeet.lisaa(eka);
		Liikkeet.lisaa(eka);

		
		System.out.println("============= J‰senet testi =================");

        for (int i = 0; i < Liikkeet.getLkm(); i++) {
        	Liike liike = Liikkeet.anna(i);
            System.out.println("J‰sen nro: " + i);
            liike.tulosta(System.out);
        }


	}

}
