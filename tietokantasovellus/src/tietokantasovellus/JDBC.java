package tietokantasovellus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://35.228.28.169/tietokanta";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "1234";
		
		public static void tallennaViini(viini vin) {
			
			int id = vin.getId();
			String tyyppi = vin.getTyyppi();
			String nimi = vin.getNimi();
			String valmistusMaa = vin.getValmistusMaa();
			int arvoSana = vin.getArvoSana();

			Connection conn = null;
			Statement stmt = null;
			try {

				System.out.println("Connecting to database...");

				// Luodaan yhteys tietokantaan
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// SQL Lausekkeen esittely, k‰ytet‰‰n ? muuttuvien tietojen kohdalla
				String sql = "INSERT INTO viini (id,tyyppi, nimi, valmistusmaa, arvosana) values (?,?,?,?,?)";

				// T‰ydennet‰‰n SQL-lauseisiin puuttuvat muuttujat
				PreparedStatement preparedStmt = conn.prepareStatement(sql);


				preparedStmt.setInt(1, id);
				preparedStmt.setString(2, tyyppi);
				preparedStmt.setString(3, nimi);
				preparedStmt.setString(4, valmistusMaa);
				preparedStmt.setInt(5, arvoSana);

				// Suorittaa SQL lauseen

				preparedStmt.execute();

				System.out.println("Saving data...");

			} catch (SQLException se) {
				// K‰sitell‰‰n tietokantavirheet
				se.printStackTrace();
			} catch (Exception e) {
				// Muut virheet
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} 
			} 

		}

		public static void lataaViinit() {

			Connection conn = null;
			Statement stmt = null;
			try {

				// Luodaan yhteys
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				System.out.println("Haetaan dataa...");

				// Suoritetaan SQL kysely
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM viini");

				// K‰yd‰‰n l‰pi tulosjoukko silmukassa
				while (rs.next()) {
					System.out.println(rs.getInt(1)+ "   " + rs.getString(2)+"  "+ rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getInt(5));

				}
				// Otetaan mahdolliset virheet kiinni
			} catch (SQLException se) {

				se.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} 
			} 

		}

		public static viini[] palautaViinit() {

			Connection conn = null;
			Statement stmt = null;

			// Tuloksena saadut viinit tallennetaan t‰h‰n

			viini[] pullot = null;

			try {

				// Luodaan yhteys
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				System.out.println("Haetaan dataa...");

				// Suoritetaan SQL kysely
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM viini");

				// K‰yd‰‰n l‰pi tulosjoukko silmukassa
				int i = 0;
				pullot = new viini[10];

				while (rs.next()) {
					System.out.println( rs.getInt(1)+ "   " + rs.getString(2)+"  "+ rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getInt(5));

					// Luodaan pullo-taulukkoon uusi viini joka silmukan iteraatiolla
					// , johon sijoitetaan tietokannasta ladatut arvot
					pullot[i] = new viini(Integer.parseInt(rs.getString(1)), rs.getString(2), (rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)));
					i++;
				}
				// Otetaan mahdolliset virheet kiinni
			} catch (SQLException se) {

				se.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} 
			} 

			return pullot;

		}


}
