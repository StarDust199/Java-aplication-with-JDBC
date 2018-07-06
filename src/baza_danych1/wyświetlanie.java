package baza_danych1;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class wyœwietlanie {
public static void main(String[] args) {
		
		try {
			//check if the JDBC driver has been loaded
			baza.checkLib();
		} catch (ClassNotFoundException e) {
			System.err.println("The Oracle JDBC driver is unavailable.");
			e.printStackTrace();
			return;
		}
		
		Connection connection = null;
		ArrayList<String> re = null;
		 
		try {
			connection=baza.connect(conn.login, conn.passowrd);//establish connection
			 
			/*Wyœwietlanie danych z dowolnej tabeli*/
			 re = baza.executeQuery(connection, "Select * from akcesoria11");//execute simple query
			 //print results
			 for (String string : re) {
				 System.out.println(string);	
			 }
			 
			
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("The connection can not be closed.");
			e.printStackTrace();
		}

	}
}
