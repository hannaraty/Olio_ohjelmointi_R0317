package tietokantasovellus;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class Versiotiedot extends JFrame {
	private JTextPane txtpnViiniMaistelu;

	public Versiotiedot() {

		setTitle("Viinimaistelut GUI v. 1.0");
		setBounds(100, 100, 400, 250);
		getContentPane().setLayout(null);

		txtpnViiniMaistelu = new JTextPane();
		txtpnViiniMaistelu.setBackground(SystemColor.menu);
		txtpnViiniMaistelu.setBounds(30, 57, 333, 104);
		txtpnViiniMaistelu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpnViiniMaistelu.setText("VIINIMAISTELU V.1.0\r\n  TEKIJ\u00C4: HANNA R\u00C4TY");
		getContentPane().add(txtpnViiniMaistelu);

	}
}
