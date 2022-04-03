package luytenb;

import javax.swing.JLabel;

public class ThreadUpdateFenetre1 implements Runnable {
	
	private JLabel objetJLabel;
	private String donneeAUpdate;
	public ThreadUpdateFenetre1(JLabel référenceObjetJLabel, String stringDonneeAUpdate) {
		this.objetJLabel = référenceObjetJLabel;
		this.donneeAUpdate = stringDonneeAUpdate;
	}
	
	public void run() {
		while(true) {
			objetJLabel.setText(Fenetre1.phraseDebut(donneeAUpdate) + " " + Fenetre1.lireFichierPlanete(donneeAUpdate));
		}
	}
}