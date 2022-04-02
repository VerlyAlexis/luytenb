package luytenb;

import java.util.ArrayList;

public class Planete {
	
	String nom;
	int temps;
	// Archéen, Protérozoïque, Cambrien, Ordovicien, Silurien, Dévonien, Carbonifère
	int stage;
	
	// Caractéristiques de la planète
	int taille;
	String gravite;
	int satellites;
	int illumination;
	
	float temperature;
	float compEau;
	float compOxygene;
	float compCarbone;
	float ressourcesUtilisees;
	
public ArrayList<String> statutsPlanete = new ArrayList<String>();
	
	// getters & setters

	public ArrayList<String> getStatutsPlanete() {
		return this.statutsPlanete;
	}
	
	public void ajouterStatut(String statut) {
		this.getStatutsPlanete().add(statut);
	}
		
	
	public Planete(String nom, int taille, int satellites, int illumination) { 		
		this.setNom(nom);
		this.setTaille(taille);
		this.setSatellites(satellites);
		this.setIllumination(illumination);
		
		// Ces valeurs sont les mêmes pour toutes les planètes
		this.setTemperature(150);
		this.setCompEau(20);
		this.setCompCarbone(80);
		this.setCompOxygene(0);
		this.setRessourcesUtilisees(0);
	}
	
	public void btn_ActiviteVolcanique() {
		this.modifyTemperature(+10);
		this.modifyRessourcesUtilisees(-10);
		this.modifyCompCarbone(+10);
		// Chance d'avoir un hiver volcanique
		double TempoNombre = Math.floor(Math.random()*(this.getCompCarbone()));
		int NombreFinal = (int) TempoNombre;
		//if(NombreFinal > 50) {
		//	this.addPlaneteStatus("Hiver Volcanique");
		//}
	}
}