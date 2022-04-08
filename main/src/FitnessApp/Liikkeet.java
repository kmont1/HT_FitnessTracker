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
    /**
     * Lis‰‰ uuden liikkeen tietorakenteeseen.  Ottaa liikkeen omistukseensa.
     * @param liikkeen lis‰t‰‰v‰n liike viite
     * @example
     * <pre name="test">
     * 
     * Liikkeet Liikkeet = new Liikkeet();
     * Liike eka = new Liike();
     * Liike toka = new Liike();
     * Liikkeet.getLkm() === 0;
     * eka.luoLiike();
     * Liikkeet.lisaa(eka);
     * Liikkeet.getLkm() === 1;
     * toka.luoLiike();
     * Liikkeet.lisaa(toka);
     * Liikkeet.getLkm() === 2;
     * eka.luoLiike(); 
     * Liikkeet.lisaa(eka);
     * Liikkeet.getLkm() === 3;
     * Liikkeet.anna(0) === eka;
     * Liikkeet.anna(1) === toka;
     * Liikkeet.anna(2) === eka;
     * Liikkeet.anna(1) == eka === false;
     * Liikkeet.anna(1) == toka === true;
     * </pre>
     */
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
//etsi alkiosta haluttu liike. ei k‰ytˆss‰
	 public Liike anna(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || lkm <= i)
	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
	        return alkiot[i];
	    }

// p‰‰ohjelma joka tuo tarvittavat liikkeet. Luonti rekisterˆityminen sek‰ lis‰‰minen tapahtuu liikkeet aliohjelman kautta. 
	public static void main(String[] args) {
		Liikkeet Liikkeet = new Liikkeet();
		Liike eka = new Liike();
		Liike toka = new Liike();
		
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
