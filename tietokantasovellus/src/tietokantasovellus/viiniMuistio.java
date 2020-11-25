package tietokantasovellus;

import javax.swing.JFrame;


public class viiniMuistio {

		// Alustetaan taulukko
		static viini viiniTaulu[];

		// Ohjelman päämetodi
		public static void main(String[] args) {

			// Ladataan viinien tiedot tietokannasta ja sijoitetaan viinitaulu -muuttujaan
			viiniTaulu = JDBC.palautaViinit();

			// Uutta ikkunaa piirrettäessä, välitetään viinitaulun sisältö mukana
			JFrame ikkuna = new GUI( viiniTaulu );
			ikkuna.setVisible(true);
			

		}
	}


