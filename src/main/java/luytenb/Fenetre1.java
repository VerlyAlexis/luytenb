package luytenb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.Action;

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
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
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			lireFichierPlanete("Temperature");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_Meteorite();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SwingAction_2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_DeplacementDesPoles();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "SwingAction_3");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_Radioactivite();
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "SwingAction_4");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_ProduireDesRessources();
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "SwingAction_5");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_StabiliserOrbite();
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "SwingAction_6");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_RefroidirLaPlanete();
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "SwingAction_7");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			btn_RechaufferLaPlanete();
		}
	}

	public String lireFichierPlanete(String ParametreChoisi) {
		Reader reader = null;
		JSONObject planetedata;
		String donneeDeSortie = null;
		try {
			reader = new FileReader(".//data//" + "PlaneteData" + ".json");
			JSONParser parser = new JSONParser();
			planetedata = (JSONObject) parser.parse(reader);
			
			donneeDeSortie = (String) planetedata.get(ParametreChoisi);
			
			
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

	public String ecrireFichierPlanete(String ParametreChoisi, float ValeurAffectee) {
		Reader reader = null;
		JSONObject planetedata;
		float temperature;
		float compEau;
		float compOxygene;
		float compCarbone;
		float ressourcesUtilisees;
		try {
			reader = new FileReader(".//data//" + "PlaneteData" + ".json");
			JSONParser parser = new JSONParser();
			planetedata = (JSONObject) parser.parse(reader);
			
			temperature = (float) planetedata.get(ParametreChoisi);
			
			
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


	
}
