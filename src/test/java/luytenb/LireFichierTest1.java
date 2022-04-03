package luytenb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LireFichierTest1 {
	
	@Test
	void LireUneDonnee() {
		double donneeTestee1 = Fenetre1.lireFichierPlanete("temperature");
		Fenetre1.ecrireFichierPlanete("temperature", -10);
		assertEquals(donneeTestee1-10, Fenetre1.lireFichierPlanete("temperature"));
	}
}