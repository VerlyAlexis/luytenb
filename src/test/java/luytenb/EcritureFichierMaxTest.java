package luytenb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EcritureFichierMaxTest {
	
	@Test
	void LireUneDonnee() {
		Fenetre1.ecrireFichierPlanete("compEau", +1000);
		assertEquals(100, Fenetre1.lireFichierPlanete("compEau"));
	}
}