package tietokantasovellus;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;


public class GUI extends JFrame {
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu tietoja;
	private JPanel panel;
	private JButton btn3_2;
	private JButton btn2;
	private JButton btn1;
	private JTable table;
	private JMenuItem versionHallinta;
	
	String[] sarakkeet = { "Lis‰ysj‰rjestys", "Tyyppi", "Viinin nimi", "Valmistusmaa", "Arvosanasi" };
	Object[][] data = {};
	
	
	
	public GUI(viini[] viiniTaulu) {
		
		setTitle("Viinimaistelut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 405);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lis\u00E4ysj\u00E4rjestys", "Tyyppi", "Viinin nimi", "Valmistusmaa", "Arvosanasi 1-5"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		
		if (viiniTaulu != null)
			tiedotTaulukkoon(viiniTaulu);
		
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btn1 = new JButton("Lis\u00E4\u00E4 rivi");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lisaaViini();
			}
		});
		panel.add(btn1);
		
		btn2 = new JButton("Poista rivi");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
                    poistaValitutRivit(table);
                } catch (SQLException e1) {
                    
                    e1.printStackTrace();
                }
			}
		});
		
		panel.add(btn2);
		
		btn3_2 = new JButton("Selaa Alkosta");
		btn3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String myurl = "https://www.alko.fi/tuotteet";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			
		});
		panel.add(btn3_2);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		tietoja = new JMenu("Tietoja ohjelmasta");
		menuBar.add(tietoja);
		
		versionHallinta = new JMenuItem("versionhallinta");
		menuBar.add(tietoja);

		versionHallinta = new JMenuItem("Versionhallinta");
		versionHallinta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot ikkuna = new Versiotiedot();
				ikkuna.setVisible(true);

			}
		});
		tietoja.add(versionHallinta);
		
	}


	


	private void tiedotTaulukkoon(viini[] viiniTaulu) {
	
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// K‰yd‰‰n viinitaulun l‰pi 
		for (int row = 0; row < viiniTaulu.length; row++) {

			if (viiniTaulu[row] != null) {
				
				// poimitaan tiedot muuttujiin
				
				int id = viiniTaulu[row].getId();
				String tyyppi = viiniTaulu[row].getTyyppi();
				String nimi = viiniTaulu[row].getNimi();
				String valmistusMaa = viiniTaulu[row].getValmistusMaa();
				int arvoSana = viiniTaulu[row].getArvoSana();

				// Lis‰t‰‰n tiedot taulukkoon
				
				model.addRow(new Object[] { id, tyyppi, nimi, valmistusMaa, arvoSana });
				
				System.out.println("Lis‰ttiin uusi " + tyyppi +": "+nimi);
			}

		}

	}

	// Lis‰t‰‰n uusi viini taulukkoon
	protected void lisaaViini() {

		// Uusi tyhj‰ viinolio
		viini uusi;

		// Luodaan uusi paneeli tietojen kysymist‰ varten

		JTextField id =  new JTextField(10);
		JTextField tyyppi = new JTextField(10);
		JTextField nimi = new JTextField(15);
		JTextField valmistusMaa = new JTextField(10);
		JTextField arvoSana = new JTextField(10); 
		
		JPanel myPanel = new JPanel();
		
		myPanel.add(new JLabel("J‰rjestysnumero:"));
		myPanel.add(id);
		
		myPanel.add(new JLabel("Viinin tyyppi:"));
		myPanel.add(tyyppi);

		myPanel.add(new JLabel("Viinin nimi:"));
		myPanel.add(nimi);

		myPanel.add(new JLabel("Valmistusmaa:"));
		myPanel.add(valmistusMaa);

		myPanel.add(new JLabel("Anna arvosana 1 - 5:")); 
		myPanel.add(arvoSana);

		

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Lis‰‰ viini: ", JOptionPane.OK_CANCEL_OPTION);

		

		// Jos paluuarvona on OK napin painallus,
		if (result == JOptionPane.OK_OPTION) {

			// Luodaan kenttien tietojen
			// pohjalta uusi viini-olio
			
			
			int uusiId = Integer.parseInt(id.getText());
			String uusiTyyppi = tyyppi.getText();
			String uusiNimi = nimi.getText();
			String uusiMaa = valmistusMaa.getText();
			int uusiArvo = Integer.parseInt(arvoSana.getText());

			// Sijoitetaan tiedot uuteen viini-olioon
			uusi = new viini(uusiId, uusiTyyppi, uusiNimi, uusiMaa, uusiArvo); // Code
																// changed
			// Tulostetaan testimieless‰ uusi viini konsoliin

			System.out.println(uusi);

			// Lis‰t‰‰n taulukkoon rivi, jossa taulukon tiedot ovat
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { uusi.getId(), uusi.getTyyppi(), uusi.getNimi(), uusi.getValmistusMaa(), uusi.getArvoSana() });
			
			JDBC.tallennaViini(uusi);
			
			JDBC.lataaViinit();

		}

	}

	// Poistaa valitut rivit
	private void poistaValitutRivit(JTable table) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int row = table.getSelectedRow();
        String eve = table.getValueAt(row, 0).toString();
        String delRow = "DELETE FROM viini WHERE id='" + eve+"'";
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.228.28.169/tietokanta", "root", "1234");

        if (row>=0) {
            model.removeRow(row);
            PreparedStatement ps = conn.prepareStatement(delRow);
            ps.executeUpdate();
            conn.close();
        }

    }
}



