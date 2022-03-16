package FitnessApp;
/**
 * 
 * @author Khondker
 *
 */
public class FitnessApp {
	private final Kayttajat kayttajat = new Kayttajat();
	private final Liikkeet liikkeet = new Liikkeet();
	private final TreeniKerrat treeniKerrat = new TreeniKerrat();
	private final Treenit treenit = new Treenit();
	
//Lisaa kyseinen käyttäjä jonoon	
	public void lisaa(Kayttaja kayttaja) {
		kayttajat.lisaa(kayttaja);
	}
	
	
//Lisaa kyseinen Liike jonoon	
	public void lisaaLiike(Liike liike) {
		liikkeet.lisaa(liike);
	}
	
	
//Lisaa kyseinen Treenikerta jonoon	
	public void lisaaTreeniKerta(TreeniKerta treeniKerta) {
		treeniKerrat.lisaa(treeniKerta);
		}
	
//Lisaa kyseinen Treeni jonoon	
		public void lisaaTreeni(Treeni treeni) {
			treenit.lisaa(treeni);
			}
	
	
//hanki käyttäjä LKM	
	 public int getKayttajia() {
		 return  kayttajat.getLkm();
	    }
	
	 
	 
//hanki Liike LKM	
	public int getLiikeet() {
		return  liikkeet.getLkm();
		}
	
	
//hanki Liike LKM	
	public int getTreeniKerrat() {
		return  treeniKerrat.getLkm();
		}

//hanki treeni LKM	
		public int getTreenit() {
			return  treenit.getLkm();
			}
	
	
// kerro haluttu/valittu kayttäjä
	 public Kayttaja annaKayttaja(int i) {
	        return kayttajat.anna(i);
	    }
	 
	 
// kerro haluttu/valittu liike
	public Liike annaLiike(int i) {
		    return liikkeet.anna(i);
		}
	

	// kerro haluttu/valittu liike
	public TreeniKerta annaTreeniKerta(int i) {
			return treeniKerrat.anna(i);
		}
	
// kerro haluttu/valittu treeeni
	public Treeni annaTreeni(int i) {
			return treenit.anna(i);
		}
				
	


	
	
//luo käyttäjät sekä ohjaa luonti kayttaja lukan aliohjelmiin kuten rekisteroi, vastaaAkuAnkka sekä lisaa; kertoo myöskin että mikä käyttäjän lakinumero on
	/**
	 * 
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
		FitnessApp fitnessApp = new FitnessApp();
//		KAYTTAJAT
		Kayttaja aku = new Kayttaja();
		Kayttaja aku2 = new Kayttaja();
		
		aku.rekisteroi();
		aku2.rekisteroi();
		
		aku.vastaaAkuAnkka();
		aku2.vastaaAkuAnkka();
		
// 		Liikeet
		Liike eka = new Liike();
		
		eka.luoLiike();
		
		eka.vastaaLiikeNimi("HAUISKÄÄNTÖ");
// 		Treenit			
		Treeni ekaTreeni = new Treeni();
		
		ekaTreeni.luoTreeni();
		
		ekaTreeni.vastaaAkunTreeni();
// 		TreeniKerrat		
		TreeniKerta tkEka = new TreeniKerta();
		
		tkEka.luo();
		
//		tkLisaaUlkoiset();
		
		tkEka.VastaaMalli();
		
//-------------------------------------------------------------------------------		
		fitnessApp.lisaa(aku);
		fitnessApp.lisaa(aku2);
		fitnessApp.lisaaLiike(eka);
		fitnessApp.lisaaLiike(eka);
		fitnessApp.lisaaTreeniKerta(tkEka);
		fitnessApp.lisaaTreeniKerta(tkEka);
		fitnessApp.lisaaTreeni(ekaTreeni);
		fitnessApp.lisaaTreeni(ekaTreeni);

		
		
		
		for (int i = 0; i < fitnessApp.getKayttajia(); i++) {
            Kayttaja kayttaja = fitnessApp.annaKayttaja(i);
            System.out.println("kayttaja paikassa: " + i);
            kayttaja.tulosta(System.out);
        }
		
		for (int i = 0; i < fitnessApp.getLiikeet(); i++) {
            Liike liike = fitnessApp.annaLiike(i);
            System.out.println("liike paikassa: " + i);
            liike.tulosta(System.out);
        }
		
		for (int i = 0; i < fitnessApp.getTreeniKerrat(); i++) {
            TreeniKerta treeniKerta = fitnessApp.annaTreeniKerta(i);
            System.out.println("Treenikerta paikassa: " + i);
            treeniKerta.tulosta(System.out);
        }
		
		for (int i = 0; i < fitnessApp.getTreenit(); i++) {
            Treeni treeni = fitnessApp.annaTreeni(i);
            System.out.println("Treenipaikassa: " + i);
            treeni.tulosta(System.out);
        }
		


	}

}
