package session6practice1database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionClosableResource {
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; 
	private static final String PASSWORD = ""; 

	public static void main(String[] args) {
		String sql="SELECT * FROM COUNTRIES";
	//----------Closable resource-----------------------	
		
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement statement = connection.createStatement(); 
			ResultSet resultset=statement.executeQuery(sql);)
		
		{   System.out.println("Connected to the H2 database successfully!");
        
          // Process the result set---------------------------------------
           while (resultset.next()) {
        	String id = resultset.getString("COUNTRY_ID");
            String name = resultset.getString("COUNTRY_NAME");
            System.out.println("ID: " + id + ", Name: " + name);
        }
			
			
		} catch (SQLException e) {
			System.out.println("we couldn't run your Sql statement");
			e.printStackTrace();
		}
		 

	}

}
