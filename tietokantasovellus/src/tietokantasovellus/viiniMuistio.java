package tietokantasovellus;

import javax.swing.JFrame;


public class viiniMuistio {

		// Alustetaan taulukko
		static viini viiniTaulu[];

		// Ohjelman p��metodi
		public static void main(String[] args) {

			// Ladataan viinien tiedot tietokannasta ja sijoitetaan viinitaulu -muuttujaan
			viiniTaulu = JDBC.palautaViinit();

			// Uutta ikkunaa piirrett�ess�, v�litet��n viinitaulun sis�lt� mukana
			JFrame ikkuna = new GUI( viiniTaulu );
			ikkuna.setVisible(true);
			

		}
	}


