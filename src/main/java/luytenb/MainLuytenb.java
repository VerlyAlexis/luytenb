package luytenb;

public class MainLuytenb {
	
	public static void main(String[] args) {
		
		Planete luytenb = new Planete("Luytenb", 1, 0, 50);
		Fenetre1.mainFenetre(args);
		
		Carte carteTest = new Carte();
		carteTest.creerCarte("TestNom2", "TestIconSrc", "Testdesc");
		
		Deck deckTest = new Deck();
		deckTest.creerDeck("DeckDeTest2", "Deck de test2");
		
		deckTest.LireNomDeck("deckDeTest2");
		
		//deckTest.ajouterCarteAuDeck("TestNom2", "DeckDeTest2");
		
		
	}
}
