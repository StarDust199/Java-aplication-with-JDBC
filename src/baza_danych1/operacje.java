package baza_danych1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class operacje {
/* wykonanie opercaji update, która urochomi trigger i zapisze to w tabeli  pracownik_log*/
	public static void updatePracownicy(Connection connection,  String imie)throws Exception{
		Statement stmt = connection.createStatement();
		
		
		PreparedStatement ps = connection.prepareStatement("update pracownicy1 set imie=?");
		ps.setNString(1,imie);
		
		ps.executeQuery();
	}

	public static void main(String[] args) {
		Connection connection=null;
		try {
			connection=baza.connect(conn.login, conn.passowrd);
			operacje.updatePracownicy(connection, "ADMI");
			System.out.println("Updated!");
			
		 
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
	} catch (Exception e) {
		System.err.println("The connection can not be closed.");
		e.printStackTrace();
	}


	}

}