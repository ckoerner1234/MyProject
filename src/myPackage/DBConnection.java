package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public Statement connectToDatabase() throws SQLException{
		
		Statement stmt;

		try {
		    System.out.println("Loading driver...");
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new RuntimeException("Cannot find the driver in the classpath!", e);
		}
		
		String url = "jdbc:mysql://localhost:3306/SWE632database";
		String mysqlusername = "root";
		String mysqlpassword = "password";
		Connection connection = null;
		try {
		    System.out.println("Connecting database...");
		    connection = DriverManager.getConnection(url, mysqlusername, mysqlpassword);
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new RuntimeException("Cannot connect the database!", e);
		} 
		/*
		finally {
		    System.out.println("Closing the connection.");
		    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
		}
		*/

		stmt = connection.createStatement ();
		return stmt;

	}
}
