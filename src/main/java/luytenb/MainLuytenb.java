// Lien github du projet (public) : https://github.com/VerlyAlexis/luytenb

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
		
	}
}
