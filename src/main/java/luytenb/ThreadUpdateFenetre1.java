package luytenb;

import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

public class ThreadUpdateFenetre1 implements Runnable {
	
	private JLabel objetJLabel;
	private String donneeAUpdate;
	public ThreadUpdateFenetre1(JLabel r�f�renceObjetJLabel, String stringDonneeAUpdate) {
		this.objetJLabel = r�f�renceObjetJLabel;
		this.donneeAUpdate = stringDonneeAUpdate;
	}
	
	public void run() {
		while(Fenetre1.getallThreadsRunning() == 1) {
			try {
				objetJLabel.setText(Fenetre1.phraseDebut(donneeAUpdate) + " " + Fenetre1.lireFichierPlanete(donneeAUpdate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}