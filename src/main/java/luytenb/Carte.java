package luytenb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONObject;


public class Carte {
	
	String nom;
	String iconeSrc;
	String desc;
	
	
	@SuppressWarnings("unchecked")
	public void creerCarte(String nom, String iconName, String desc) {
		
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(".//data//" + nom + ".json"));

			JSONObject carte = new JSONObject();
			carte.put("nom", nom);
			carte.put("iconSrc", iconName);
			carte.put("desc", desc);

			writer.write(carte.toJSONString());
			
		} 
		catch (IOException e) {
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