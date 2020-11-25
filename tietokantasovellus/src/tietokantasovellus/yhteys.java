package tietokantasovellus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class yhteys {

	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://35.228.28.169/tietokanta","root","1234");
			
			if(con!=null) {
		        System.out.println("Yhteys on muodostettu!");
		    }
		   Statement stmt=con.createStatement();
		   ResultSet rs=stmt.executeQuery("SELECT * FROM viini");
		   while(rs.next())
		 System.out.println(rs.getInt(1)+"   " + rs.getString(2)+"  "+ rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getInt(5));  
		   con.close();
		   
		    //varaudutaan virheisiin
		}catch(Exception e) {
		    System.out.println("Tapahtui virhe!");
		    e.printStackTrace();
		}
}
}
