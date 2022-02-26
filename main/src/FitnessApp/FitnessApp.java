package FitnessApp;
/**
 * 
 * @author Khondker
 *
 */
public class FitnessApp {
	private Kayttajat kayttajat = new Kayttajat();
	
	public void lisaa(Kayttaja kayttaja) {
		kayttajat.lisaa(kayttaja);
	}
	
	
	 public int getKayttajia() {
	        return  kayttajat.getLkm();
	    }

	 public Kayttaja annaKayttaja(int i) {
	        return kayttajat.anna(i);
	    }

	/**
	 * 
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
		FitnessApp fitnessApp = new FitnessApp();
		Kayttaja aku = new Kayttaja();
		Kayttaja aku2 = new Kayttaja();
		
		aku.rekisteroi();
		aku2.rekisteroi();
		
		aku.vastaaAkuAnkka();
		aku2.vastaaAkuAnkka();
		
		fitnessApp.lisaa(aku);
		fitnessApp.lisaa(aku2);
		
		
		for (int i = 0; i < fitnessApp.getKayttajia(); i++) {
            Kayttaja kayttaja = fitnessApp.annaKayttaja(i);
            System.out.println("kayttaja paikassa: " + i);
            kayttaja.tulosta(System.out);
        }

	}

}
