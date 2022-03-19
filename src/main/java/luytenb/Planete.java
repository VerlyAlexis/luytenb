package luytenb;

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
	int compEau;
	int compOxygene;
	int compCarbone;
	float ressourcesUtilisees;
	
	
	// getters & setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getGravite() {
		return gravite;
	}

	public void setGravite(String gravite) {
		this.gravite = gravite;
	}

	public int getSatellites() {
		return satellites;
	}

	public void setSatellites(int satellites) {
		this.satellites = satellites;
	}

	public int getIllumination() {
		return illumination;
	}

	public void setIllumination(int illumination) {
		this.illumination = illumination;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public int getCompEau() {
		return compEau;
	}

	public void setCompEau(int compEau) {
		this.compEau = compEau;
	}

	public int getCompOxygene() {
		return compOxygene;
	}

	public void setCompOxygene(int compOxygene) {
		this.compOxygene = compOxygene;
	}

	public int getCompCarbone() {
		return compCarbone;
	}

	public void setCompCarbone(int compCarbone) {
		this.compCarbone = compCarbone;
	}

	public float getRessourcesUtilisees() {
		return ressourcesUtilisees;
	}

	public void setRessourcesUtilisees(float ressourcesUtilisees) {
		this.ressourcesUtilisees = ressourcesUtilisees;
	}
	
	
	
	public Planete(String nom, int taille, int satellites, int illumination) { 		
		this.setNom(nom);
		this.setTaille(taille);
		this.setSatellites(satellites);
		this.setIllumination(illumination);
	}
	
	
}