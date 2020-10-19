import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;

public class Versiotiedot extends JFrame {
	private JTextPane txtpnJuomaautomaattiV;

	public Versiotiedot() {

		setTitle("Juoma-automaatti GUI v. 1.0");
		setBounds(100, 100, 400, 250);
		getContentPane().setLayout(null);

		txtpnJuomaautomaattiV = new JTextPane();
		txtpnJuomaautomaattiV.setBackground(SystemColor.menu);
		txtpnJuomaautomaattiV.setBounds(30, 57, 333, 104);
		txtpnJuomaautomaattiV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpnJuomaautomaattiV.setText("JUOMA-AUTOMAATTI V.1.0\r\n  TEKIJ\u00C4: HANNA R\u00C4TY");
		getContentPane().add(txtpnJuomaautomaattiV);

	}
}
