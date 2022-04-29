package FitnessApp;
/**
 *CRC-korttien kopioiminen 
 * @author Khondker
 *
 */
public class TreeniKerrat {

	private static final int MAX_ALKIO  = 1;
	private int              lkm           = 0;
	private String           tiedostonNimi = "";
	private TreeniKerta         alkiot[]      = new TreeniKerta[MAX_ALKIO];
//PalautaLKM
	public int getLkm() {
	        return lkm;
	}

//	uusi alkio
	public TreeniKerrat() {
		alkiot = new TreeniKerta[MAX_ALKIO];
	}
	
//lisaa alkio jos t‰ynn‰ 	
    /**
     * Lis‰‰ uuden treenikerta tietorakenteeseen.  Ottaa treenikerta omistukseensa.
     * @param treenikerta lis‰t‰‰v‰n treenikerta viite
     * @example
     * <pre name="test">
     * 
     * TreeniKerrat treeniKerrat = new TreeniKerrat();
     * TreeniKerta eka = new TreeniKerta();
     * TreeniKerta toka = new TreeniKerta();
     * treeniKerrat.getLkm() === 0;
     * eka.luo();
     * treeniKerrat.lisaa(eka);
     * treeniKerrat.getLkm() === 1;
     * toka.luo();
     * treeniKerrat.lisaa(toka);
     * treeniKerrat.getLkm() === 2;
     * eka.luo(); 
     * treeniKerrat.lisaa(eka);
     * treeniKerrat.getLkm() === 3;
     * treeniKerrat.anna(0) === eka;
     * treeniKerrat.anna(1) === toka;
     * treeniKerrat.anna(2) === eka;
     * treeniKerrat.anna(1) == eka === false;
     * treeniKerrat.anna(1) == toka === true;
     * </pre>
     */

	 public void lisaa(TreeniKerta treeniKerta) {
		 if(lkm >=alkiot.length) uusiAlkio();
		 this.alkiot[this.lkm] = treeniKerta;
		 lkm++;
	 }
//	 Uuden alkion lis‰‰minen jos liian lyhyt ja t‰yttyy
	public void uusiAlkio() { 
		TreeniKerta newArr[] = new TreeniKerta[alkiot.length+1];
		 for (int i = 0; i < alkiot.length; i++)
	            newArr[i] = alkiot[i];
		  alkiot = newArr;
		  
		}
//auttaa haussa. ei k‰ytˆss‰
	 public TreeniKerta anna(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || lkm <= i)
	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
	        return alkiot[i];
	    }

// p‰‰ohjelma joka tuo tarvittavat treenikerrat. Luonti rekisterˆityminen sek‰ lis‰‰minen tapahtuu treenikerrat aliohjelman kautta. 
	public static void main(String[] args) {
		TreeniKerrat treeniKerrat = new TreeniKerrat();
		
		TreeniKerta eka = new TreeniKerta();
		TreeniKerta toka = new TreeniKerta();
		
		eka.luo();
		toka.luo();
		
		eka.VastaaMalli();
		toka.VastaaMalli();


		
		treeniKerrat.lisaa(eka);
		treeniKerrat.lisaa(eka);
		treeniKerrat.lisaa(toka);
		
		System.out.println("============= J‰senet testi =================");

        for (int i = 0; i < treeniKerrat.getLkm(); i++) {
            TreeniKerta treenikerta = treeniKerrat.anna(i);
            System.out.println("alkio: " + i);
            treenikerta.tulosta(System.out);
        }


	}

}
