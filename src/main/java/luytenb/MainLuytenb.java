package luytenb;

import java.io.File;

public class MainLuytenb {
	
	public static void main(String[] args) {
		
		File f = new File(".//data//" + "PlaneteData" + ".json");
		if(f.exists() && !f.isDirectory()) { 
			Fenetre1.mainFenetre(null);
		}
		else {
			FenetreChoixPlanetes.mainChoixPlanete(null);
		}
		
		//Carte carteTest = new Carte();
		//carteTest.creerCarte("TestNom2", "TestIconSrc", "Testdesc");
		
		//Deck deckTest = new Deck();
		//deckTest.creerDeck("DeckDeTest2", "Deck de test2");
		
		//deckTest.LireNomDeck("deckDeTest2");
		
		//deckTest.ajouterCarteAuDeck("TestNom2", "DeckDeTest2");
		
		
	}
}
