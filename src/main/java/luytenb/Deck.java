package luytenb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Deck {
	
	@SuppressWarnings("unchecked")
	public void creerDeck(String nom, String desc) {
		
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(".//data//" + nom + ".json"));

			JSONObject deck = new JSONObject();
			deck.put("nom", nom);
			deck.put("desc", desc);
			deck.put("cartesRefs", null);

			writer.write(deck.toJSONString());
			
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
	
	@SuppressWarnings("unchecked")
	public void ajouterCarteAuDeck(String refCarte, String refDeck) {
		Writer writer = null;
		Reader reader = null;
		JSONObject deck;
		try {
			reader = new FileReader(".//data//" + refDeck + ".json");
			JSONParser parser = new JSONParser();
			deck = (JSONObject) parser.parse(reader);
			
			JSONObject deckvalue = (JSONObject) deck.get("cartesRefs");
			
			deckvalue.put("cartesRefs", refCarte);
			
			writer = new FileWriter(".//data//" + refDeck + ".json");
			writer.write(deckvalue.toJSONString());
			
		} catch (ParseException e) {
			e.printStackTrace();
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
	
	public void LireNomDeck(String refDeck) {
		Reader reader = null;
		JSONObject deck;
		try {
			reader = new FileReader(".//data//" + refDeck + ".json");
			JSONParser parser = new JSONParser();
			deck = (JSONObject) parser.parse(reader);
			
			String deckNom = (String) deck.get("desc");
			
			System.out.println(deckNom);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		
		
		finally {
			if (reader != null) {
				try {
					reader.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
		
	}
}
