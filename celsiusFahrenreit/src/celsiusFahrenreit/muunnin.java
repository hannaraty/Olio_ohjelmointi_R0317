package celsiusFahrenreit;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class muunnin extends JFrame {
	
	JButton nappi;
	JLabel celsius, tulos;
	JTextField syöte;
	
	public muunnin() {
		
		getContentPane().setLayout(new GridLayout(2,2));
		celsius = new JLabel("Celsius");
		getContentPane().add(celsius);
		syöte = new JTextField();
		getContentPane().add(syöte);
		nappi = new JButton("Convert");
		getContentPane().add(nappi);
		
		nappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String numerot = syöte.getText();
				float desimaali= Float.parseFloat(numerot);
				double lasku = desimaali*1.8+32;
				tulos.setText("Fahrenheit: " + lasku);
			} catch(Exception i) {
				tulos.setText("Invalid input");
			}
			}
			});
		tulos = new JLabel();
		getContentPane().add(tulos);
	}
	
	public static void main(String args[]) {
		muunnin ikkuna = new muunnin();
		
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ikkuna.setVisible(true);
		ikkuna.pack();
		ikkuna.setTitle("Celsius Converter");
		ikkuna.setSize(300,100);
	}
	}

		
	
	
	
