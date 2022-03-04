package FitnessApp;
/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Kayttajat {

	private static final int MAX_JASENIA   = 1;
	private int              lkm           = 0;
	private String           tiedostonNimi = "";
	private Kayttaja         alkiot[]      = new Kayttaja[MAX_JASENIA];

	public int getLkm() {
	        return lkm;
	}

//	uusi alkio
	public Kayttajat() {
		alkiot = new Kayttaja[MAX_JASENIA];
	}
	
	
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
//jos ei tarpeeksi kohtia. ei k‰ytˆss‰
	 public Kayttaja anna(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || lkm <= i)
	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
	        return alkiot[i];
	    }

// p‰‰ohjelma joka tuo tarvittavat kayttajat. Luonti rekisterˆityminen sek‰ lis‰‰minen tapahtuu kayttaja aliohjelman kautta. 
	public static void main(String[] args) {
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
