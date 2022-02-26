package FitnessApp;
/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class Kayttajat {

	private static final int MAX_JASENIA   = 5;
	private int              lkm           = 0;
	private String           tiedostonNimi = "";
	private Kayttaja         alkiot[]      = new Kayttaja[MAX_JASENIA];

	public int getLkm() {
	        return lkm;
	}

	
	public Kayttajat() {
		alkiot = new Kayttaja[MAX_JASENIA];
	}
	
	
	 public void lisaa(Kayttaja kayttaja) {
		 if(lkm >=alkiot.length) return;
		 this.alkiot[this.lkm] = kayttaja;
		 lkm++;
	 }
	 
	 public Kayttaja anna(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || lkm <= i)
	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
	        return alkiot[i];
	    }

	 
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
		
		System.out.println("============= Jäsenet testi =================");

        for (int i = 0; i < kayttajat.getLkm(); i++) {
            Kayttaja kayttaja = kayttajat.anna(i);
            System.out.println("Jäsen nro: " + i);
            kayttaja.tulosta(System.out);
        }


	}

}
