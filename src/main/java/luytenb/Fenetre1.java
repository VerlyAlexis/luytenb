package luytenb;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Fenetre1 {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	
	public static int allThreadsRunning = 1;

	/**
	 * Launch the application.
	 */
	public static void mainFenetre(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre1 window = new Fenetre1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenetre1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1249, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Luyten b");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		
		JButton btnNewButton_7 = new JButton("Activité Volcanique");
		btnNewButton_7.setAction(action);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Météorite");
		btnNewButton_6.setAction(action_1);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Déplacement des Pôles");
		btnNewButton_5.setAction(action_2);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Radioactivité");
		btnNewButton_4.setAction(action_3);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Produire des Ressources");
		btnNewButton_2.setAction(action_4);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Stabiliser l'Orbite");
		btnNewButton_3.setAction(action_5);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Refroidir la planète");
		btnNewButton.setAction(action_6);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Réchauffer la planète");
		btnNewButton_1.setAction(action_7);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		double tempo;
		tempo = lireFichierPlanete("temperature");
		JLabel lblNewLabel_1 = new JLabel("Température de Surface : " + tempo);
		ThreadUpdateFenetre1 ThreadUpdate1 = new ThreadUpdateFenetre1(lblNewLabel_1, "temperature");
		Thread ThreadUpdate1A = new Thread(ThreadUpdate1);
		ThreadUpdate1A.start();
		
		tempo = lireFichierPlanete("compEau");
		JLabel lblNewLabel_2 = new JLabel("Composition de la surface en Eau : " + tempo);
		ThreadUpdateFenetre1 ThreadUpdate2 = new ThreadUpdateFenetre1(lblNewLabel_2, "compEau");
		Thread ThreadUpdate2A = new Thread(ThreadUpdate2);
		ThreadUpdate2A.start();
		
		tempo = lireFichierPlanete("compOxygene");
		JLabel lblNewLabel_3 = new JLabel("Composition de l'air en Oxygène : " + tempo);
		ThreadUpdateFenetre1 ThreadUpdate3 = new ThreadUpdateFenetre1(lblNewLabel_3, "compOxygene");
		Thread ThreadUpdate3A = new Thread(ThreadUpdate3);
		ThreadUpdate3A.start();
		
		tempo = lireFichierPlanete("compCarbone");
		JLabel lblNewLabel_4 = new JLabel("Compostion de l'air en Carbone : " + tempo);
		ThreadUpdateFenetre1 ThreadUpdate4 = new ThreadUpdateFenetre1(lblNewLabel_4, "compCarbone");
		Thread ThreadUpdate4A = new Thread(ThreadUpdate4);
		ThreadUpdate4A.start();
		
		tempo = lireFichierPlanete("ressourcesUtilisees");
		JLabel lblNewLabel_5 = new JLabel("Ressources Consommables Utilisées : " + tempo);
		ThreadUpdateFenetre1 ThreadUpdate5 = new ThreadUpdateFenetre1(lblNewLabel_5, "ressourcesUtilisees");
		Thread ThreadUpdate5A = new Thread(ThreadUpdate5);
		ThreadUpdate5A.start();
		
		JButton btnNewButton_8 = new JButton("Recommencer une partie");
		btnNewButton_8.setAction(action_8);
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(192)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 499, Short.MAX_VALUE)
					.addComponent(btnNewButton_8)
					.addGap(252))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(143)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(btnNewButton_8))
					.addGap(18)
					.addComponent(lblNewLabel_5)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
	}
	
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Activité Volcanique");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_ActiviteVolcanique();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Météorite");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_Meteorite();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "Déplacement des Pôles");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_DeplacementDesPoles();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_3() {
			putValue(NAME, "Radioactivité");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_Radioactivite();
		}
	}
	private class SwingAction_4 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_4() {
			putValue(NAME, "Produire des Ressources");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_ProduireDesRessources();
		}
	}
	private class SwingAction_5 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_5() {
			putValue(NAME, "Stabiliser l'Orbite");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_StabiliserOrbite();
		}
	}
	private class SwingAction_6 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_6() {
			putValue(NAME, "Réchauffer la Planète");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_RechaufferLaPlanete();
		}
	}
	private class SwingAction_7 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_7() {
			putValue(NAME, "Refroidir la Planète");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_RefroidirLaPlanete();
		}
	}
	private class SwingAction_8 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_8() {
			putValue(NAME, "Quitter la partie et effacer les données");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			File fichierReset = new File(".//data//" + "PlaneteData" + ".json");
			allThreadsRunning = 0;
			fichierReset.delete();
			
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public void btn_ActiviteVolcanique() {
		if(lireFichierPlanete("temperature") < 0) {
			ecrireFichierPlanete("temperature", +25);
		}
		else {
			ecrireFichierPlanete("temperature", +10);
		}
		ecrireFichierPlanete("compCarbone", +20);
		ecrireFichierPlanete("compOxygene", -5);
	}

	public void btn_Meteorite() {
		if(lireFichierPlanete("temperature") > 0) {
			ecrireFichierPlanete("temperature", +30);
		}
		else {
			ecrireFichierPlanete("temperature", +5);
		}
		ecrireFichierPlanete("ressourcesUtilisees", +20);
		ecrireFichierPlanete("compEau", +10);
	}
	
	public void btn_DeplacementDesPoles() {
		ecrireFichierPlanete("temperature", -5);
		ecrireFichierPlanete("ressourcesUtilisees", +15);
		ecrireFichierPlanete("compEau", -20);
	}

	public void btn_Radioactivite() {
		ecrireFichierPlanete("temperature", +5);
		ecrireFichierPlanete("ressourcesUtilisees", +35);
	}

	public void btn_ProduireDesRessources() {
		ecrireFichierPlanete("ressourcesUtilisees", -25);
		ecrireFichierPlanete("compEau", +5);
		ecrireFichierPlanete("compOxygene", +5);
		ecrireFichierPlanete("compCarbone", -25);
	}

	public void btn_StabiliserOrbite() {
		ecrireFichierPlanete("compOxygene", +25);
		ecrireFichierPlanete("compCarbone", -5);
		ecrireFichierPlanete("temperature", +5);
	}

	public void btn_RechaufferLaPlanete() {
		ecrireFichierPlanete("temperature", +25);
		ecrireFichierPlanete("compEau", +10);
		ecrireFichierPlanete("ressourcesUtilisees", +5);
	}

	public void btn_RefroidirLaPlanete() {
		ecrireFichierPlanete("temperature", -20);
		ecrireFichierPlanete("compEau", -10);
		ecrireFichierPlanete("ressourcesUtilisees", +5);
	}

	public static double lireFichierPlanete(String ParametreChoisi) {
		Reader reader = null;
		JSONObject planetedata = null;
		double donneeDeSortie = 0;
		try {
			reader = new FileReader(".//data//" + "PlaneteData" + ".json");
			JSONParser parser = new JSONParser();
			planetedata = (JSONObject) parser.parse(reader);
			
			donneeDeSortie = (double) planetedata.get(ParametreChoisi);
			
			
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
		
		return donneeDeSortie;
		
	}
	
	public static String phraseDebut(String ParametreChoisi) {
		String PhraseDeDébut = null;
		if(ParametreChoisi == "temperature") {
			PhraseDeDébut = "Température de Surface :";
		}
		else if(ParametreChoisi == "compEau") {
			PhraseDeDébut = "Composition de la surface en Eau :";
		}
		else if(ParametreChoisi == "compOxygene") {
			PhraseDeDébut = "Composition de l'air en Oxygène :";
		}
		else if(ParametreChoisi == "compCarbone") {
			PhraseDeDébut = "Composition de l'air en Carbone :";
		}
		else if(ParametreChoisi == "ressourcesUtilisees") {
			PhraseDeDébut = "Ressources Consommables Utilisées :";
		}
		
		return PhraseDeDébut;
	}
	
	public static int getallThreadsRunning() {
		return allThreadsRunning;
	}
	
	@SuppressWarnings("unchecked")
	public static void ecrireFichierPlanete(String ParametreChoisi, float ValeurAffectee) {
		Reader reader = null;
		JSONObject planetedata;
		double temperature;
		double compEau;
		double compOxygene;
		double compCarbone;
		double ressourcesUtilisees;
		double donneeChangee;
		BufferedWriter writer = null;
		try {
			reader = new FileReader(".//data//" + "PlaneteData" + ".json");
			JSONParser parser = new JSONParser();
			planetedata = (JSONObject) parser.parse(reader);
			
			temperature = (double) planetedata.get("temperature");
			compEau = (double) planetedata.get("compEau");
			compOxygene = (double) planetedata.get("compOxygene");
			compCarbone = (double) planetedata.get("compCarbone");
			ressourcesUtilisees = (double) planetedata.get("ressourcesUtilisees");
			
			donneeChangee = (double) planetedata.get(ParametreChoisi);
			
			writer = Files.newBufferedWriter(Paths.get(".//data//" + "PlaneteData" + ".json"));
			
			JSONObject data = new JSONObject();
			
			data.put("temperature", temperature);
			data.put("compEau", compEau);
			data.put("compOxygene", compOxygene);
			data.put("compCarbone", compCarbone);
			data.put("ressourcesUtilisees", ressourcesUtilisees);
			
			double donneeFinale = donneeChangee+ValeurAffectee;
			
			if(ParametreChoisi == "compEau") {
				if(donneeFinale < 0) {
					donneeFinale = 0;
				}
				else if(donneeFinale > 100) {
					donneeFinale = 100;
				}
			}
			
			if(ParametreChoisi == "compOxygene") {
				if(donneeFinale < 0) {
					donneeFinale = 0;
				}
				else if(donneeFinale > 100) {
					donneeFinale = 100;
				}
			}
			
			if(ParametreChoisi == "compCarbone") {
				if(donneeFinale < 0) {
					donneeFinale = 0;
				}
				else if(donneeFinale > 100) {
					donneeFinale = 100;
				}
			}
			
			if(ParametreChoisi == "ressourcesUtilisees") {
				if(donneeFinale < 0) {
					donneeFinale = 0;
				}
				else if(donneeFinale > 100) {
					donneeFinale = 100;
				}
			}
			
			data.put(ParametreChoisi, donneeFinale);
			
			writer.write(data.toJSONString());
			
			
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
