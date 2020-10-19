import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;
	private JButton nappi1;
	private JButton nappi2;
	private JButton nappi3;
	private JTextPane txtpnKahvia;
	private JTextPane txtpnTee;
	private JTextPane txtpnKaakao;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JMenu jaMenu;
	private JMenuItem asetaKahvi;
	private JMenuItem asetaTee;
	private JMenuItem asetaKaakao;
	private JMenuItem Lopeta;
	private JMenu tietoja;
	private JMenuBar menuBar;
	private JMenuItem versionHallinta;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Juoma-automaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		jaMenu = new JMenu("Yll\u00E4pito");
		menuBar.add(jaMenu);
		jaMenu.setBackground(Color.WHITE);

		asetaKahvi = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		asetaKahvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Yll‰pitoikkunasta kahvin m‰‰r‰n asettaminen

				try {
					while (true) {
						String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
						int uusiKahvi = Integer.parseInt(uusiArvo);

						if (uusiKahvi < 250 && uusiKahvi > 0) {
							ja.setKahvi(uusiKahvi);

							label1.setText("Kahvi: " + uusiKahvi);
							label1.setForeground(Color.black);
							if (uusiKahvi <= 20) {
								label1.setForeground(Color.red);
							}
							break;
						} else if (uusiKahvi >= 250 || uusiKahvi <= 0) {
							JOptionPane.showMessageDialog(null, "Syˆt‰ uudelleen, vain arvot 0-250");
							continue;

						}
					}
				} catch (Exception i) {
					JOptionPane.showMessageDialog(null, "Tarkista syˆte, vain arvot 0-250");
				}

			}
		});
		jaMenu.add(asetaKahvi);

		asetaTee = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		asetaTee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Yll‰pitoikkunasta teen m‰‰r‰n asettaminen

				try {
					while (true) {
						String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
						int uusiTee = Integer.parseInt(uusiArvo);

						if (uusiTee < 250 && uusiTee > 0) {
							ja.setTee(uusiTee);

							label2.setText("Tee: " + uusiTee);
							label2.setForeground(Color.black);
							if (uusiTee <= 20) {
								label2.setForeground(Color.red);
							}
							break;
						} else if (uusiTee >= 250 || uusiTee <= 0) {
							JOptionPane.showMessageDialog(null, "Syˆt‰ uudelleen, vain arvot 0-250");
							continue;

						}
					}
				} catch (Exception i) {
					JOptionPane.showMessageDialog(null, "Tarkista syˆte, vain arvot 0-250");
				}

			}
		});
		jaMenu.add(asetaTee);

		asetaKaakao = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		asetaKaakao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Yll‰pitoikkunasta kaakaon m‰‰r‰n asettaminen

				try {
					while (true) {
						String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
						int uusiKaakao = Integer.parseInt(uusiArvo);

						if (uusiKaakao < 250 && uusiKaakao > 0) {
							ja.setKaakao(uusiKaakao);

							label3.setText("Kaakao: " + uusiKaakao);
							label3.setForeground(Color.black);
							if (uusiKaakao <= 20) {
								label3.setForeground(Color.red);
							}
							break;
						} else if (uusiKaakao >= 250 || uusiKaakao <= 0) {
							JOptionPane.showMessageDialog(null, "Syˆt‰ uudelleen, vain arvot 0-250");
							continue;

						}
					}
				} catch (Exception i) {
					JOptionPane.showMessageDialog(null, "Tarkista syˆte, vain arvot 0-250");
				}

			}
		});
		jaMenu.add(asetaKaakao);

		mntmTallennaAutomaatinTila = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Automaatin tilan tallennus

				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (Exception j) {

					System.out.println("Tallentaminen ei onnistu");
				}
			}
		});
		jaMenu.add(mntmTallennaAutomaatinTila);

		mntmLataaAutomaatti = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Automaatin tilan lataus

				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					int kahvi = uusi.getKahvi();
					ja.setKahvi(kahvi);
					label1.setText("Kahvi: " + kahvi);
					if (kahvi > 20) {
						label1.setForeground(Color.black);
					}

					int tee = uusi.getTee();
					ja.setTee(tee);
					label2.setText("Tee: " + tee);
					if (tee > 20) {
						label2.setForeground(Color.black);
					}

					int kaakao = uusi.getKaakao();
					ja.setKaakao(kaakao);
					label3.setText("Kaakao: " + kaakao);
					if (kaakao > 20) {
						label3.setForeground(Color.black);
					}

				} catch (Exception q) {
					System.out.println("Luku ei onnistunut.");
				}
			}
		});
		jaMenu.add(mntmLataaAutomaatti);

		Lopeta = new JMenuItem("Lopeta");
		Lopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// sulkee automaatin
				System.exit(0);
			}
		});
		jaMenu.add(Lopeta);

		tietoja = new JMenu("Tietoja ohjelmasta");
		menuBar.add(tietoja);

		versionHallinta = new JMenuItem("Versionhallinta");
		versionHallinta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot ikkuna = new Versiotiedot();
				ikkuna.setVisible(true);

			}
		});
		tietoja.add(versionHallinta);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nappi1 = new JButton("KahviNappi");
		nappi1.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img2/coffee.jpg")));
		nappi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Kahvin tilaaminen

				ja.valmistaKahvi();
				int KahviaJ‰ljell‰ = ja.getKahvi();
				ja.setKahvi(KahviaJ‰ljell‰);
				label1.setText("Kahvi: " + KahviaJ‰ljell‰);
				if (KahviaJ‰ljell‰ < 20) {
					label1.setForeground(Color.RED);
				}

			}
		});
		nappi1.setBounds(22, 66, 139, 132);
		contentPane.add(nappi1);

		// N‰ytt‰‰ uuden m‰‰r‰n
		label1 = new JLabel("Kahvi: " + ja.getKahvi());
		label1.setFont(new Font("Georgia", Font.PLAIN, 15));
		label1.setForeground(Color.BLACK);
		label1.setBounds(171, 121, 99, 20);
		contentPane.add(label1);

		txtpnKahvia = new JTextPane();
		txtpnKahvia.setForeground(Color.BLACK);
		txtpnKahvia.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtpnKahvia.setBackground(SystemColor.menu);
		txtpnKahvia.setText("Kahvi");
		txtpnKahvia.setBounds(22, 46, 63, 20);
		contentPane.add(txtpnKahvia);

		nappi2 = new JButton("TeeNappi");
		nappi2.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img2/tea.jpg")));
		nappi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Teen tilaaminen

				ja.valmistaTee();
				int Teet‰J‰ljell‰ = ja.getTee();
				ja.setTee(Teet‰J‰ljell‰);
				label2.setText("Tee: " + Teet‰J‰ljell‰);
				if (Teet‰J‰ljell‰ < 20) {
					label2.setForeground(Color.RED);
				}

			}
		});
		nappi2.setBounds(22, 250, 139, 132);
		contentPane.add(nappi2);

		// N‰ytt‰‰ uuden m‰‰r‰n
		label2 = new JLabel("Tee: " + ja.getTee());
		label2.setFont(new Font("Georgia", Font.PLAIN, 15));
		label2.setForeground(Color.BLACK);
		label2.setBounds(171, 305, 84, 20);
		contentPane.add(label2);

		txtpnTee = new JTextPane();
		txtpnTee.setForeground(Color.BLACK);
		txtpnTee.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtpnTee.setBackground(SystemColor.menu);
		txtpnTee.setText("Tee");
		txtpnTee.setBounds(22, 229, 52, 20);
		contentPane.add(txtpnTee);

		nappi3 = new JButton("KaakaoNappi");
		nappi3.setLocation(22, 437);
		nappi3.setSize(139, 132);
		nappi3.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img2/tea.jpg")));
		nappi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Kaakaon tilaaminen
				ja.valmistaKaakao();
				int KaakaotaJ‰ljell‰ = ja.getKaakao();
				ja.setKaakao(KaakaotaJ‰ljell‰);
				label3.setText("Kaakao: " + KaakaotaJ‰ljell‰);
				if (KaakaotaJ‰ljell‰ < 20) {
					label3.setForeground(Color.RED);
				}

			}
		});
		contentPane.add(nappi3);

		// N‰ytt‰‰ uuden m‰‰r‰n
		label3 = new JLabel("Kaakao: " + ja.getKaakao());
		label3.setFont(new Font("Georgia", Font.PLAIN, 15));
		label3.setForeground(Color.BLACK);
		label3.setBounds(171, 492, 118, 20);
		contentPane.add(label3);

		txtpnKaakao = new JTextPane();
		txtpnKaakao.setForeground(Color.BLACK);
		txtpnKaakao.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtpnKaakao.setBackground(SystemColor.menu);
		txtpnKaakao.setText("Kaakao");
		txtpnKaakao.setBounds(22, 416, 70, 20);
		contentPane.add(txtpnKaakao);

	}
}
