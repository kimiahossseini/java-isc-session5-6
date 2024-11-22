package session6practice1database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatedata {
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; 
	private static final String PASSWORD = ""; 
	public static void main(String[] args) throws SQLException {
		  try (
	                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);                
	        		PreparedStatement preparedStatement = connection.prepareStatement(
	        				"UPDATE COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID = ?") 
	            ) {
	                System.out.println("Connected to the H2 database successfully!");

	                // Set the new country name and the country ID for the update
	                preparedStatement.setString(1, "IRAN"); // Set new COUNTRY_NAME
	                preparedStatement.setString(2, "IR"); // Set COUNTRY_ID to "IR"

	                // Execute the update operation
	                int rowsAffected = preparedStatement.executeUpdate();
	                System.out.println("Updated " + rowsAffected + " row(s) in the country table.");
	            } 
	        
	        
	    }

	}


