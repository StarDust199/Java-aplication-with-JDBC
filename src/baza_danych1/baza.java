package baza_danych1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;


import oracle.jdbc.driver.OracleDriver;

public class baza {
	/*tworzenie polaczenia z baza*/
	
	public static Connection connect(String username, String password) throws SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1522:xe", username,
				password);
		return connection;
	}
	
	public static void checkLib() throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	
	public static ArrayList<String> executeQuery(Connection connection,String query)throws Exception{
		ArrayList<String> outRes=new ArrayList<String>();
		Statement stmt = null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		
		stmt = connection.createStatement();
		rs = stmt.executeQuery(query);
		rsmd = rs.getMetaData();
		
		int colNum = rsmd.getColumnCount();	
		StringBuilder tmp = null;
		while(rs.next()){
			tmp = new StringBuilder();
			for(int i=1;i<=colNum;i++){
				tmp.append(rs.getString(i));
				tmp.append("\t");
			}
			
			outRes.add(tmp.toString());
		}
		
		
		return outRes;
	}

	public static void main(String[] args) {
		Connection connection=null;
		System.out.println("SSSSSSSS");
		try {
			connection=baza.connect(conn.login, conn.passowrd);
		
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


	
	
	
	