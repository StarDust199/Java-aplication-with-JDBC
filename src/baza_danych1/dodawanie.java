package baza_danych1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class dodawanie {

	public static void insertA(Connection connection, String akcesoria_do_instr, String mundur,int pulpit )throws Exception{
		Statement stmt = connection.createStatement();
		
		
		/*przyk¹³dowe operacje na danych, np. dodawanie kolumny do wybranej tabeli*/
		PreparedStatement ps = connection.prepareStatement("INSERT INTO akcesoria11 (akcesoria_do_instr,mundur,pulpit) VALUES (?, ?, ?)");
		ps.setNString(1,akcesoria_do_instr);
		ps.setNString(2,mundur);
		ps.setInt(3, pulpit);
		ps.executeQuery();
	}

	public static void main(String[] args) {
		Connection connection=null;
		try {
			connection=baza.connect(conn.login, conn.passowrd);
			dodawanie.insertA(connection,"oliwka", "caly", 2);
			System.out.println("insert");
			
		 
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