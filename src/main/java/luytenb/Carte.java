package luytenb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Carte {
	
	String nom;
	String iconeSrc;
	String desc;
	
	public void creerCarte(String nom, String iconName, String desc) {
		
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(".//data//" + nom + ".json"));

			JsonObject carte = new JsonObject();
			carte.put("nom", nom);
			carte.put("iconSrc", iconName);
			carte.put("desc", desc);
			Jsoner.serialize(carte, writer);

			writer.close();

		} 
		catch (IOException ex) {
			ex.printStackTrace();
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