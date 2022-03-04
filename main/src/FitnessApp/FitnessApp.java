package FitnessApp;
/**
 * 
 * @author Khondker
 *
 */
public class FitnessApp {
	private Kayttajat kayttajat = new Kayttajat();
//Lisaa kyseinen k�ytt�j� jonoon	
	public void lisaa(Kayttaja kayttaja) {
		kayttajat.lisaa(kayttaja);
	}
	
//hanki k�ytt�j� LKM	
	 public int getKayttajia() {
	        return  kayttajat.getLkm();
	    }
// kerro haluttu/valittu kaytt�j�
	 public Kayttaja annaKayttaja(int i) {
	        return kayttajat.anna(i);
	    }
//luo k�ytt�j�t sek� ohjaa luonti kayttaja lukan aliohjelmiin kuten rekisteroi, vastaaAkuAnkka sek� lisaa; kertoo my�skin ett� mik� k�ytt�j�n lakinumero on
	/**
	 * 
	 * @param args ei k�yt�ss�
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
