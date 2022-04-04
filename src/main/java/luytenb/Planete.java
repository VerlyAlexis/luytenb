package luytenb;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.simple.JSONObject;

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
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

		
	
	public Planete(String nom, int taille, int satellites, int illumination) { 		
		this.setNom(nom);
		this.setTaille(taille);
		this.setSatellites(satellites);
		this.setIllumination(illumination);
		
		// Chance d'avoir un hiver volcanique
		//double TempoNombre = Math.floor(Math.random()*(this.getCompCarbone()));
		//int NombreFinal = (int) TempoNombre;
		//if(NombreFinal > 50) {
		//	this.addPlaneteStatus("Hiver Volcanique");
		//}
	}
	
	@SuppressWarnings("unchecked")
	public void resetFichierPlanete(String PlaneteChoisie) {
		float temperature = 0;
		float compEau = 0;
		float compOxygene = 0;
		float compCarbone = 0;
		float ressourcesUtilisees = 0;
		if(PlaneteChoisie == "Luyten b") {
			temperature = 10;
			compEau = 50;
			compOxygene = 30;
			compCarbone = 30;
			ressourcesUtilisees = 0;
		}
		if(PlaneteChoisie == "TRAPPIST-1 d") {
			temperature = 80;
			compEau = 10;
			compOxygene = 0;
			compCarbone = 100;
			ressourcesUtilisees = 0;
		}
		if(PlaneteChoisie == "GJ 3323 b") {
			temperature = -60;
			compEau = 80;
			compOxygene = 10;
			compCarbone = 90;
			ressourcesUtilisees = 40;
		}
		if(PlaneteChoisie == "Kepler-438 b") {
			temperature = 250;
			compEau = 0;
			compOxygene = 0;
			compCarbone = 100;
			ressourcesUtilisees = 100;
		}
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(".//data//" + "PlaneteData" + ".json"));
			
			JSONObject data = new JSONObject();
			
			data.put("temperature", temperature);
			data.put("compEau", compEau);
			data.put("compOxygene", compOxygene);
			data.put("compCarbone", compCarbone);
			data.put("ressourcesUtilisees", ressourcesUtilisees);
			
			writer.write(data.toJSONString());
			
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		
		
		finally {
			if (writer != null) {
				try {
					writer.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
		
	}
}